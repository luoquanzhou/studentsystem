<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login_list.css"/>
<script src="<%=request.getContextPath() %>/js/jquery-1.11.1.js"></script>
<script src="<%=request.getContextPath() %>/js/login.js"></script>
</head>
<body>

	<!-- logo -->
	<div class="logo"></div>
	<!-- data -->
	<div class="data">
	
		<form action="login.do" onsubmit="return checkSec()+checkCode()+checkPawd()+checkauto()==4" method="post" >
		<p class="loginlogo"><span class="loginlogo_hint">登录</span></p>
		<ul class="logintext">
			<%
				String info=(String)request.getAttribute("info_error");
			%>
			<li class="select">
				<p class="select_log">登录方式</p>
				<span class="select_error" id="id_selterror" style="color:red;"><%=(info==null?"":info) %></span>
				<p class="select_p">
					<select class="select_box" id="id_selt" onchange="checkSec();" name="usertype">
						<option selected>请选择：</option>
						<option value="1">学生</option>
						<option value="2">教师</option>
						<option value="0">管理员</option>
					</select>
						
				</p>
			</li>
			
			<li>
				<p class="account">用户帐号</p>
				<p class="account_error" id="id_acterror"></p>
				<p class="account_hint">没有帐号？<a href="/spring-exercise/register/register.html"class="account_a1">快速注册</a></p>
				<input type="text" placeholder="请输入帐号" class="account_input" id="id_input" onblur="checkCode();" name="username"/>
			</li>
			<li>
				<p class="password">用户密码</p>
				<p class="password_error" id="id_pawderror"></p>
				<p class="password_hint"><a href="#" class="password_a2">忘记密码？</a></p>
				<input type="password" placeholder="请输入密码" class="password_input" id="id_pawd" onblur="checkPawd();" name="userpwd"/>
			</li>
			<li>
				<p class="autocode">验证码</p>
				<p class="autocode_error" id="id_autocodeerr"></p>
			
				
				<p class="autocode_hint"><a href="javascript:;"  class="autocode_a2" onclick="document.getElementById('codeimg_id').src='autocode.do?<%=Math.random()%>'" >看不清？换一张</a></p><!--"$('#codeimg_id').val('src','autocode.do')"  -->
				<img src="autocode.do" border="1"  id="codeimg_id" class="codeimg" onclick="document.getElementById('codeimg_id').src='autocode.do?<%=Math.random()%>'"/>
				<input type="text" placeholder="请输入验证码" class="autocode_input" id="id_autocode" onblur="checkauto();" name="autocode"/>
			</li>
			
			<li>
				
				<a class="login"><input type="submit" value="登录" class="login_but"/></a>
			</li>
		</ul>
		</form>
	</div>
	<!-- copy -->
	<div class="copy">
		<p>© 2017</p>
		<p>版权所有，盗版必究</p>
	</div>
</body>
</html>