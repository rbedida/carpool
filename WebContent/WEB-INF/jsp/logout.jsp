<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% HttpSession session_s = request.getSession(false);
if(session_s!=null){
session_s.invalidate();
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0);
}
%>
<script language="JavaScript">
javascript:window.history.forward(0);
</script>
</head>
<body>
<div align="center" style="border:1px solid red">

<p> <h1 style="color:rgb(144,12,63)">successfull logout...!!! <br>Thank You for choosing us!</h1></p>
<img src="images/carthankyou.jpg" width="350" height="250">  <br>
  
 <h2 style="color:rgb(255,87,51)">  It is our desire to keep you satisfied with our services!!! </h2> 

</div> 

<a href="loginform.do">click here to login</a>
</body>
</html>