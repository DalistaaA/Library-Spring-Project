
$(document).ready(function(){
	find_book()
	$("#bookform").submit(function(event){
		event.preventDefault();
		console.log($("#bookform").serialize());
		$.ajax({
			url:'BookController',
			type:'post',
			data : $("#bookform").serialize(),
			success : function(data){
				alert(data+"Book is created.....");
			}
		});
	});
});

function find_book() {
	$.ajax({
		url:"BookController",
		type:"get",
		success:function(data){
			$.each(data.book, function(key, bookList) {
				console.log(bookList);
				var row=`
				<tr>
				<td>${bookList.book_id}</td>
				<td>${bookList.book_name}</td>
				<td>${bookList.published_date}</td>
				<td>${bookList.sub_classification_id}</td>
				<td><button class='btn btn-warning'>Edit</button></td>
				<td><button class='btn btn-danger'>Delete</button></td>
				</tr>`;
				$("#booktable tbody").append(row);
			})
		}
	});
}