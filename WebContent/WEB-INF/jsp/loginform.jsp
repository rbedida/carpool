<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css" href="css/register.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
    
<!--  <script type="text/javascript" src="jquery.validate.js"></script> -->

<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						// Setup form validation on the #register-form element
						$("#userName")
								.blur(
										function() {
											var user = $("#userName").val();
											if (user.length == 0) {
												$("#errorMessage1")
														.text(
																"*Enter valid username");

											} else if (!isNaN(user)) {
												$("#errorMessage1")
														.text(
																"*username doesnot start with numberic values");

											} else {
												$("#errorMessage1").text("");
											}
										});
						$("#password")
								.blur(
										function() {
											var pwd = $("#password").val();
											if (pwd.length <= 7) {
												$("#errorMessage2")
														.text(
																"*password should be above 8 characters");
											} else {
												$("#errorMessage2").text("");
											}
										});
						
						
						$('#myForm')
								.submit(
										function() {
											var fname = $("#userName").val();
											var sEmail = $("#password").val();
											if (fname.length == 0
													|| sEmail.length == 0) {
												$("#errorMessage1")
														.text(
																"* User Name field cannot be empty");
												$("#errorMessage2")
														.text(
																" *password cannot be empty");
												return false;
											}
										});

					});
</script>
</head>
<body>

	<form:form action="validate.do" commandName="eiuEmployees"
		id="myForm">
		<fieldset>
			<!-- a table like box to specify the fields -->
			<legend>
				<b>Login Form</b>
			</legend>
			<div class="container">
				<div class="form">
					<div>
						<p class="contact"><label for="password">User Name:</label></p>
						<form:input id="userName" name="name" placeholder="userName" type="text" path="userName"></form:input>
					</div>
										<div style="color: red" id="errorMessage1"></div>
					
					<div>
						<p class="contact"><label for="password">Password:</label></p>
						<form:input id="password" name="password" placeholder="password"  type="password" path="password"></form:input>
					</div>
										<div style="color: red" id="errorMessage2"></div>
										<br>
					
					<input class="buttom" type="submit" value="login"> <input class="buttom" type="reset"
						value="reset"> <a href="forgotpassword.do">forgot
						password</a>
				</div>
			</div>
		</fieldset>
	</form:form>
</body>
</html>