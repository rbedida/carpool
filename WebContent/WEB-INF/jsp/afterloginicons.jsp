<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.eiu.vcarpool.dto.Employee"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/icons.css" />
<style type="text/css">
#menu a {
	text-decoration: none;
	color: black;
	padding: 8px 8px 8px 8px;
}
</style>
</head>
<body>

	<%
Employee emp = (Employee)session.getAttribute("userName"); 
String username = emp.getUserName();
%>

	<div id="menu">
		<ul>
			<li><font color="red">Welcome <% out.println(username); %></font></li>
		</ul>
		<ul>
			<li><a href="hello.do">HOME</a></li>
			<li><a href="aboutUs.do">ABOUT US</a></li>
			<li><a href="findCarpool.do">SEARCH</a></li>
			<li><a href="logout.do">LOGOUT</a></li>

			<li><a href="addCarPool.do">ADD CARPOOL</a></li>

			<li><a href="inbox.do">INBOX</a> <!-- <li><a href="loginform.do">LOGIN</a></li> -->
		</ul>
	</div>
</body>
</html>