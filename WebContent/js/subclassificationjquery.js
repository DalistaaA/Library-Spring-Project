$(document).ready(function() {
	find_subclassification()
	$("#subclassificationform").submit(function(event){
		event.preventDefault();
		console.log($("#subclassificationform").serialize());
		$.ajax({
			url:'SubClassificationController',
			type:'post',
			data : $("#subclassificationform").serialize(),
			success : function(data){
				alert(data+" Sub Classification is created ....");
			}
		});
	});
});

function find_subclassification() {
	console.log("fdfd");
	$.ajax({
		url:'SubClassificationController',
		type:'get',
		success:function(data){
			$.each(data.subClassification, function(key, subClassificationList){
				console.log(subClassificationList);
				var row=`
				<tr>
				<td>${subClassificationList.sub_classification_id}</td>
				<td>${subClassificationList.sub_classification_name}</td>
				<td>${subClassificationList.classification_id}</td>
				<td><button class='btn btn-warning'>Edit</button></td>
				<td><button class='btn btn-danger'>Delete</button></td>
				</tr>`;
				$("#subclassificationtable tbody").append(row);
			})
		}
	})
}