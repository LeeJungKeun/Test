<%@page import="java.util.List"%>
<%@page import="com.dto.TeamDTO"%>
<%@page import="com.dto.MemeberDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="/EA/FrontControl/searchTeam" method="post">
		팀 가입하기<br> 
		<input type='text' name="searchName">&nbsp;&nbsp;&nbsp;
		<input type='submit' value='팀검색' >
	</form>
	
	
	<table border="2" >
	<tr>
		<th>팀번호</th>
		<th>팀이름</th>
		<th>플레이어 수</th>
		
	</tr>
	
<%
	List<TeamDTO> list = (List<TeamDTO>)request.getAttribute("teamName");
	for(TeamDTO dto : list){
		int teamNo= dto.getTeamNo();
		String teamName=dto.getTeamName();
		int playerNum = dto.getPlayerNo();
%>
	<tr>
		<td><%=teamNo %></td>
		<td><%=teamName%></td>
		<td><%=playerNum%></td>
	</tr>

<% 	
	}
%> 

	<input type='submit' value='가입하기'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type='reset' value='다시찾기'>


</body>
</html>