<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="POST" action="./addcustomer">
<table>
<tr>
        <td>FullName :</td>
           <td><form:input path="FullName" /></td>
        
    </tr>
     <tr>
        <td>EmailId :</td>
           <td><form:input path="EmailId" /></td>
        
    </tr>

    <tr>
        <td>UserName :</td>
        <td><form:input path="UserName" /></td>
    </tr>
    <tr>
        <td>Password :</td>
        <td><form:password path="Password" /></td>
    </tr>
   
    
    <tr>
        <td colspan="2"><input type="submit" value="Register"></td>
    </tr>
</table>
</form:form>


</body>
</html>