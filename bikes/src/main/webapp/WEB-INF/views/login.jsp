<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/WEB-INF/views/header.jsp" %>

<body background="">
<center><h2><b><font size="6">welcome to loginpage</font></b></h2></center>
<form action="logincheck" method=""><br>
<center><b>USERNAME:</b><input type="text" name="username"><br></center>
<center><br><b>PASSWORD:</b><input type="password" name="pwd"><br></center>
<center><br><input type="submit" value="login">
<input type="reset" value="reset"></center>
<center><br><input type="button" value="forgot password"><br></center>
<center><br><font size="5" color="red"></font> <a href="signup">SIGNUP</a></center>
</form>
</body>
</html>


