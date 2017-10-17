<%@page import="java.util.List"%>
<%@page import="info.Userinfo"%>
<%@page import="info.Teainfo"%>
<%@page import="info.Stuinfo"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>添加新用户</title>
<link href="<%=request.getContextPath() %>/css/admininformation_list.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/jbox.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/ks.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath() %>/js/jquery-1.11.1.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/login.js"></script>   
</head>
<body>
	<%
		Userinfo user = (Userinfo)session.getAttribute("userinfo");
		if(!user.getUsertype().equals("0")){
			response.sendRedirect(request.getContextPath()+"/login/login.html");
			session.removeAttribute("userinfo");
			return;
		}
	%>
	<
	<div class="banner">
        <div class="bgh">
            <div class="page">
                <div id="logo">
                    <a href="#">
                        <img src="<%=request.getContextPath() %>/imgs/logo.png" alt="" width="165" height="48">
                    </a>
                </div>
                <div class="topxx">
                    		管理员：<%=user.getUsername() %>，欢迎您！ 
                    	<a href="#">我的信息</a> 
                    	<a href="#">通知</a>
                    	<a href="tochangepwd.do">密码修改</a> 
                    	<a href="logout.do">安全退出</a>
                </div>
                <div class="blog_nav">
                    <ul>
                        <li><a href="#">个人中心</a></li>
                        <li><a href="admlist.do">管理中心</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="page">
        <div class="box mtop">
            <div class="leftbox">
                <div class="l_nav2">
                    <div class="ta1">
                        <strong>个人中心</strong>
                        <div class="leftbgbt">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="#">我的信息</a>
                        </div>
                        <div>
                            <a href="tochangepwd.do">修改密码</a>
                        </div>
                    </div>
                    <div class="ta1">
                        <strong>管理中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="admlist.do">用户管理</a>
                        </div>
                        <div>
                            <a href="#">课程管理</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="rightbox">
                

<h2 class="mbx">管理中心 &gt; 用户管理 &gt; 添加新用户</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="admlist.do">用户管理</a> </li>
</ul>
<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="#">课程管理</a> </li>
</ul>
</div>
<div class="cztable">
	<form action="admadd.do" method="post">
    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody>
       				<tr>
								<td valign="middle" align="right" width="126px">
									用户类别:
								</td>
								<td valign="middle" align="left">
									
								<p class="select_p" style="float:left;">
									<select class="select_box" id="id_selt" onchange="checkSec();" name="usertype" style="float:left;">
										<option selected>请选择：</option>
										<option value="1">学生</option>
										<option value="2">教师</option>
										<option value="0">管理员</option>
								</select>
								<span class="select_error" id="id_selterror" style="float:left;font-size: 14px;line-height: 24px;color: red;">${info_error }</span>
								</p>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right" width="126px">
									用户名:
								</td>
								<td valign="middle" align="left">
									<p style="float:left;"><input id="inputname_id" type="text" class="inputgri" name="username" onblur="checkName();" style="float:left;"/></p>
									<p style="float:left;width:300px;height: 20px;"><span class="select_error" id="id_nameerror" style="font-size: 14px;line-height: 24px;color: red;"></span></p>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right" width="126px">
									用户密码:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="userpwd" />
								</td>
							</tr>
        
    </tbody></table>
   <input type="submit" class="button" value="确定" />
   </form>
	</div>

   
        <div class="footer">
            <p>
                ©copyright 2017 达内科技 tedu.cn 版权所有</p>
        </div>
    </div>
</body>
</html>