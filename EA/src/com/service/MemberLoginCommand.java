package com.service;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MemberDAO;
import com.dto.MemeberDTO;

public class MemberLoginCommand  {

	public void execute(HttpServletRequest request, HttpServletResponse response){
		
		  
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String aaaaa;
		MemeberDTO dto = new MemeberDTO();
		dto.setId(id);
		dto.setPass(pass);

		
		MemberDAO dao = new MemberDAO();
		//int n = dao.insert(dto);// DB에 정보가들어갓는지 확인..
		
		System.out.println(dto.getId()+dto.getPass() );
		
		int n = dao.login(dto);
		System.out.println("서비스 n리턴값 >> "+n);

		
		
		request.setAttribute("n",n);
		
		
	}
}
