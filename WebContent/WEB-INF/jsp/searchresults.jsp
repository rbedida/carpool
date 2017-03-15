<%@page import="com.eiu.vcarpool.dto.CarPool"%>
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
<link rel="stylesheet" type="text/css" href="css/table.css" />

<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
function loadProviderDetails(carPoolId){
	
  $.ajax({
	type: 'POST',
	url: "employeedetails.do",
	 data: {
		 cId :carPoolId
	 },
	 success: function(responseText) {
		 /* $('#result').innerhtml(responseText); */
		   $('#result').html('');
          $('#result').html(responseText);   
		 //popEnableCustom
        $('#result > :not(#popEnableCustom)').hide(); //hide all nodes directly under the elemnt
          
          $('#popEnableCustom').appendTo('body'); 
         
          $('#connect1').click();
     }
	}); 
	
	/* alert(dataObj); */
	/* $("#result").load("employeedetails.do/cId=${carPoolId}"); */
}
/* $("#result").load(jsp_path); */

</script>
<style type="text/css">
resultHide {
	visibility: hidden;
	position: absolute;
	top: -9999px;
}
</style>
</head>
<body>
	<div id="body" style="width: 100%; align: left">
		<form:form action="" commandName="search">


			<div class="datagrid">
				<table>
					<thead>
						<tr>

							<th>Car Name</th>
							<th>Source</th>
							<th>IntermediateRoute</th>
							<th>Destination</th>
							<th>startTime</th>
							<th>endTime</th>
							<th>noOfSeatsAvailable</th>
						</tr>
					</thead>
					<%  if(null!=session.getAttribute("userName"))
					 {%>

					<c:forEach items="${searchDetails}" var="search">

						<tbody>
							<tr>
								<td>${search.carModel}</td>
								<td>${search.source}</td>
								<td>${search.route}</td>
								<td>${search.destination}</td>
								<td>${search.startTime}</td>
								<td>${search.returnTime}</td>
								<td>${search.seatsAvailable}</td>


								<form:form action="employeedetails.do" commandName="employee">


									<td align="center"><a name="carId" href='#' onclick="loadProviderDetails(${search.carPoolId})">connect</a></td>
								</form:form>
								

							</tr>
						</tbody>
					</c:forEach>
					
					<%}
					else { %>
						<c:forEach items="${searchDetails}" var="search">

						<tbody>
							<tr>
								<td>${search.carModel}</td>
								<td>${search.source}</td>
								<td>${search.route}</td>
								<td>${search.destination}</td>
								<td>${search.startTime}</td>
								<td>${search.returnTime}</td>
								<td>${search.seatsAvailable}</td>						

							</tr>
						</tbody>
					</c:forEach>
	<%				}	
					%>
					
					
				</table>
			</div>
		</form:form>
	</div>
	<div id="result" style="height:1px; width:1px"class="resultHide"></div>
</body>
</html>