<%@page import="com.eiu.vcarpool.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="body" style="width: 100%; align: left">
		

			<div id="showEmployeeContainer">
				<table id="showEmployee" cellspacing="0" cellpadding="0"
					align="left" width="90%" class="display">
					
					<%
	Employee emp = (Employee)session.getAttribute("userName"); 
String emplStatus = emp.getEmpStatus();
%>
<c:set var="emplStatus" value="<%= emplStatus%>"/>

<c:if test="${emplStatus eq 'provider'} ">
all
</c:if> 
					<tbody>
						<c:forEach items="${listOfMessages}" var="employee">
							<tr>
							
							<c:if test="${emplStatus == 'provider' && employee.status=='pending'}" >
							<td align="center"><span style="color: red;font-size: 1.5em">${employee.senderName}</span><span style="font-size: 1.5em"> requested on your carpool</span> <a href="accept.do?id=${employee.senderName}" >accept</a>  <a href="decline.do?id=${employee.senderName}" >decline</a></td>
							</c:if>
							
							<c:if test="${emplStatus != 'provider' && employee.status=='pending'}" >
							<td align="center"><span style="font-size: 1.5em"> you requested for</span> <span style="color: red;font-size: 1.5em">${employee.receiverName} 's carpool</span></td>
							</c:if>
							
							<c:if test="${emplStatus == 'provider' && employee.status=='accepted'}" >
							<td align="center"><span style="font-size: 1.5em">You have accepted the request of </span><span style="color: red;font-size: 1.5em">${employee.senderName}</span></td>
							</c:if>
							<c:if test="${emplStatus != 'provider' && employee.status=='accepted'}" >
							<td align="center"><span style="color: red;font-size: 1.5em">${employee.senderName}</span><span style="font-size: 1.5em"> has accepted your request</span> </td>
							</c:if>
							<c:if test="${emplStatus == 'provider' && employee.status=='rejected'}" >
							<td align="center"><span style="color: red;font-size: 1.5em">${employee.senderName}</span><span style="font-size: 1.5em"> request is declined by you</span> </td>
							</c:if>
							<c:if test="${emplStatus != 'provider' && employee.status=='rejected'}" >
							<td align="center"><span style="color: red;font-size: 1.5em">${employee.senderName}</span><span style="font-size: 1.5em"> has declined your request</span> </td>
							</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		
	</div>

</body>
</html>