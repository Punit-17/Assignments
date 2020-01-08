<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method=post action="/addadmin" onsubmit="return Validate()">
<h3>Hello Admin</h3>
<h4>Enter Username: </h4><input type="text" name="username" id="uname" required>
<b id="err" style="display:none">Enter Only Alphabets.</b><br>
<h4>Enter Password: </h4><input type="text" name="password" id="pass" required><br><br>
<input type="submit" value="Add Admin">
</form><br><br>

<H4>Operating Admins</H4>
	<table border="2">
		<c:forEach items="${adm}" var="item">
			<tr>
				<td>${item.getUsername()}</td>
				<td>${item.getPassword()}</td>

			</tr>
		</c:forEach>
	</table>
	
	<script type="text/javascript">
		function Validate(){
				var movieId= document.getElementById("uname").value;
				var pattern = "^[a-zA-Z]+$";
				if(!movieId.match(pattern)){
					document.getElementById("err").style="display:inline"
						return false;
					}
				return true;
			}
	</script>

</body>
</html>