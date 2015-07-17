package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TeamDAO;
import com.dto.TeamDTO;

public class TeamSearch {
	
	public void excute(HttpServletRequest request,HttpServletResponse response){
		String searchName = request.getParameter("searchName");
		System.out.println(searchName);
		
		
		if(searchName==null){ searchName=null;}
		TeamDAO dao = new TeamDAO();
		TeamDTO dto = new TeamDTO();
		List<TeamDTO> list = null;
		list = dao.searchTeam(searchName);
		
		System.out.println(list.toString());
		
		request.setAttribute("teamName", list);
		
	}

}
