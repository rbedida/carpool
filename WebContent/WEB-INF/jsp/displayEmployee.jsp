<%@page import="com.eiu.vcarpool.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Insert title here</title>
</head>
<body>
	<div id="body" style="width: 100%; align: left">
		<form:form action="" commandName="employee">

			<div id="showEmployeeContainer">
				<table id="showEmployee" cellspacing="0" cellpadding="0"
					align="left" width="90%" class="display">
					<thead>
						<tr>


							<th>Name</th>
							<th>Email Id</th>
							<th>Phone Number</th>
							<th>Designation</th>
							<th>Gender</th>

						</tr>
					</thead>

					<tbody>
						<c:forEach items="${employeeDetails}" var="employee">
							<tr>

								<td>${employee.employeeName}</td>
								<td>${employee.emailId}</td>
								<td>${employee.phoneNumber}</td>
								<td>${employee.designation}</td>
								<td>${search.gender}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form:form>
	</div>

</body>
</html>