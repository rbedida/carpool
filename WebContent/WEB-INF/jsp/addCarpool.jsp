<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.eiu.vcarpool.dto.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.eiu.vcarpool.dto.Employee"%>
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

                        $("#carModel")
                                .blur(
                                        function() {
                                            var fname = $("#carModel").val();
                                            // var regex=new RegExp("^[!@#$%^&*()-+=0-9]")
                                            if (fname.length == 0) {
                                                $("#errorMessage1")
                                                        .text(
                                                                "");

                                            }

                                            else if (!isNaN(fname)) {
                                                $("#errorMessage1")
                                                        .text(
                                                                "");
                                            } else if (!($('#carModel').val()
                                                    .match(/^(\w)+[\w\d\.]*$/))) {
                                                $("#errorMessage1")
                                                        .text(
                                                                "");
                                            } else {
                                                $("#errorMessage1").text("");
                                            }
                                        });

                         $("#startTime").blur(
                                function() {
                                    var name = $("#startTime").val();
                                   var reg=(/^([0-9]:[0-9]) [AaPp][mM]$/)
                                      var reg=(/^(?:(?:([01]\d|2[0-3]):)([0-5]\d):)([0-5]\d)$/); 
                                     if(!name.match(/^(?:(?:([01]\d|2[0-3]):)([0-5]\d):)([0-5]\d)$/))
                                         {
                                         $("#errorMessage2").text(
                                            "");
                                         }
                                     if (!($('#startTime').val()
                                            .match(/^(\w)+[\w\d\.]*$/))) {
                                        $("#errorMessage2").text(
                                                "");
                                    } else if (isNaN(name)) {
                                        $("#errorMessage2").text(
                                                "");
                                    }
                                    else {
                                        $("#errorMessage2").text("");
                                    }
                                });
                        /* $.validator.addMethod("time", function(value, element) { 
                            return this.optional(element) || /^(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9])(:([0-5]?[0-9]))?$/i.test(value); 
                            }, "Please enter a valid time.");

                                $("#myForm").validate({
                                        rules: {
                                                time: "required time",
                                        },

                                 });

                             }); */
                        $("#returnTime")
                                .blur(
                                        function() {
                                            var name = $("#returnTime").val();
                                            var reg=(/^(?:(?:([01]\d|2[0-3]):)([0-5]\d):)([0-5]\d)$/);
                                            if (!($('#returnTime').val()
                                                    .match(/^(\w)+[\w\d\.]*$/))) {
                                                $("#errorMessage3").text(
                                                        "");
                                            } else if (isNaN(name) || !reg) {
                                                $("#errorMessage3").text(
                                                        "");
                                            } else {
                                                $("#errorMessage3").text("");
                                            }
                                        });
                        $("#source")
                                .blur(
                                        function() {
                                            var fname = $("#source").val();
                                            // var regex=new RegExp("^[!@#$%^&*()-+=0-9]")
                                            if (fname.length == 0) {
                                                $("#errorMessage4")
                                                        .text(
                                                                "please enter valid source");
                                            }

                                            else if (!isNaN(fname)) {
                                                $("#errorMessage4")
                                                        .text(
                                                                "numerics are not allowed");
                                            } else if (!($('#source').val()
                                                    .match(/^(\w)+[\w\d\.]*$/))) {
                                                $("#errorMessage4")
                                                        .text(
                                                                "*special characters are not allowed");
                                            } else {
                                                $("#errorMessage4").text("");
                                            }
                                        });

                        $("#route")
                                .blur(
                                        function() {
                                            var fname = $("#route").val();
                                            // var regex=new RegExp("^[!@#$%^&*()-+=0-9]")
                                if (fname.length == 0) {
                                                $("#errorMessage5")
                                                        .text(
                                                                "please enter valid route");
                                            }
                                else if (!isNaN(fname)) {
                                                $("#errorMessage5")
                                                        .text(
                                                                "numerics are not allowed");
                                            } else if (!($('#route').val()
                                                    .match(/^(\w)+[\w\d\.]*$/))) {
                                                $("#errorMessage5")
                                                        .text(
                                                                "*special characters are not allowed");
                                            } else {
                                                $("#errorMessage5").text("");
                                            }
                                        });

                        $("#destination")
                                .blur(
                                        function() {
                                            var fname = $("#destination").val();
                                            // var regex=new RegExp("^[!@#$%^&*()-+=0-9]")
                                            if (fname.length == 0) {
                                                $("#errorMessage6")
                                                        .text(
                                                                "please enter valid destination");
                                            }
                                            else if (!isNaN(fname)) {
                                                $("#errorMessage6")
                                                        .text(
                                                                "numerics are not allowed");
                                            } else if (!($('#destination').val()
                                                    .match(/^(\w)+[\w\d\.]*$/))) {
                                                $("#errorMessage6")
                                                        .text(
                                                                "*special characters are not allowed");
                                            } else {
                                                $("#errorMessage6").text("");
                                            }
                                        });

                        $("#seatsAvailable")
                                .blur(
                                        function() {
                                            var seats = $("#seatsAvailable")
                                                    .val();
                                            if (isNaN(seats )) {
                                                $("#errorMessage7")
                                                        .text(
                                                                "*characters are not allowed");

                                            } else if (!($('#seatsAvailable')
                                                    .val()
                                                    .match(/^(\w)+[\w\d\.]*$/))) {
                                                $("#errorMessage7")
                                                        .text(
                                                                "*special characters are not allowed");
                                            } else {
                                                $("#errorMessage7").text("");
                                            }
                                        });
                       /*  $("#genderPreference")
                        .blur(
                                function() {
                                    var fname = $("#genderPreference").val();
                                    // var regex=new RegExp("^[!@#$%^&*()-+=0-9]")
                                    if (!$("input[name='genderpreference']:checked").val()) {
                                        alert("nothing is checked");
                                        $("#errorMessage8")
                                                .text(
                                                        "please enter valid destination");
                                    }
                                     else {
                                        $("#errorMessage8").text("");
                                    }
                                });
                        */
                        $('#myForm')
                                .submit(
                                        function() {
                                            var fname = $("#carModel").val();
                                            var sEmail = $("#startTime").val();
                                            var mobile = $("#returnTime").val();
                                            var name = $("#source").val();
                                            var pwd = $("#route").val();
                                            var dest = $("#destination").val();
                                            var cpwd = $("#seatsAvailable")
                                                    .val();
                                            if (fname.length == 0
                                                    || sEmail.length == 0
                                                    || mobile.length == 0
                                                    || name.length == 0
                                                    || pwd.length == 0
                                                    || dest.length == 0
                                                    || cpwd.length == 0) {
                                                $("#errorMessage1")
                                                        .text(
                                                                "* Car Model cannot be empty");
                                                $("#errorMessage2")
                                                        .text(
                                                                " *start time cannot be empty");
                                                $("#errorMessage3")
                                                        .text(
                                                                "*return time  cannot be empty");
                                                $("#errorMessage4")
                                                        .text(
                                                                "*source cannot be empty");
                                                $("#errorMessage5")
                                                        .text(
                                                                "*route cannot be empty");
                                                $("#errorMessage6")
                                                        .text(
                                                                "* destination field cannot be empty");
                                                $("#errorMessage7")
                                                        .text(
                                                                "*no ofseats available cannot be empty ");
                                                /* $("#errorMessage8")
                                                .text(
                                                        "*gender preference cannot be empty  "); */
                                       

                                                return false;

                                            }
                                        });

                    });
