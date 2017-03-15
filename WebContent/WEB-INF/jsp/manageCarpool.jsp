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
<!-- <script type="text/javascript">
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

</script> -->
<style type="text/css">
resultHide
{

visibility: hidden;
    position: absolute;
    top: -9999px;
}

table td,.datagrid table th {
	padding: 3px 10px;
}

table thead th {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #858585
		), color-stop(1, #00557F) );
	background: -moz-linear-gradient(center top, #000000, #00557F 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#000000',
		endColorstr='#000000' );
	background-color: #858585;
	color: #FFFFFF;
	font-size: 15px;
	font-weight: bold;
	border-left: 1px solid #0070A8;
}

table thead th {
	border: none;
}

table tbody td {
	color: #00496B;
	border-left: 1px solid #E1EEF4;
	font-size: 12px;
	font-weight: normal;
}

table tbody .alt td {
	background: #E1EEF4;
	color: #00496B;
}

table tbody td {
	border-left: none;
}

table tbody tr td {
	border-bottom: none;
}

</style>
</head>
<body>
    <div id="body" style="width: 100%; align: left">
        <form:form action="" commandName="search">

            <div id="searchResultsContainer">
                <table id="searchResults" cellspacing="0" cellpadding="0"
                    align="left" width="90%" class="display">
                    <thead>
                        <tr>

                            <th>Rider Name</th>
                           
                            <th>Employee Name</th>
                            <th>Email Id</th>
                            <th>Age</th>
                            <th>Phone Number</th>
                            <th>Action</th>
                           
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${listOfRiders}" var="rider">

                          
                                <tr>
                                    <td>${rider.userName}</td>
                                    
                                    <td>${rider.employeeName}</td>
                                    <td>${rider.emailId}</td>
                                    <td>${rider.age}</td>
                                    <td>${rider.phoneNumber}</td>
                                   

                                    <form:form action="employeedetails.do" commandName="employee">


                                        <td align="center"><a name="carId"
                                        href='deleteRider.do?id=${rider.userName}' >delete</a></td>
                                    </form:form>

                                </tr>
                          
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </form:form>
    </div>
<div id="result" style="height:1px; width:1px"class="resultHide"></div>
<!-- style="display:none" -->

</body>
</html>
