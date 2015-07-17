package com.service;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MemberDAO;
import com.dto.MemeberDTO;

public class MemberInsertCommand  {

	public void execute(HttpServletRequest request, HttpServletResponse response){
		
		  
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		MemeberDTO dto = new MemeberDTO();
		dto.setBirth(birth);
		dto.setEmail(email);
		dto.setId(id);
		dto.setName(name);
		dto.setPass(pass);
		dto.setTel(tel);
		
		MemberDAO dao = new MemberDAO();
		//int n = dao.insert(dto);// DB에 정보가들어갓는지 확인..
		
		System.out.println(dto.getId()+dto.getPass() );
		
		int n = 0;
		int p= dao.idcheck(dto); // n:1 있다
		System.out.println("중복체크 >> "+p);
		if(p>1){n=3;}
		else{
			n =dao.insert(dto);
		}
		System.out.println("입력채크 >> "+n);
		
		
		request.setAttribute("n",n);
		
		System.out.println(dto.toString()+n);
		
		
	}
}
