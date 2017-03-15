<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Creating Popup</title>
<link href="css/popup.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js">
	
</script>
<script type="text/javascript" src="js/popup.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/popup.css" />

</head>
<body>
	<div id="popEnableCustom">
		<a id="connect1" href="#" class="topopup"></a>

		<div id="toPopup">

			<div class="close"></div>
			<span class="ecs_tooltip">Press Esc to close <span
				class="arrow"></span></span>
			<div id="popup_content">
				<!--your content start-->
				<div class="datagrid">
					<table>
						<thead>
							<tr>

								<th>Name</th>
								<th>email</th>
								<th>phoneNumber</th>
								<th>userName</th>
								<th>gender</th>
							</tr>
						</thead>



						<tbody>
							<tr>
								<td>${employee.employeeName}</td>
								<td>${employee.emailId}</td>
								<td>${employee.phoneNumber}</td>
								
								<td>${employee.userName}</td>
								
								<td>${employee.gender}</td>
							</tr>
						</tbody>
					</table>
				</div>



				<p align="center">
					<a href="showInterest.do?id=${employee.userName}" class="livebox">Show
						Interest</a>
				</p>
			</div>
			<!--your content end-->

		</div>
		<!--toPopup end-->

		<div class="loader"></div>
		<div id="backgroundPopup"></div>
	</div>

</body>
</html>