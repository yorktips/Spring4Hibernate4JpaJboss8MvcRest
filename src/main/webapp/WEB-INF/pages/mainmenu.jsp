<%--
  User: Fan
  Date: 7/31/2017
  Time: 9:48 PM
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Fan Wu">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Information-Demo</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>    
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">


	<div class="container">
	  <h2>Demo Main Menu</h2>
	  <p>Choose one of following menus:</p>
	  <div class="list-group">
	  	<a href="${pageContext.request.contextPath}/employee/list" class="list-group-item list-group-item-danger">Employees</a>
	    <a href="${pageContext.request.contextPath}/generallicensee/list/1/" class="list-group-item list-group-item-success">General Licensee</a>
	  </div>
	</div>

    <form:form method="POST" commandName="member">
	        <table>
	            <tr>
	                <td>Are you a new member?</td>
	                <td><form:checkbox path="newMember" />
	                </td>
	            </tr>
	            <tr>
	                <td>Choose the courses you like:</td>
	                <td><form:checkboxes path="courses" items="${courses}" />
	                </td>
	            </tr>
	            <tr>
	                <td><input type="submit" name="submit" value="Submit"></td>
	            </tr>
	            <tr>
	        </table>
	 
</form:form>
	 
<form:form method="POST" commandName="generalLicensee">


   <form:label path="name">Name</form:label>
   <form:input path="name"/>&nbsp;&nbsp;&nbsp;&nbsp;

   <form:label path="address">address</form:label>
   <form:input path="address"/>&nbsp;&nbsp;&nbsp;&nbsp;

   <form:label path="city">city</form:label>
   <form:input path="city"/>&nbsp;&nbsp;&nbsp;&nbsp;

   <form:label path="postCode">postCode</form:label>
   <form:input path="postCode"/>&nbsp;&nbsp;&nbsp;&nbsp;

   <form:select path="rowsperpage" items="${rowsperpageList}"/>
   <form:label path="rowsperpage">Rows/Page</form:label>&nbsp;&nbsp;&nbsp;&nbsp;

   
</form:form>
        
	    


 <select id="rowsperpage" name="rowsperpage">
      <c:forEach var="item" items="${rowsperpageList}">
        <option value="${item}">${item}</option>
      </c:forEach>
 </select>
    
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	</script>

</body>
</html>