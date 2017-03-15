<%@page import="com.eiu.vcarpool.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/icons.css" />

</head>
<body>

<%-- 		
<%
Employee emp = (Employee)session.getAttribute("userName"); 
String username = emp.getUserName();
%> --%>


<div id="menu" align="right">
<ul>
<li><a href="hello.do">HOME</a></li>
<li> <a href="aboutUs.do">ABOUT US</a></li>
<li><a href="findCarpool.do">SEARCH</a></li>
<% if(null == session.getAttribute("userName")) 
{
%> 
<li><a href="addEiuEmployee.do">REGISTER</a></li>
<li><a href="loginform.do">LOGIN</a></li>
<%} else if(null !=session.getAttribute("userName")){ 
	Employee emp = (Employee)session.getAttribute("userName"); 
	String username = emp.getEmployeeName();
	String empStatus = emp.getEmpStatus();
	%>
	<!-- String username = emp.getUserName();%> -->
<li ><span style="text-transform:capitalize"><font color="orange">Welcome &nbsp; &nbsp; &nbsp;<% out.println(username); %></font></span></li></ul>

<ul>
<li><a href="inbox.do">INBOX</a>

<%if(!"provider".equalsIgnoreCase(empStatus)){ %>
<li><a href="addCarPool.do">ADD CARPOOL</a></li>
<%} %>
<%if("provider".equalsIgnoreCase(empStatus)){ %>
<li><a href="retrieveRiders.do">MANAGE CARPOOL</a></li>
<%} %>

<li><span id="logout_span" style=" color:orange"><a href="logout.do">LOGOUT</a></span></li>
<%} %>
</ul>
</div>			
</body>
</html>




