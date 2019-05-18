$(document).ready(function() {
	find_classifications()
	$("#classificationform").submit(function(event) {
		event.preventDefault();
		console.log($("#classificationform").serialize());
		$.ajax({
			url : 'ClassificationController',
			type : 'post',
			data : $("#classificationform").serialize(),
			success : function(data) {
				console.log(data);
			}
		});
	});
	
});

function find_classifications() {
	$.ajax({
		url:"ClassificationController",
		type:"get",
		success:function(data){
			$.each(data.classification, function(key, classificationList) {
				console.log(classificationList);
				var row=`
				<tr>
				<td>${classificationList.classification_id}</td>
				<td>${classificationList.classification_name}</td>
				<td><button class='btn btn-warning'>Edit</button></td>
				<td><button class='btn btn-danger'>Delete</button></td>
				</tr>`;
				$("#classificationtable tbody").append(row);
			})
		}
	});
}