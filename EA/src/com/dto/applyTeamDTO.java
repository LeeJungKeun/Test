package com.dto;



public class applyTeamDTO {

	
	String  teamNo;
	String  applyPlayer;
	String  startTime;
	String  endTime;
	String  stadiumName;
	
	public applyTeamDTO() {
		super();
	}
	


	
	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}


	public String getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(String teamNo) {
		this.teamNo = teamNo;
	}

	public String getApplyPlayer() {
		return applyPlayer;
	}
	public void setApplyPlayer(String applyPlayer) {
		this.applyPlayer = applyPlayer;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
	
}
