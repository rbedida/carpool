<%@page import="com.eiu.vcarpool.dto.CarPool"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css"/> 
<link rel="stylesheet" type="text/css" href="css/jquery.dataTables_themeroller.css"/>
<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script
	src="http://datatables.net/download/build/jquery.dataTables.nightly.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#searchResults').dataTable();
	});
</script>
</head>
<body>
	<div id="body" style="width: 100%; align: left">
	<form:form action="" commandName="search">
	
			<div id="searchResultsContainer">
				<table id="searchResults" cellspacing="0" cellpadding="0"
					align="left" width="90%" class="display">
					<thead>
						<tr>

							<th>vehicleName</th>
							<th>source</th>
							<th>intermediateRoute</th>
							<th>destination</th>
							<th>startTime</th>
							<th>endTime</th>
							<th>noOfSeatsAvailable</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${searchDetails}" var="search">




							<tr>
								<%-- <td>${search.CarpoolId}</td> --%>
								<td align="left">${search.vehicleName}</td>
								<td align="left">${search.source}</td>
								<td align="left">${search.intermediateRoute}</td>
								<td align="left">${search.destination}</td>
								<td align="left">${search.startTime}</td>
								<td align="left">${search.endTime}</td>
								<td align="left">${search.noOfSeatsAvailable}</td>
								<td > 	

							</tr>
						</c:forEach>
					</tbody>



				</table>
			</div>
	</form:form>
	</div>


</body>
</html>