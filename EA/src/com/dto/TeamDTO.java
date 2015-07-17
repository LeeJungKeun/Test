package com.dto;

public class TeamDTO {
	int teamNo ;
	String teamName;
	String teamAddr;
	int playerNo;
	int bossNo;
	public TeamDTO(int teamNo, String teamName, String teamAddr, int playerNo,
			int bossNo) {
		super();
		this.teamNo = teamNo;
		this.teamName = teamName;
		this.teamAddr = teamAddr;
		this.playerNo = playerNo;
		this.bossNo = bossNo;
	}
	public TeamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTeamNo() {
		return teamNo;
	}
	@Override
	public String toString() {
		return "TeamDTO [teamNo=" + teamNo + ", teamName=" + teamName
				+ ", teamAddr=" + teamAddr + ", playerNo=" + playerNo
				+ ", bossNo=" + bossNo + "]";
	}
	public void setTeamNo(int teamNo) {
		this.teamNo = teamNo;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamAddr() {
		return teamAddr;
	}
	public void setTeamAddr(String teamAddr) {
		this.teamAddr = teamAddr;
	}
	public int getPlayerNo() {
		return playerNo;
	}
	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}
	public int getBossNo() {
		return bossNo;
	}
	public void setBossNo(int bossNo) {
		this.bossNo = bossNo;
	}
	
	
	
}
