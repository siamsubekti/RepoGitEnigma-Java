<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.enigmacamp.friends.db.entities.Person"%>
<%@page import="com.enigmacamp.friends.db.entities.*" %>
<%@page import="java.util.Date"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% DateFormat format = new SimpleDateFormat("dd-MM-yyyy"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Media Project</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
				<a class="nav-link" href="/friends-servlet/webiste">Person
						<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Post</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/friends-servlet/ListAllCategory">Category</a></li>
			</ul>
		</div>
	</nav>


		<div class="container">
		<div class="row">
			<div class="col-10">
				<h1 style="text-align: center; font-family: cursive; font-style: oblique;">Post List</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-10">
				<div class="table-responsive">
					<table class="table table-dark table-striped table-hover">
						<thead>
						<tr class="bg-primary">
						<a href="addpost" 
								class="btn btn-primary btn-lg active" role="button" aria-pressed="true" 
								style="float: right;">Add Post</a>
							<th scope="col">No</th>
							<th scope="col">title</th>
							<th scope="col">Content</th>
							<th scope="col">Post Date</th>
							<th scope="col">Action</th>
						</tr>
						</thead>
						<tbody>
							<%
								int n = 1;
							%>
							<%
								for (Post post : (List<Post>) request.getAttribute("post")) {
							%>
						
						<tr>
							<th><%=n++%></th>
							<td class="bg-primary"><%=post.getTitle()%></td>
							<td class="bg-success"><%=post.getContent()%></td>
							<td class="bg-warning"><%=post.getPost_date()%></td>
							<td>
							<a href="PostId?id=<%=post.getId()%>" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Details</a>
							<a href="UpdatePost?id=<%=post.getId() %>" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Update</a>
							</td>
						</tr>
						<%
							}
						%>
						</tbody>
						</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
</body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>