
$(document).ready(function(){
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
