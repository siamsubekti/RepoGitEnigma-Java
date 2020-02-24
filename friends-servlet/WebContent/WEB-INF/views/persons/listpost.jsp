<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.enigmacamp.friends.db.entities.Person"%>
<%@page import="com.enigmacamp.friends.db.entities.*" %>


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
							<a href="#" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Link</a>
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