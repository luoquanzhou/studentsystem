<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="info.Userinfo"%>
<%@page import="info.Teainfo"%>
<%@page import="info.Stuinfo"%>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<link href="<%=request.getContextPath() %>/css/admininformation_list.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/jbox.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/ks.css" rel="stylesheet" type="text/css">

<script src="<%=request.getContextPath() %>/js/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath() %>/js/admin.js" type="text/javascript"></script>
   
    
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
	<div class="banner">
        <div class="bgh">
            <div class="page">
                <div id="logo">
                    <a href="#">
                        <img src="<%=request.getContextPath() %>/imgs/logo.png" alt="" width="165" height="48">
                    </a>
                </div>
                <div class="topxx">
                    		用户：<%=user.getUsername() %>，欢迎您！ 
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
                

<h2 class="mbx">个人中心 &gt; 修改密码</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="#">我的信息</a> </li>
</ul>
<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="tochangepwd.do">修改密码</a> </li>
</ul>
</div>
<div class="cztable">
	<form action="changepwd.do" onsubmit="return checkPawd()+checkPwad1()==2" method="post">
    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody>
       	<tr>
            <td width="100" align="left">新密码：</td>
            <td colspan="5"><input  type="password" id="changepwd1_id" maxlength="16" placeholder="请输入密码(6-16位数字、字母或者字符的组合)" style="width:300px;height:25px;float:left;" onblur="checkPawd();"/>
            	<span id="id_pawderror" style="color:red;font-size: 13px;float:left;" >${mesg }</span>
            	<%session.removeAttribute("mesg"); %>
            </td>
        </tr>
        <tr>
            <td width="100" align="left">确认新密码：</td>
            <td colspan="5"><input type="password" name="changepwd"  id="changepwd2_id" maxlength="16" placeholder="请输入密码(6-16位数字、字母或者字符的组合)" style="width:300px;height:25px;float:left;" onblur="checkPwad1();"/>
            	<span id="id_pawd1error"></span>
            </td>
       		
        </tr>
        
        
        
    </tbody></table>
    <p><input type="submit" class="button" value="确认" /></p>
	</form>
</div>

            </div>
        </div>
        <div class="footer">
            <p>
                ©copyright 2017 达内科技 tedu.cn 版权所有</p>
        </div>
    </div>
</body>
</html>