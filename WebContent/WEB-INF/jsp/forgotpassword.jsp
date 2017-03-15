<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.fields {
	width: 50%
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>


<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="css/register.css"
	media="all" />
<link rel="stylesheet" type="text/css" href="demo.css" media="all" />





<script type="text/javascript">
$(document).ready(
        function() {
            $("#userName").blur(
                    function() {
                        var uname = $("#userName").val();
                        if (!($('#userName').val()
                                .match(/^(\w)+[\w\d\.]*$/))
                                || uname.length == 0 || !isNaN(uname)) {
                            $("#errorMessage1").text(
                                    "*please enter valid username");
                            $("#errorMessage1").css('color', 'red');
                        } else {
                            $("#errorMessage1").text("");
                            $("#errorMessage1").css('color', 'red');
                        }
                    });
           
            $("#password")
            .blur(
                    function() {
                        var pwd = $("#password").val();
                        if (pwd.length==0) {
                            $("#errorMessage2")
                                    .text(
                                            "*Please Enter Password");
                            $("#errorMessage2").css('color', 'red');
                        } else if(pwd.length <= 7) {
                            $("#errorMessage2").text("password should be above 8 characters");
                            $("#errorMessage2").css('color', 'red');
                        }
                        });
                  
$('#myForm').submit(
        function() {
        	
            var name = $("#userName").val();

        var pwd = $("#password").val();
           
           
            if (name.length == 0 || emp.length == 0
                    || pwd.length == 0
                   
                    ) {
                $("#errorMessage1").text(
                "* Username field cannot be empty");
                $("#errorMessage2")
                .text(
                        " Password Field cannot be empty");
  return false; 
            }
});
        });
</script>
</head>
<body>
	<form:form action="resetpassword.do" commandName="eiuemployee" id="myForm">
		<fieldset>
			<!-- a table like box to specify the fields -->
			<legend>
				<b><h2>Reset Password</h2></b>
			</legend>
			<!-- header of field box -->
			<div id="container" style="width: 100%">
				<div class="container">



					<div class="form">

						<p class="contact">
							<label for="userName">User Name</label>
						</p>
						<form:input id="userName" name="name" placeholder="userName"
							type="text" path="userName" />
						<div style="color: red" id="errorMessage1"></div>

						<p class="contact">
							<label for="password">Password</label>
						</p>
						<form:input id="password" name="password" placeholder="password"
							type="password" path="password" />
						<div style="color: red" id="errorMessage2"></div>





						<input class="buttom" name="submit" id="submit" value="cancel"
							type="button" onclick="loginform.do" /> 
							<input class="buttom" name="submit" id="submit" value="Reset password" type="submit" />

					</div>
				</div>
			</div>
		</fieldset>
	</form:form>

</body>
</html>







