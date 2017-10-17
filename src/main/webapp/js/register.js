function checkReg(){
	var register=document.getElementById("id_reg").value;
	var regerror=document.getElementById("id_regerror");
	var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+.([a-zA-Z0-9_-])+$/;
	if(reg.test(register)){
		regerror.innerHTML="";
		regerror.className="ok"
		return true;
	}else if(register.length==0){
		regerror.innerHTML="请输入邮箱";
		regerror.className="error";
		return false;
	}else{
		regerror.innerHTML="请输入正确的邮箱";
		regerror.className="error";
		return false;
	}
}

function checkUser(){
	var username=document.getElementById("id_user").value;
	var usererror=document.getElementById("id_usererror");
	var reg=/^[a-zA-Z0-9]{5,16}$/;
	if(reg.test(username)){
		usererror.innerHTML="";
		
		$.ajax({
			url:"admcheckname.do",
			type:"get",
			data:'name='+$('#id_user').val(),
			textType:"text",
			success:function(data){
				if(data==1){
					$('#id_usererror').html('此用户名已存在');
					$('#id_usererror').addClass('error');
					return false;
				}else{
					$('#id_usererror').html('');
					$('#id_usererror').remove('error');
				}
			}
		});
		
		usererror.className="ok";
		return true;
		
	}else if(username.length==0){
		usererror.innerHTML="请输入学号";
		usererror.className="error";
		return false;
	}else if(username.length<5){
		usererror.innerHTML="学号长度5-16个字符";
		usererror.className="error";
		return false;
	}else{
		usererror.innerHTML="学号只能含有中英文、数字";
		usererror.className="error";
		return false;
	}
}
function checkEmail(){
	var email=document.getElementById("id_email").value;
	var emailerror=document.getElementById("id_emailerror");
	var reg=/^[a-zA-Z0-9]{4}$/;
	if(reg.test(email)){
		emailerror.innerHTML="";
		emailerror.className="ok";
		return true;
	}else if(email.length==0){
		emailerror.innerHTML="请输入验证码";
		emailerror.className="error";
		return false;
	}else if(email.length<4){
		emailerror.innerHTML="验证码长度4个字符";
		emailerror.className="error";
		return false;
	}else{
		emailerror.innerHTML="验证码格式有误";
		emailerror.className="error";
		return false;
	}
}

function checkPawd(){
	var pwad=document.getElementById("id_pawd").value;
	var pwaderror=document.getElementById("id_pawderror");
	var reg=/^[a-zA-Z0-9\@\#\!\$\^\&\*\.\~]{6,16}$/;
	if(reg.test(pwad)){
		pwaderror.innerHTML="";
		pwaderror.className="ok";
		return true;
	}else if(pwad.length==0){
		pwaderror.innerHTML="请输入密码";
		pwaderror.className="error";
		return false;
	}else{
		pwaderror.innerHTML="密码长度6-16位数字、字母";
		pwaderror.className="error";
		return false;
	}
}
function checkPwad1(){
	var pwad=document.getElementById("id_pawd").value;
	var pwad1=document.getElementById("id_pwad1").value;
	var pwad1error=document.getElementById("id_pawd1error");
	var reg=/^[a-zA-Z0-9\@\#\!\$\^\&\*\.\~]{6,16}$/;
	if(reg.test(pwad1)&&pwad1==pwad){
		pwad1error.innerHTML="";
		pwad1error.className="ok";
		return true;
	}else if(pwad1.length==0){
		pwad1error.innerHTML="请再次输入密码";
		pwad1error.className="error";
		return false;
	}else{
		pwad1error.innerHTML="密码不一致";
		pwad1error.className="error";
		return false;
	}
}

function checkBox(){
	var check=document.getElementById("id_check");
	var a=$("#checks").checked;
	if(a){
		check.innerHTML="";
		check.className="ok";
		return true;
	}else{
		check.innerHTMl="请阅读协议";
		check.className="error1";
		return false;
	}
}


function getregsitercode(){
	var email=$('#id_reg').val();
	var emailerror=$('#id_regerror');
	if(email==""){
		emailerror.addClass('error');
		emailerror.html("请输入邮箱");
		return false;
	}
	
	var bt=document.getElementById("getcode_id");
	bt.disabled=true;
	
	$.ajax({
		url:"getregcode.do",
		type:"get",
		data:"emailadd="+email,
		textType:"text",
		success:function(data){}
	});
	var n=30;
	var id=setInterval(function(){
		if(n>0){
			$("#getcode_id").val(n+"秒后重试");
			n--;
		}	
	}, 1000);
	setTimeout(function(){
		clearInterval(id);
		$("#getcode_id").val("获取验证码");
		bt.disabled=false;
	}, 30000);
	
}


function checkEmail(){
	var code=$("#id_email").val();
	var error=$("#id_emailerror");
	var reg=/^[a-zA-Z0-9]{4,6}$/;
	if(code==""){
		error.addClass("error");
		error.html("请输入验证码");
		return false;
	}
	if(reg.test(code)){
		$.ajax({
			url:"checkcode.do",
			type:"get",
			data:"reggistercode="+code,
			textType:"text",
			success:function(data){
				if(data==1){
					error.removeCalss("error");
					return true;
				}else if(data==2){
					error.addClass("error");
					error.html("系统异常，请稍后再试");
					return false;
				}else{
					error.addClass("error");
					error.html("验证码不正确");
					return false;
				}
			}
		});
	}else{
		error.addClass("error");
		error.html("验证码格式有误");
		return false;
	}
}






















