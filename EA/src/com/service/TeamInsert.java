package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dao.MemberDAO;
import com.dto.TeamDTO;

public class TeamInsert {
	public void execute(HttpServletRequest request, HttpServletResponse response){

		HttpSession session = request.getSession(); 
		
		String teamName = request.getParameter("teamName");
		String teamAddr = request.getParameter("teamAddr");
		int playerNo = Integer.parseInt(request.getParameter("playerNo"));
		int bossNo = (int)session.getAttribute("userNo");
		
		TeamDTO dto = new TeamDTO();
		dto.setTeamName(teamName);
		dto.setTeamAddr(teamAddr);
		dto.setPlayerNo(playerNo);
		dto.setBossNo(bossNo);
		
		System.out.println(" 세션값 받기 >>>"+bossNo);
		
		System.out.println(dto.toString());
		
		MemberDAO dao = new MemberDAO();
		int n = dao.insertTeam(dto);
		
		
	}
}
