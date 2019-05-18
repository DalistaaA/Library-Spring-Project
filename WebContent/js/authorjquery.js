$(document).ready(function(){
	find_authors()
	$("#authorform").submit(function(event){
		event.preventDefault();
		console.log($("#authorform").serialize());
		$.ajax({
			url:'AuthorController',
			type:'post',
			data : $("#authorform").serialize(),
			success : function(data){
				alert(data+" Author is created.....");
			}
		});
	});
});

function find_authors(){
	$.ajax({
		url:"AuthorController",
		type:"get",
		success:function(data){
			$.each(data.author, function(key, authorList) {
				console.log(authorList);
				var row=`
				<tr>
				<td>${authorList.author_id}</td>
				<td>${authorList.author_name}</td>
				<td><button class='btn btn-warning'>Edit</button></td>
				<td><button class='btn btn-danger'>Delete</button></td>
				</tr>`;
				$("#authortable tbody").append(row);
			})
		}
	})
}
