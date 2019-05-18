<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
	<%@ include file="fragments/Header.jsp" %>
	
	<div class="col-xs-8">
		<div>
			<button type="button" data-toggle="modal" data-target="#exampleModalb" class="btn btn-success" style="float: right;">Add Book</button>
		</div>
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
			      <form id="bookform" method="post">
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
			      </form>
			    </div>
			  </div>
		</div>
		<table class= "table table-striped" id="booktable">
		<thead>
  			<tr>
  				<th>Book Id</th>
  				<th>Book Name</th>
  				<th>Published Date</th>
  				<th>SubClassification ID</th>
  				<th colspan="2">Action</th>
  			</tr>
  		</thead>
  		<tbody>
  		
  		</tbody>
		</table>
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
		integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
		crossorigin="anonymous"></script>
		
		<script src="js/bookjquery.js"></script>
</body>
</html>