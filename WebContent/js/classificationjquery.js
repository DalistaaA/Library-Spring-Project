$(document).ready(function() {
	
	find_classification();
	$("#classificationform").submit(function(event) {
		event.preventDefault();
		console.log($("#classificationform").serialize());
		$.ajax({
			url : 'ClassificationController',
			type : 'post',
			data : $("#classificationform").serialize(),
			success : function(data) {
				//alert(data);
			}
		});
	});
	
	function find_classification() {
		$.ajax({
					url : 'ClassificationController',
					type : 'get',
					success : function(datas) {
						//console.log(datas);
						$.each(datas.classification,function(key, classificationList) {
											console.log(classificationList);
											var row = `<tr>
												<td>${classificationList.ClassificationId}</td>
												<td>${classificationList.ClassificationName}</td>
												<td><button class="btn btn-warning editaction" data-id='${classificationList.classificationId}'>Edit</button></td>
												<td><button class="btn btn-danger deleteaction" data-id='${classificationList.classificationId}'>Delete</button></td>
												</tr>`;
											$("#classificationtable tbody").append(row);
										})
					}
				})
	}
	
});

