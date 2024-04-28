<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding the New </title>
</head>
<body>
		<div id="wrapper">
			<div id="header">
					<h2>E-commerce-CRUD </h2>
			</div>
			<div id="container">
					<h3>Add New </h3>
		
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">

			<form:hidden path="id"/>

				<table>
					<tbody>
						<tr>
								<td><label>Product ID : </label></td>
								<td><form:input path="prodId"/></td>
								
						</tr>
						<tr>
								<td><label>Product Category: </label></td>
								<td><form:input path="prodCategory"/></td>
								
						</tr>
						<tr>
								<td><label>Product Brand : </label></td>
								<td><form:input path="prodBrand"/></td>
								
						</tr>
						
						<tr>
								<td><label></label></td>
								<td><input type="submit" value="Save"></td>
								
						</tr>
					
					</tbody>
				
				</table>
			
			</form:form>
			</div>
			
		</div>
</body>
</html>