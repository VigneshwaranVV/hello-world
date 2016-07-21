<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Product Page</title>
</head>
<body>

<form:form method="POST" action="./updateproduct">
<table>
<tr>
        <td>Product Name :</td>
           <td><form:input path="productname" /></td>
        
    </tr>
     <tr>
        <td>Product Id:</td>
           <td><form:input path="productid" /></td>
        
    </tr>

    <tr>
        <td>Product Size :</td>
        <td><form:input path="productsize" /></td>
    </tr>
    <tr>
        <td>Product Price :</td>
        <td><form:input path="productprice" /></td>
    </tr>
   
    
    <tr>
        <td colspan="2"><input type="submit" value="Update"></td>
    </tr>
</table>
</form:form>

</body>
</html>
</body>
</html>