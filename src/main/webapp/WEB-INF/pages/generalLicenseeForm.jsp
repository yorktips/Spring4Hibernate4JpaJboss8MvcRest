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
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="York Chen">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GeneralLicensee Information</title>
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
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    GeneralLicensee Details
                </h3>
            </div>
            <div class="panel-body">
            	<table>	
                <form:form novalidate="novalidate" id="generalLicenseeRegisterForm" name="generalLicenseeRegisterForm" cssClass="form-horizontal" modelAttribute="generalLicensee" method="post" action="/tca/generallicensee/save">
 <!--    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="name" >Name</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="id" value="${generalLicenseeObject.id}"/>
                            <form:input cssClass="form-control" path="name" value="${generalLicenseeObject.name}"/>
                            <form:errors path="name" class="alert alert-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="sic" cssClass="control-label col-xs-3">Address</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="address" value="${generalLicenseeObject.address}"/>
                            <form:errors path="address" class="alert alert-danger" />
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="sic" cssClass="control-label col-xs-3">Address2</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="address2" value="${generalLicenseeObject.address2}"/>
                            <form:errors path="address2" class="alert alert-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="sic" cssClass="control-label col-xs-3">Address3</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="address3" value="${generalLicenseeObject.address3}"/>
                            <form:errors path="address3" class="alert alert-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="sic" cssClass="control-label col-xs-3">City</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="city" value="${generalLicenseeObject.city}"/>
                            <form:errors path="city" class="alert alert-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="sic" cssClass="control-label col-xs-3">Country</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="country" value="${generalLicenseeObject.country}"/>
                            <form:errors path="country" class="alert alert-danger" />
                        </div>
                    </div>
    
 
                     <div class="form-group">
                        <form:label path="sic" cssClass="control-label col-xs-3">Full Description</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="fullDescription" value="${generalLicenseeObject.fullDescription}"/>
                            <form:errors path="fullDescription" class="alert alert-danger" />
                        </div>
                    </div>
                    
	                <div class="form-group">
                        <div class="control-label col-xs-3"><form:label path="maskedId">Masked Id</form:label></div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="maskedId" value="${generalLicenseeObject.maskedId}"/>
                            <form:errors path="maskedId" class="alert alert-danger" />
                        </div>
                    </div>                    
                    
	                <div class="form-group">
                        <div class="control-label col-xs-3"><form:label path="postCode">Post Code</form:label></div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="postCode" value="${generalLicenseeObject.postCode}"/>
                            <form:errors path="postCode" class="alert alert-danger" />
                        </div>
                    </div>                            
        
                     <div class="form-group">
                        <form:label path="sic" cssClass="control-label col-xs-3">SIC</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="sic" value="${generalLicenseeObject.sic}"/>
                            <form:errors path="sic" class="alert alert-danger" />
                        </div>
                    </div>
                     <div class="form-group">
                        <form:label path="sic" cssClass="control-label col-xs-3">Province/State</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="stateProv" value="${generalLicenseeObject.stateProv}"/>
                            <form:errors path="stateProv" class="alert alert-danger" />
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="saveGeneralLicensee" class="btn btn-primary" value="Save" onclick="return true;//submitGeneralLicenseeForm();"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>
     -->

					<tr>
                    	<td colspan=3>
                            <form:hidden path="id" value="${generalLicenseeObject.id}"/>
                        </td>
                    </tr>
     					
					<tr>
                    	<td><form:label path="name" >Name</form:label> 
                    	</td>
                        <td>
                            <form:input cssClass="form-control" path="name" value="${generalLicenseeObject.name}"/>
                        </td>
                        <td>
                            <form:errors path="name" cssClass="error"  />
                        </td>
                    </tr>

					<tr>
                    	<td><form:label path="address" >Address</form:label> </td>
                        <td><form:input cssClass="form-control" path="address" value="${generalLicenseeObject.address}"/></td>
                        <td><form:errors path="address" cssClass="error" /> </td>
                    </tr>
                    
					<tr>
                    	<td><form:label path="address2" >Address2</form:label> </td>
                        <td><form:input cssClass="form-control" path="address2" value="${generalLicenseeObject.address2}"/></td>
                        <td><form:errors path="address2" cssClass="error"  /> </td>
                    </tr>

					<tr>
                    	<td><form:label path="address3" >Address3</form:label> </td>
                        <td><form:input cssClass="form-control" path="address3" value="${generalLicenseeObject.address3}"/></td>
                        <td><form:errors path="address3" cssClass="error" /> </td>
                    </tr>

					<tr>
                    	<td><form:label path="address3" >City</form:label> </td>
                        <td><form:input cssClass="form-control" path="city" value="${generalLicenseeObject.city}"/></td>
                        <td><form:errors path="city" cssClass="error" /> </td>
                    </tr>

					<tr>
                    	<td><form:label path="address3" >Country</form:label> </td>
                        <td><form:input cssClass="form-control"  path="country" value="${generalLicenseeObject.country}"/></td>
                        <td><form:errors path="country" cssClass="error"  /> </td>
                    </tr>

					<tr>
                    	<td><form:label path="fullDescription" >Full Description</form:label> </td>
                        <td><form:input cssClass="form-control"  path="fullDescription" value="${generalLicenseeObject.fullDescription}"/></td>
                        <td><form:errors path="fullDescription" cssClass="error"  /> </td>
                    </tr>
					<tr>
                    	<td><form:label path="maskedId" >Masked Id</form:label> </td>
                        <td><form:input cssClass="form-control" path="maskedId" value="${generalLicenseeObject.maskedId}"/></td>
                        <td><form:errors path="maskedId" cssClass="error"  /> </td>
                    </tr>

					<tr>
                    	<td><form:label path="postCode" >postCode</form:label> </td>
                        <td><form:input cssClass="form-control" path="postCode" value="${generalLicenseeObject.postCode}"/></td>
                        <td><form:errors path="postCode" cssClass="error" /> </td>
                    </tr>
					<tr>
                    	<td><form:label path="sic" >SIC</form:label> </td>
                        <td><form:input cssClass="form-control" path="sic" value="${generalLicenseeObject.sic}"/></td>
                        <td><form:errors path="sic" cssClass="error"  /> </td>
                    </tr>
					<tr>
                    	<td><form:label path="stateProv" >stateProv</form:label> </td>
                        <td><form:input cssClass="form-control" path="stateProv" value="${generalLicenseeObject.stateProv}"/></td>
                        <td><form:errors path="stateProv" cssClass="error" /> </td>
                    </tr>
                    
                    <tr>
                    <td colspan=2>
                                <input type="submit" id="saveGeneralLicensee" class="btn btn-primary" value="Save" onclick="return true;"/>
					</td>
					</tr>

                </form:form>
                </table>
                
            </div>
        </div>
    </div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="http://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
	
	<script type="text/javascript">
	
	$(function() {

		$.validator.addMethod(
		        "regex",
		        function(value, element, regexp) {
		            if (regexp.constructor != RegExp)
		                regexp = new RegExp(regexp);
		            else if (regexp.global)
		                regexp.lastIndex = 0;
		            return this.optional(element) || regexp.test(value);
		        },
		        "Please check your input."
		);
			
		
	  // Setup form validation on the #register-form element
	  $("#generalLicenseeRegisterForm").validate({
	      rules: {
	          name: {
	        	  required: true,
	        	  minlength: 2,
	        	  maxlength: 24
	          },
	          address: {
	        	  required: true,
	        	  minlength: 5,
	        	  maxlength: 255,
	              regex:  /^[0-9][a-z]{1,2}$/i
	          },
   				
	      
	      },
	      
	      // Specify the validation error messages
	      messages: {
	    	  name: {
	              required: "Please provide a stock code",              
	              minlength: "Your stockCode must be at least 4 characters long",
	              maxlength: "Your stockCode must be at less than 6 characters long"
	          },
	          address: {
	              required: "Please provide a stock name",              
	              minlength: "Your stockName must be at least 4 characters long",
	              maxlength: "Your stockName must be at less than 10 characters long",
	        	  regex: "Start with Char and end with number"
	          }
	      },
	      
	      submitHandler: function(form) {
	          form.submit();
	      }
	  });


	});


	
		function submitGeneralLicenseeForm() {				
			
		    // getting the generalLicensee form values
		    var name = $('#name').val().trim();
		    var age = $('#age').val();
		    var salary = $('#salary').val();
		    if(name.length ==0) {
		        alert('Please enter name');
		        $('#name').focus();
		        return false;
		    }
	
		    if(age <= 0) {
		        alert('Please enter proper age');
		        $('#age').focus();
		        return false;
		    }
	
		    if(salary <= 0) {
		        alert('Please enter proper salary');
		        $('#salary').focus();
		        return false;
		    }
		    return true;
		};	
	</script>

</body>
</html>