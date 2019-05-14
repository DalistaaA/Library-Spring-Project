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
<script src="js/subclassificationjquery.js"></script>
<br>
	<%@ include file="fragments/Header.jsp" %>
	<div class="col-xs-8">
			<div>
				<button type="button" data-toggle="modal" data-target="#exampleModals" class="btn btn-success" style="float: right;">Add Sub Classification</button>
			</div>
			<div class="modal" tabindex="-1" role="dialog" id="exampleModals">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <center><h4 class="modal-title">Add New Sub Classification</h4></center>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				      <form id="subclassificationform" method="post">
							  <div class="form-group">
							    <label for="sub_classification_id">Sub Classification ID</label>
							    <input type="text" class="form-control" name="sub_classification_id" placeholder="Sub Classification ID">
							  </div>
							  <div class="form-group">
							    <label for="sub_classification_name">Sub Classification Name</label>
							    <input type="text" class="form-control" name="sub_classification_name" placeholder="Sub Classification Name">
							  </div>
							  <div class="form-group">
							    <label for="classification_id">Classification ID</label>
							    <input type="text" class="form-control" name="classification_id" placeholder="Classification ID">
							  </div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				        <input type="submit" class="btn btn-primary" value="Submit"/>
				      </div>
				      </form>
				    </div>
				  </div>
			</div>
			<table class= "table table-striped">
			<thead>
	  			<tr>
	  				<th>Sub Classification ID</th>
	  				<th>Sub Classification Name</th>
	  				<th>Classification ID</th>
	  				<th colspan="2">Action</th>
	  			</tr>
	  			<tr>
	  				<td>1</td>
	  				<td>Applied Biology</td>
	  				<td>1</td>
	  				<td><button class="btn btn-warning">Edit</button></td><td><button class="btn btn-danger">Delete</button></td>
	  			</tr>
	  		</thead>
			</table>
		</div>
	
	<%@ include file="fragments/Footer.jsp" %>
</body>
</html>