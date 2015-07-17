package com.dto;

import java.util.List;

public class PageDTO {
	int perPage =3; //페이지당 보여줄 갯수
	int curPage;
	int totalCount;
	List<MemeberDTO> list;
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<MemeberDTO> getList() {
		return list;
	}
	public void setList(List<MemeberDTO> list) {
		this.list = list;
	}
	
	
	
	
}
