
$(function(){
	$("#classificationform").submit(function(event){
		event.preventDefault();
		console.log($("#classificationform").serialize());
		$.ajax({
			url:'ClassificationController',
			type:'post',
			data : $("#classificationform").serialize(),
			success : function(data){
				alert(data);
			}
		});
	});
});

$(function(){
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
});