</script>








</head>
<body>
	<form:form action="insertCarPool.do" commandName="carpool" id="myForm">
		<fieldset>
			<!-- a table like box to specify the fields -->
			<legend align="top">
				<!-- header of field box -->
				<h2>Add Your Carpool Details</h2>
			</legend>
			<div class="container">



				<div class="form">

					<p class="contact">
						<label for="carModel">Car Model</label>
					</p>
					<form:input id="carModel" name="carmodel" placeholder="carModel"
						type="text" path="carModel" />
					<div style="color: red" id="errorMessage1"></div>

					<p class="contact">
						<label for="startTime">StartTime</label>
					</p>
					<form:select class="select-style gender" name="time"
						path="startTime" id="startTime">
						<option value="select">select</option>
						<option value="7:00">7:00AM</option>
						<option value="8:00">8:00AM</option>
						<option value="9:00">9:00AM</option>
						<option value="10:00">10:00AM</option>
						<option value="11:00">11:00AM</option>
						<option value="12:00">12:00</option>
						<option value="1:00">1:00PM</option>
						<option value="2:00">2:00PM</option>
						<option value="3:00">3:00PM</option>
						<option value="4:00">4:00PM</option>
						<option value="5:00">5:00PM</option>
						<option value="6:00">6:00PM</option>
						<option value="7:00">7:00PM</option>
						<option value="8:00">8:00PM</option>

					</form:select>
					<br>
					<br>
					<div style="color: red" id="errorMessage2"></div>


					<p class="contact">
						<label for="returnTime">ReturnTime</label>
					</p>
					<form:select class="select-style gender" name="time"
						path="returnTime" id="returnTime">
						<option value="select">select</option>
						<option value="7:00">7:00AM</option>
						<option value="8:00">8:00AM</option>
						<option value="9:00">9:00AM</option>
						<option value="10:00">10:00AM</option>
						<option value="11:00">11:00AM</option>
						<option value="12:00">12:00</option>
						<option value="1:00">1:00PM</option>
						<option value="2:00">2:00PM</option>
						<option value="3:00">3:00PM</option>
						<option value="4:00">4:00PM</option>
						<option value="5:00">5:00PM</option>
						<option value="6:00">6:00PM</option>
						<option value="7:00">7:00PM</option>
						<option value="8:00">8:00PM</option>

					</form:select>
					<br>
					<br>
					<div style="color: red" id="errorMessage3"></div>
					<p class="contact">
						<label for="source">Source</label>
					</p>
					<form:input id="source" name="source" placeholder="source"
						type="text" path="source" />
					<div style="color: red" id="errorMessage4"></div>

					<p class="contact">
						<label for="route">Route</label>
					</p>
					<form:input id="route" name="route" placeholder="route" type="text"
						path="route" />
					<div style="color: red" id="errorMessage5"></div>

					<p class="contact">
						<label for="destination">Destination</label>
					</p>
					<form:input id="destination" name="destination"
						placeholder="destination" type="text" path="destination" />
					<div style="color: red" id="errorMessage6"></div>

					<p class="contact">
						<label for="seatsAvailable">Seats Available</label>
					</p>
					<form:input id="seatsAvailable" name="username"
						placeholder="seatsAvailable" type="text" path="seatsAvailable" />
					<div style="color: red" id="errorMessage7"></div>






					<form:select class="select-style gender" name="gender"
						path="genderPreference">
						<option value="select">GenderPreference</option>
						<option value="m">Male</option>
						<option value="f">Female</option>

					</form:select>
					<br>
					<br> <input class="buttom" name="submit" id="submit"
						tabindex="5" value="ADD" type="submit"> <input
						class="buttom" name="submit" id="submit" value="reset"
						type="reset">

				</div>
			</div>
		</fieldset>
	</form:form>
</body>
</html>