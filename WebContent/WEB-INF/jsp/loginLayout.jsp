<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true">
	</tiles:insertAttribute></title>
	 
</head>
<body >
<div id="layout">
	<table border="1" cellpadding="2" cellspacing="2"  height="100%" width="100%" 
		>


		<tr>
			<td colspan="2"><tiles:insertAttribute name="header">
				</tiles:insertAttribute></td>
		</tr>
		
		<tr >
			<td colspan="2"><tiles:insertAttribute name="loginicons">
				</tiles:insertAttribute></td>
		</tr>
		
		
	<tr height="600">
			<td colspan="2"><tiles:insertAttribute name="body">
				</tiles:insertAttribute></td>
		</tr>
		

	


		<tr height="10%">
			<td  bgcolor="black" colspan="2" align="center" valign="bottom"><tiles:insertAttribute
					name="footer">
				</tiles:insertAttribute></td>
		</tr>

	</table> 
	<div>
	
	</div>


</div>
</body>
</html>
