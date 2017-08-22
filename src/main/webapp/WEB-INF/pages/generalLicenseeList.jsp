<%--
  User: Fan
  Date: 8/31/2016
  Time: 9:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GeneralLicensees List</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                	<div  align="left"><b>GeneralLicensees List</b></div> 
                	<div align="right"><a href="${pageContext.request.contextPath}/main">Main Menu2</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/generallicensee/add">Add New</a></div>
            </h3>
        </div>
        <div class="panel-body">

           	<form:form name="pagepost" id="pagepost" method="POST" action="${pageContext.request.contextPath}/generallicensee/list/1/" modelAttribute="generalLicensee">
            	<div class="row">
            		<div class="col-md-11">            		
					   <form:label path="name">Name</form:label>
					   <form:input path="name"/>&nbsp;&nbsp;&nbsp;&nbsp;
					
					   <form:label path="address">address</form:label>
					   <form:input path="address"/>&nbsp;&nbsp;&nbsp;&nbsp;
					
					   <form:label path="city">city</form:label>
					   <form:input path="city" size="10" />&nbsp;&nbsp;&nbsp;&nbsp;
					
					   <form:label path="postCode">postCode</form:label>
					   <form:input path="postCode" size="10" />&nbsp;&nbsp;&nbsp;&nbsp;
					
					   <form:select path="rowsperpage" items="${rowsperpageList}"/>
					   <form:label path="rowsperpage">Rows/Page</form:label>&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					
					<div class="col-md-1" align="right">
					<input class="btn btn-success" type='submit' value='Search'/>
					</div>
				</div>
          
 				<!-- pageing start -->
 				<c:url var="firstUrl" value="/generallicensee/list/1/" />
				<c:url var="lastUrl" value="/generallicensee/list/${generalLicenseePage.totalPages}/" />
				<c:url var="prevUrl" value="/generallicensee/list/${currentIndex - 1}/" />
				<c:url var="nextUrl" value="/generallicensee/list/${currentIndex + 1}/" />
			
				<c:if test="${generalLicenseePage.totalPages>1}">	
					<div calss="row" >
						<div  align="left">
						    <ul class="pagination pagination-sm">
						        <c:choose>
						            <c:when test="${currentIndex == 1}">
						                <li class="disabled"><a href="#">&lt;&lt;</a></li>
						                <li class="disabled"><a href="#">&lt;</a></li>
						            </c:when>
						            <c:otherwise>
						                <li><a href="${firstUrl}" onclick="return postPage('${firstUrl}');" >&lt;&lt;</a></li>
						                <li><a href="${prevUrl}" onclick="return postPage('${prevUrl}');" >&lt;</a></li>
						            </c:otherwise>
						        </c:choose>
						        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
						            <c:url var="pageUrl" value="/generallicensee/list/${i}/" />
						            <c:choose>
						                <c:when test="${i == currentIndex}">
						                    <li class="active"><a  onclick="return false;"  ><c:out value="${i}" /></a></li>
						                </c:when>
						                <c:otherwise>
						                    <li><a href="#" onclick="return postPage('${pageUrl}');" ><c:out value="${i}" /></a></li>
						                </c:otherwise>
						            </c:choose>
						        </c:forEach>
						        <c:choose>
						            <c:when test="${currentIndex == generalLicenseePage.totalPages}">
						                <li class="disabled"><a href="#">&gt;</a></li>
						                <li class="disabled"><a href="#">&gt;&gt;</a></li>
						            </c:when>
						            <c:otherwise>
						                <li><a href="${nextUrl}" onclick="return postPage('${nextUrl}');" >&gt;</a></li>
						                <li><a href="${lastUrl}" onclick="return postPage('${lastUrl}');" >&gt;&gt;</a></li>
						            </c:otherwise>
						        </c:choose>
						    </ul>						    
						</div>
					</div>			  
				</c:if> <!-- pageing end -->
           	</form:form>         	
 
             	            	
            <table class="table table-hover table-bordered">
                <thead style="background-color: #bce8f1;">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>MaskedId</th>
                    <th>SIC</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>Prov</th>
                    <th>Country</th>
                    <th>PostCode</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${generalLicenseePage.getContent()}" var="generalLicensee">
                    <tr>
                    	<th><c:out value="${generalLicensee.id}"/></th>
                    	<th><c:out value="${generalLicensee.name}"/></th>
                    	<th><c:out value="${generalLicensee.maskedId}"/></th>
                    	<th><c:out value="${generalLicensee.sic}"/></th> 
                    	<th><c:out value="${generalLicensee.address}"/></th> 
                    	<th><c:out value="${generalLicensee.city}"/></th> 
                    	<th><c:out value="${generalLicensee.stateProv}"/></th> 
                    	<th><c:out value="${generalLicensee.country}"/></th> 
                    	<th><c:out value="${generalLicensee.postCode}"/></th> 
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


	<form id="pagepost" action="">
		<input type='hidden' name='name' id='name' value="${name}" />
		<input type='hidden' name='address' id='address' value="${address}" />
		<input type='hidden' name='city' id='city' value="${city}" />
		<input type='hidden' name='postCode' id='postCode' value="${postCode}" />
		<input type='hidden' name='rowsperpage' id='rowsperpage' value="${rowsperpage}" />
	</form>						
      
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

	<script type="text/javascript">
		function postPage(url){
			//alert(url);
			$('#pagepost').attr('action', url);
			$('#pagepost').submit();
			return false;
		};
	</script>
</body>
</html>