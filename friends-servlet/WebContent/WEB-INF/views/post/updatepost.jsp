<%@page import="com.enigmacamp.friends.db.entities.Post"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.enigmacamp.friends.db.entities.Person"%>
<%@page import="com.enigmacamp.friends.db.entities.*" %>
<%@page import="java.util.Date"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); %>
    <% 
		Post post = (Post) request.getAttribute("update"); 
		%>
		
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Update Post</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
				<a class="nav-link" href="/friends-servlet/ListAllPost">Back to List
						<span class="sr-only">(current)</span></a>
			</ul>
		</div>
	</nav>
	
	<div class="row">
			<div class="col-10">
				<h1
					style="text-align: center; font-family: cursive; font-style: oblique;">Edit Post</h1>
			</div>
		</div>
	
	<div class="row">
		<div class="col-12">
			<div class="table-responsive">
				<form action="" method="post">
					<div class="form-row">
						
						<div class="col-md-4 mb-3">
							<label for="validationDefault01">Id</label> <input 
								value="<%=post.getId()%>"
								type="text" class="form-control" id="validationDefault01"
								placeholder="Name" name="id" required>
							<label for="validationDefault01">Title</label> <input 
								value="<%=post.getTitle() %>"
								type="text" class="form-control" id="validationDefault01"
								placeholder="Name" name="title" required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationDefault02">Content</label> <input
								value="<%=post.getContent()%>"
								type="text" class="form-control" id="validationDefault02"
								placeholder="Your Born" name="content" required>
						</div>
						<div class="col-md-4 mb-3">
							<label for="validationDefault02">Post Date</label> <input
								value="<%=format.format(post.getPost_date())%>"
								type="date" class="form-control" id="validationDefault03"
								placeholder="your gender" name="postdate" required>
						</div>
					</div>
				<button class="btn btn-primary" type="submit">Submit</button>
			</form>
		</div>
	</div>	
	

</body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>