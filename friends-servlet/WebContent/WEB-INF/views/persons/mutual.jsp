<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.enigmacamp.friends.db.entities.Person"%>
<%@page import="com.enigmacamp.friends.db.entities.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<h1 style="text-align: center; font-family: cursive; font-style: oblique;">Mutual</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-10">
				<div class="table-responsive">
					<table class="table table-dark table-striped table-hover">
						<thead>
							<tr class="bg-primary">
								<th scope="col">No</th>
								<th scope="col">Name</th>
								<th scope="col">Birthday</th>
								<th scope="col">Gender</th>
							</tr>
						</thead>
						<tbody>
							<% for(Person data : (List<Person>)request.getAttribute("mutuals")) {  %>
							<tr>
								<th scope="row"><%=data.getId() %></th>
								<td class="bg-primary"><%=data.getName() %></td>
								<td class="bg-succes"><%=formatter.format(data.getBirthdate())%></td>
								<td class="bg-warning"><%=data.getGender().getName() %></td>
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>