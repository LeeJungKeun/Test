<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- <% System.out.println("user : " + ((Integer)request.getSession().getAttribute("userNo")).intValue()); 
	
int n = (int)(request.getSession().getAttribute("userNo"));
System.out.println("n : "  +n);
%> --%>
<body>
<%-- <%=n %> --%>
${userNo }
<a href='insertTeam.jsp'><input type="submit" value="팀만들기" /></a>
<form action="/EA/FrontControl/searchTeam" method='post'>
<input type="submit" value="팀가입하기" />
</form>
</body>
</html>