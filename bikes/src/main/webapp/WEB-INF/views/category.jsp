<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/views/header.jsp" %>
<body>

<form:form method="POST" action="./addcategory">
<table>
<tr>
        <td>Category Name :</td>
           <td><form:input path="categoryname" /></td>
        
    </tr>
     <tr>
        <td>Category Id:</td>
           <td><form:input path="categoryid" /></td>
        
    </tr>
     <tr>
        <td>Category size:</td>
           <td><form:input path="categorysize" /></td>
        
    </tr>
     <tr>
        <td>Category price:</td>
           <td><form:input path="categoryprice" /></td>
        
    </tr>

   
    <tr>
        <td colspan="2"><input type="submit" value="Enter"></td>
    </tr>
</table>
</form:form>
<%@include file="/WEB-INF/views/footer.jsp"  %>
