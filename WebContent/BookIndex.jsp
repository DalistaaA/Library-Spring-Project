<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
</head>
<body>
<script src="js/bookjquery.js"></script>
<br>
	<%@ include file="fragments/Header.jsp" %>
	
	<div class="col-xs-8">
		<div>
			<button type="button" data-toggle="modal" data-target="#exampleModalb" class="btn btn-success" style="float: right;">Add Book</button>
		</div>
		<form id="bookform" method="post">
		<div class="modal" tabindex="-1" role="dialog" id="exampleModalb">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <center><h4 class="modal-title">Add New Book</h4></center>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
						  <div class="form-group">
						    <label for="book_id">Book ID</label>
						    <input type="text" class="form-control" name="book_id" placeholder="Book ID">
						  </div>
						  <div class="form-group">
						    <label for="book_name">Book Name</label>
						    <input type="text" class="form-control" name="book_name" placeholder="Book Name">
						  </div>
						  <div class="form-group">
						    <label for="published_date">Published Date</label>
						    <input type="text" class="form-control" name="published_date" placeholder="Published Date">
						  </div>
						  <div class="form-group">
						    <label for="subclassification_id">Sub Classification Id</label>
						    <input type="text" class="form-control" name="subclassification_id" placeholder="Sub Classification Id">
						  </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <input type="submit" class="btn btn-primary"/>
			      </div>
			    </div>
			  </div>
		</div>
		</form>
		<table class= "table table-striped">
		<thead>
  			<tr>
  				<th>Book Id</th>
  				<th>Book Name</th>
  				<th>Published Date</th>
  				<th>SubClassification ID</th>
  				<th colspan="2">Action</th>
  			</tr>
  			<tr>
  				<td>1</td>
  				<td>Applied Biology</td>
  				<td>1</td>
  				<td>Applied Biology</td>
  				<td><button class="btn btn-warning">Edit</button></td><td><button class="btn btn-danger">Delete</button></td>
  			</tr>
  		</thead>
		</table>
	</div>
	
	<%@ include file="fragments/Footer.jsp" %>
</body>
</html>