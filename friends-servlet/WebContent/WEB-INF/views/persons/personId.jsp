<%@page import="com.enigmacamp.friends.db.entities.Post"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.enigmacamp.friends.db.entities.Person"%>
<%@page import="com.enigmacamp.friends.db.entities.*" %>
<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <% DateFormat format = new SimpleDateFormat("dd-MM-yyyy"); %>
     <% 
		Person person = (Person) request.getAttribute("persons"); 
	%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person Id</title>
</head>
<body>
	<div class="container">

		<!-- Table Person -->
		<div class="row">
			<div class="col-10">
				<h1
					style="text-align: center; font-family: cursive; font-style: oblique;">Detail
					Person</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-10">
				<div class="table-responsive">
					<table class="table table-dark table-striped table-hover">
						<thead>
							<tr class="bg-primary">
								<th scope="col">Name</th>
								<th scope="col">Birthday</th>
								<th scope="col">Gender</th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td class="bg-primary"><%=person.getName()%></td>
								<td class="bg-success"><%=format.format(person.getBirthdate() )%></td>
								<td class="bg-warning"><%=person.getGender().getName()%></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>



											<!-- Table Friend -->
		<div class="row">
			<div class="col-10">
				<h1
					style="text-align: center; font-family: cursive; font-style: oblique;">Person
					Friend</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-10">
				<div class="table-responsive">
					<table class="table table-dark table-striped table-hover">
						<thead>
						<tr class="bg-primary">
							<th scope="col">Name</th>
							<th scope="col">Birthday</th>
							<th scope="col">Gender</th>
							<th scope="col">Action</th>
						</tr>
						</thead>
						<tbody>
						<%
						for(Person per : person.getPersonFriend()) {
						
						%>
						<tr>
							<td class="bg-primary"><%=per.getName()%></td>
							<td class="bg-success"><%=format.format(per.getBirthdate() )%></td>
							<td class="bg-warning"><%=per.getGender().getName()%></td>
							<td>
							<a href="mutual?id1=<%=person.getId() %>&id2=<%=per.getId()%>" 
							class="btn btn-primary btn-lg active" 
							role="button" aria-pressed="true">Mutual</a>
							</td>
						</tr>
						<%
						}
						%>
						</tbody>
						</table>
					</div>
				</div>
			</div>
										<!-- Table Post -->
		<div class="row">
			<div class="col-10">
				<h1
					style="text-align: center; font-family: cursive; font-style: oblique;">Post Person</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-10">
				<div class="table-responsive">
					<table class="table table-dark table-striped table-hover">
						<thead>
						<tr class="bg-primary">
							<th scope="col">Title</th>
							<th scope="col">Content</th>
							<th scope="col">Post date</th>
						</tr>
						</thead>
						<tbody>
						<%
						for(Post perpost : person.getPost()) {
						
						%>
						<tr>
							<td class="bg-primary"><%=perpost.getTitle()%></td>
							<td class="bg-success"><%=perpost.getContent()%></td>
							<td class="bg-warning"><%=perpost.getPost_date()%></td>
						</tr>
						<%
						}
						%>
						</tbody>
						</table>
					</div>
				</div>
			</div>
	</div>
</body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>