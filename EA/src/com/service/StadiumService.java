package com.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StadiumDAO;
import com.dto.StadiumDTO;
import com.dto.applyTeamDTO;

public class StadiumService {

	public void excute(HttpServletRequest request,HttpServletResponse response)  {
		 
		StadiumDAO dao = new StadiumDAO();
		List<StadiumDTO> list;
		list = dao.getStadiumList();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("stadium", list);
		
	}
	
	public void addApplyTeam(HttpServletRequest request,HttpServletResponse response){
		
		String  stadiumName= request.getParameter("stadium_Name");
		String  teamNo= request.getParameter("teamNo");
		String  applyPlayer= request.getParameter("applyPlayer");
		String  startTime= request.getParameter("startTime");
		String  endTime= request.getParameter("endTime");

		System.out.println("stadiumName\t\t\t"+stadiumName);
		System.out.println("teamNo\t"+teamNo);
		applyTeamDTO dto = new applyTeamDTO();
		dto.setApplyPlayer(applyPlayer);
		dto.setEndTime(endTime);
		dto.setStadiumName(stadiumName);
		dto.setStartTime(startTime);
		dto.setTeamNo(teamNo);
		
		System.out.println(dto.toString());
		StadiumDAO dao = new StadiumDAO();
		int n =dao.applyTeamList(dto);
      
	}
	
	
}
