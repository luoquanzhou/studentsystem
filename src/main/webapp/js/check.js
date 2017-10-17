function check_courid(){
	$.ajax({
		url:"checkcourid.do",type:"get",data:"couid="+$('#inputcou_id').val(),dataType:"text",success:function(data){
			$('#id_selterror').html(data);
		}
	});
	
}