<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- CSS Import -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- Add Customer -->
			<input 
				type="button" 
				value="Add Customer" 
				onclick="window.location.href='showFormForAdd'; return false;" 
				class="add-button"
			/>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempCustomer" items="${customers}">		<!-- "customer", CustomerControl'de model attribute'ün parametresinde tanımlanan -->
					
					<!-- Creating variable for Update Link -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a></td>
						
						<!-- 
							Update Linki için variable tanımlamadan direkt 52. satıra alttaki gibi yazıp da yapabilirdik
							 <a href="${pageContext.request.contextPath}/customer/showFormForUpdate?customerId=${tempCustomer.id}">Update</a>
						 -->
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
</body>

</html>