
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


<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#employeeName")
								.blur(
										function() {
											var name = $("#employeeName").val();
											// var regex=new RegExp("^[!@#$%^&*()-+=0-9]")
											if (name.length == 0) {
												$("#errorMessage1")
														.text(
																"*please enter valid name");
											} else if (!isNaN(name)) {
												$("#errorMessage1")
														.text(
																"numerics are not allowed");
											} else if (!($('#employeeName')
													.val()
													.match(/^(\w)+[\w\d\.]*$/))) {
												$("#errorMessage1")
														.text(
																"");
											} else {
												$("#errorMessage1").text("");
											}
										});

						function validateEmail(Email) {
							var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
							if (filter.test(Email)) {
								return true;
							} else {
								return false;
							}
						}
						$("#emailId")
								.blur(
										function() {
											var Email = $("#emailId").val();
											if ($.trim(Email).length == 0) {
												$("#errorMessage3")
														.text(
																"*Please enter a valid Email Address");
											} else if (!($('#emailId').val()
													.match(/^(\w)+[\w\d\.]*/))) {
												$("#errorMessage3")
														.text(
																"*special characters are not allowed");
											} else if (!isNaN(Email)) {
												$("#errorMessage3")
														.text(
																"numerics are not allowed");
											}

											else {
												$("#errorMessage3").text("");
											}
										});
						$("#phoneNumber").blur(
								function() {
									var number = $("#phoneNumber").val();
									if (isNaN(number) || number.length == 0) {
										$("#errorMessage4").text(
												"*Enter phone number");

									} else if (number.length > 10
											|| number.length < 10) {
										$("#errorMessage4").text(
												"*Enter proper phone number");

									} else {
										$("#errorMessage4").text("");
									}
								});
						$("#userName")
								.blur(
										function() {
											var uname = $("#userName").val();
											if (!($('#userName').val()
													.match(/^(\w)+[\w\d\.]*$/))
													|| uname.length == 0
													|| !isNaN(uname)) {
												$("#errorMessage5")
														.text(
																"");
											} else {
												$("#errorMessage5").text("");
											}
											
											 /* $.ajax({
													type: 'POST',
													url: "checkUserName.do",
													 data: {
														 uname :uname
													 },
													 success: function(responseText) {
														 alert(responseText.getUserName());  
														 $('#errorMessage5').html('');
												          $('#errorMessage5').html(responseText);   
												          
												         
												     }
													});  */
											
										});

						$("#password")
								.blur(
										function() {
											var pwd = $("#password").val();
											if (pwd.length == 0) {
												$("#errorMessage6")
														.text(
																"");
											} else if (pwd.length <= 7) {
												$("#errorMessage6")
														.text(
																"password should be above 8 characters ");
											}
										});

						$("#age").blur(function() {
							var age = $("#age").val();
							if (isNaN(age) || age.length == 0) {
								$("#errorMessage2").text("*Enter your age");

							} else {
								$("#errorMessage2").text("");
							}

						});

						/* $("#rePassword")
						        .blur(
						                function() {
						                    var cpwd = $("#rePassword")
						                            .val();
						                    var pwd = $('#repassword').val();
						                    if (cpwd.length <= 7 || cpwd != pwd) {
						                        $("#errorMessage7")
						                                .text("*password should match confirm ");
						                    } else {
						                        $("#errorMessage7").text("");
						                    }
						                }); */
						/* $("#male").click(function () {
						  
						     alert($('input:radio[name=gender]:nth(0)').attr('checked',true));
						  
						     });
						$("#female").click(function () {
						  
						     alert($('input:radio[name=gender]:nth(1)').attr('checked',true));
						  
						 */
						/*  $("#male").click(function () {
						     
						        alert($('input:radio[name=gender]:checked').val());
						 });
						 $("#female").click(function () {
						     
						        alert($('input:radio[name=gender]:checked').val());
						 });
						 */

						$("#gender").blur(function() {

							if (!$("input[name='gender']:checked").val()) {
								//alert('Nothing is checked!');
							}

						});

						$('#myForm')
								.submit(
										function() {
											var fname = $("#employeeName")
													.val();
											var sEmail = $("#emailId").val();
											var mobile = $("#phoneNumber")
													.val();
											var name = $("#userName").val();
											var pwd = $("#password").val();
											var aged = $("#age").val();
											/* var repd = $("#rePassword").val(); */
											if (fname.length == 0
													|| sEmail.length == 0
													|| mobile.length == 0
													|| name.length == 0
													|| pwd.length == 0
													|| aged.length == 0
													|| repd.length == 0) {
												$("#errorMessage1")
														.text(
																"");

												$("#errorMessage3")
														.text(
																"");

												$("#errorMessage4")
														.text(
																"");

												$("#errorMessage5")
														.text(
																"");

												$("#errorMessage6")
														.text(
																"");

												$("#errorMessage2")
														.text(
																"");

												/* $("#errorMessage7")
												.text("*password should match"); */

												return false;

											}
										});

					});
						
					
						
						
						
						
					
						
</script>
<head>
<title>Demo Beautiful Registration Form with HTML5 and CSS3</title>
<meta http-equiv="X-UA-Compatible"
	content="IE=EmulateIE7; IE=EmulateIE9">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" type="text/css" href="css/register.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="demo.css" media="all" />


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

</head>
<body>
	<form:form action="insertEiuEmployee.do"
		commandName="eiuemployee" id="myForm">
		<fieldset>
			<!-- a table like box to specify the fields -->
			<legend align="top">
				<!-- header of field box -->
				<h2>Registration Form</h2>
			</legend>
			<div class="container">



				<div class="form">

					<p class="contact">
						<label for="name">Name</label>
					</p>
					<form:input id="employeeName" name="name"
						placeholder="First and last name" type="text" path="employeeName" />
					<div style="color: red" id="errorMessage1"></div>

					<p class="contact">
						<label for="email">Email</label>
					</p>
					<form:input id="emailId" name="email"
						placeholder="example@domain.com" type="email" path="emailId" />
					<div style="color: red" id="errorMessage3"></div>

					<p class="contact">
						<label for="username">Username</label>
					</p>
					<form:input id="userName" name="username" placeholder="username"
						type="text" path="userName" />
					<div style="color: red" id="errorMessage5"></div>

					<p class="contact">
						<label for="password">Password</label>
					</p>
					<form:input type="password" id="password" name="password"
						placeholder="password" path="password" />
					<div style="color: red" id="errorMessage6"></div>

					<p class="contact">
						<label for="age">Age</label>
					</p>
					<form:input id="age" name="age" placeholder="age" type="text"
						path="age" />
					<div style="color: red" id="errorMessage2"></div>



					<p class="contact">
						<label for="phone">Mobile Phone</label>
					</p>
					<form:input id="phoneNumber" name="phone"
						placeholder="phone number" type="text" path="phoneNumber" />
					<br>
					<div style="color: red" id="errorMessage4"></div>

					<form:select id="gender" class="select-style gender" name="gender"
						path="gender">
						<option value="select">Gender</option>
						<option value="m">Male</option>
						<option value="f">Female</option>

					</form:select>
					<br> <br>
					<div style="color: red" id="errorMessage5">



						<input class="buttom" name="submit" value="Sign me up!"
							type="submit">
					</div>
				</div>
			</div>
		</fieldset>
	</form:form>
</body>
</html>