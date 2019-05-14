
$(document).ready(function(){
	find_author();
	$("#authorform").submit(function(event){
		event.preventDefault();
		console.log($("#authorform").serialize());
		$.ajax({
			url:'AuthorController',
			type:'post',
			data : $("#authorform").serialize(),
			success : function(data){
				alert(data+"Author is created.....");
			}
		});
	});
	
	function find_author() {
		$.ajax({
					url : 'AuthorController',
					type : 'get',
					success : function(datas) {
						//console.log(datas);
						$.each(datas.classification,function(key, authorList) {
											console.log(authorList);
											var row = `<tr>
												<td>${authorList.AuthorId}</td>
												<td>${authorList.AuthorName}</td>
												<td><button class="btn btn-warning editaction" data-id='${authorList.AuthorId}'>Edit</button></td>
												<td><button class="btn btn-danger deleteaction" data-id='${authorList.AuthorId}'>Delete</button></td>
												</tr>`;
											$("#authortable tbody").append(row);
										})
					}
				})
	}
});
