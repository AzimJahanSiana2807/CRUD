<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
		<div id="header">
			<h2>E-Commerce Application-CRUD</h2>
		</div>
		<div id="container">
		
			<div id="content">
			
				<input type="button" value="Add Customer" 
					   onclick="window.location.href='showFormForAdd'"
				/>

				<table border="1">
						<tr>
							<th>Product ID</th>
							<th>Product Category</th>
							<th>Product Brand</th>
							<th>Action</th>
						</tr>
						
						<C:forEach var="customer" items="${customers}">
							
							<C:url var="updateLink" value="/customer/showFormForUpdate">
							
								<C:param name="customerId" value="${customer.id}" />
							</C:url>
							
							<tr>
									<td>${customer.prodId} </td>
									<td>${customer.prodCategory} </td>
									<td>${customer.prodBrand} </td>
									<td>
										<a href="${updateLink}">Update</a>
									</td>
							</tr>
						</C:forEach>
				</table>
				
			</div>
		</div>
</body>
</html>