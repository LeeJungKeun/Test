package com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.MemberInsertCommand;
import com.service.MemberLoginCommand;
import com.service.StadiumService;
import com.service.TeamInsert;
import com.service.TeamSearch;

@WebServlet("/FrontControl/*")
public class FrontControl extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		System.out.println("getRequestURI > " + requestURI);
		String contextPath = request.getContextPath();
		System.out.println("contextPath > " + contextPath);
		String servletPath = request.getServletPath();
		System.out.println("servletPath > " + servletPath);
		String com = requestURI.substring(contextPath.length());
		System.out.println(com);
		String action = com.substring(servletPath.length());
		System.out.println("action"+action); // list

		if("/St".equals(action)){
			StadiumService servi = new StadiumService();
			servi.excute(request, response);
			
			response.sendRedirect("/EA/01stationMap/Stadium.jsp");
			
		}
		if("/addApplyTeam".equals(action)){
			StadiumService servi = new StadiumService();
			servi.addApplyTeam(request, response);
			
			response.sendRedirect("/EA/FrontControl/St");
		}
		
		// 1.목록보기 1) localhost:8090/day12_Bord/Control?action=list
		// 2) localhost:8090/day12_Bord/Control/list

		if ("/insert".equals(action)) {
			MemberInsertCommand service = new MemberInsertCommand();
			service.execute(request, response);

			int n = (int) request.getAttribute("n");// 1
			System.out.println("값이 넘어오냐 >> " + n);
			if (n == 3) {// id 중복
				System.out.println("아이디 중복!!");
				RequestDispatcher dis = request
						.getRequestDispatcher("/index.jsp"); // /를 붙히면 context까지
																// 라고 알려준다.
				dis.forward(request, response);
			} else if (n == 1) { // 성공
				System.out.println("성공 !!");
				response.sendRedirect("../index.jsp");
			} else {
				System.out.println("실패!!");
				response.sendRedirect("../index.jsp");
			}

		}
		if ("/searchTeam".equals(action)) {
			System.out.println("searchTeam");
			TeamSearch service = new TeamSearch();
			service.excute(request, response);
			
			RequestDispatcher dis = request.getRequestDispatcher("../searchJoin.jsp");
			dis.forward(request, response);

			
		}

		if ("/insertTeam".equals(action)) {

			TeamInsert service = new TeamInsert();
			service.execute(request, response);

			int n = (int) request.getAttribute("n");
			System.out.println("n 값 >> " + n);

			if (n != 0) {
				System.out.println("로그인 성공");
				/*
				 * RequestDispatcher dis =
				 * request.getRequestDispatcher("/home.jsp"); // /를 붙히면
				 * context까지 라고 알려준다. dis.forward(request, response);
				 */
				response.sendRedirect("../home.jsp");
			} else {
				System.out.println("로그인 실패");
				response.sendRedirect("../index.jsp");
				/*
				 * RequestDispatcher dis =
				 * request.getRequestDispatcher("../index.jsp"); // /를 붙히면
				 * context까지 라고 알려준다. dis.forward(request, response);
				 */
			}
		}

		if ("/login".equals(action)) {
			System.out.println("컨트롤러 시작 >> ");

			MemberLoginCommand service = new MemberLoginCommand();
			service.execute(request, response);

			int n = (int) request.getAttribute("n");
			System.out.println("n 값 >> " + n);

			if (n != 0) {
				// HttpSession session = request.getSession(); //없으면 생성
				System.out.println("로그인, 세션저장 전");
				HttpSession session = request.getSession(); // 없으면 생성
				session.setAttribute("userNo", n);
				System.out.println("로그인, 세션저장 성공"
						+ request.getSession().getAttribute("userNo"));
				/*
				 * RequestDispatcher dis =
				 * request.getRequestDispatcher("/home.jsp"); // /를 붙히면
				 * context까지 라고 알려준다. dis.forward(request, response);
				 */
				response.sendRedirect("../home.jsp");
			} else {
				System.out.println("로그인 실패");
				response.sendRedirect("../index.jsp");
				/*
				 * RequestDispatcher dis =
				 * request.getRequestDispatcher("../index.jsp"); // /를 붙히면
				 * context까지 라고 알려준다. dis.forward(request, response);
				 */
			}
			
			
			
		}

	}

}
