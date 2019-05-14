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
	<script src="js/classificationjquery.js"></script>
	<br/>
	<%@ include file="fragments/Header.jsp" %>

	<div class="col-xs-8">
		<div>
			<button type="button" data-toggle="modal" data-target="#exampleModal" class="btn btn-success" style="float: right;">Add Classification</button>
		</div>
		<div class="modal" tabindex="-1" role="dialog" id="exampleModal">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <center><h4 class="modal-title">Add New Classification</h4></center>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
					<form  method="post" id="classificationform">
						  <div class="form-group">
						    <label for="classification_id">Classification ID</label>
						    <input type="text" class="form-control" name="classification_id" placeholder="Classification ID">
						  </div>
						  <div class="form-group">
						    <label for="classification_name">Classification Name</label>
						    <input type="text" class="form-control" name="classification_name" placeholder="Classification Name">
						  </div>
					
			      </div>
			      <div class="modal-footer">
			       <input type="hidden" class="btn btn-primary" value=""/>
			        <input type="submit" class="btn btn-primary" value="submit"/>
			      </div>
			      </form>
			    </div>
			  </div>
		</div>
		<table class= "table table-striped" id="classificationtable">
		<thead>
  			<tr>
  				<th>Classification Id</th>
  				<th>Classification Name</th>
  				<th>Edit</th>
  				<th>Delete</th>
  			</tr>
  		</thead>
  		<tbody>
  		
  		</tbody>
		</table>
	</div>

	<%@ include file="fragments/Footer.jsp" %>
</body>
</html>