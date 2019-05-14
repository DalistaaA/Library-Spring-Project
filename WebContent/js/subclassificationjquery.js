
$(document).ready(function(){
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
