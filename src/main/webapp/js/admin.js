function checkPawd(){

	var pwad=document.getElementById("changepwd1_id").value;
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

	var pwad=document.getElementById("changepwd1_id").value;
	var pwad1=document.getElementById("changepwd2_id").value;
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