function checkCode(){
	var username=$("#id_input").val();
	var acterror=$("#id_acterror");
	var reg=/^\w{5,16}$/;
	if(reg.test(username)){
		acterror.html("");
		acterror.removeClass("error");
		return true;
	}else{
	
		acterror.html("请输入正确的用户名");
		acterror.addClass("error");
		return false;
	}
}

function checkPawd(){
	var password=$("#id_pawd").val();
	var pawderror=$("#id_pawderror");
	var reg=/^\w{6,16}$/;
	if(reg.test(password)){
		pawderror.html("");
		pawderror.remove("error");
		return true;
	}else{
		pawderror.html("请输入密码");
		pawderror.addClass("error");
		return false;
	}
	
}
function checkSec(){
	var select=document.getElementById("id_selt").value;
	var selecterror=document.getElementById("id_selterror");
	
	if(select=="0"||select=="1"||select=="2"){
		selecterror.innerHTML="";
		selecterror.className="ok";
		return true;
	}else{
		selecterror.innerHTML="请选择登录方式";
		selecterror.className="error";
		return false;
	}
	
}
function checkauto(){
	var num=$("#id_autocode").val();
	var error=$("#id_autocodeerr");
	var reg=/^[a-zA-Z0-9]{4,}$/;
	if(reg.test(num)){
		error.html("");
		error.remove("error");
		return true;
	}else{
		error.html("请输入正确的验证码");
		error.addClass("error");
		return false;
	}
}

function checkName(){
	$.ajax({
		url:"admcheckname.do",
		type:"get",
		data:'name='+$('#inputname_id').val(),
		textType:"text",
		success:function(data){
			if(data==1){
				$('#id_nameerror').html('此用户名已存在');
				$('#id_nameerror').addClass('error');
			}else{
				$('#id_nameerror').html('');
				$('#id_nameerror').remove('error');
			}
		}
	});
}