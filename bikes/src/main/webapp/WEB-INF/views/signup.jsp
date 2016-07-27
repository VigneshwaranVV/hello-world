<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/views/header.jsp" %>
<body background="resources/images/111.jpg" width="460" height="345">

<form:form method="POST" action="addcustomer">
<table>
<tr>
   <td>FullName :</td>
   <td><form:input path="UserName" /></td>    
   </tr>
   <tr>
   <td>UID :</td>
   <td><form:input path="UID" /></td>    
   </tr>
     <tr>
        <td>EmailId :</td>
           <td><form:input path="EmailId" /></td>
        
    </tr>
     <tr>
        <td>Password :</td>
        <td><form:password path="Password" /></td>
    </tr>

    <tr>
        <td>Password again :</td>
        <td><form:password path="PasswordAgain" /></td>
    </tr>
    
    <tr>
        <td colspan="2"><input type="submit" value="Register"></td>
    </tr>
</table>
</form:form>

<%@include file="/WEB-INF/views/footer.jsp" %>