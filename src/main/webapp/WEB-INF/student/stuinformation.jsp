<%@page import="info.Userinfo"%>
<%@page import="info.Stuinfo"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>我的信息</title>
<link href="<%=request.getContextPath() %>/css/stuinformation_list.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/ks.css" rel="stylesheet" type="text/css">

</head>
<body>
	<%
		Userinfo user = (Userinfo)session.getAttribute("userinfo");
		if(!user.getUsertype().equals("1")){
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
                    ${stu.stuid }学员：${stu.stuname }，欢迎您！  
                    	<a href="stulist.do">我的信息</a> 
                    	<a href="tochangepwd.do">密码修改</a> 
                    	<a href="logout.do">安全退出</a>
                </div>
                <div class="blog_nav">
                    <ul>
                        <li><a href="stulist.do">个人中心</a></li>
                        <li><a href="stulistcourse.do">教务中心</a></li>
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
                            <a href="stulist.do">我的信息</a>
                        </div>
                        <div>
                            <a href="stuload.do">修改信息</a>
                        </div>
                    </div>
                    <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="stulistcourse.do">我的选修课</a>
                        </div>
                        <div>
                            <a href="stuallcourse.do">选修课列表</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="rightbox">
                

<h2 class="mbx">个人中心 &gt; 我的信息</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="stulist.do" id="d1">我的信息</a> </li>
    <li><a class="tab1" onclick="" href="stuload.do">修改信息</a> </li>
</ul>

</div>
<div class="cztable">
	
    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody>
        <tr>
            <td align="right">学号：</td>
            <td colspan="5">${stu.stuid} &nbsp;</td>
        </tr>
        <tr>
            <td width="91" align="right">姓名：</td>
            <td colspan="5">${stu.stuname }&nbsp;</td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td colspan="5">${stu.stusex }&nbsp;</td>
        </tr>
        <!-- private String stuid;
		private String stuname;
		private String stusex;
		private String stunum;
		private String stuacc;
		private String stutel;
		private String stuqq;
		private String stuemail;
		private String stuclass;
		private String stuprocour; -->

        <tr>
            <td align="right">班级：</td>
            <td colspan="5">${stu.stuclass }&nbsp;</td>
        </tr>
         <tr>
            <td align="right">年龄：</td>
            <td colspan="5">${stu.stuage }&nbsp;</td>
        </tr>
        <tr>
            <td align="right">专业：</td>
            <td colspan="5">${stu.stuprocour }&nbsp;</td>
        </tr>
        <tr>
            <td align="right">电话：</td>
            <td colspan="5">${stu.stutel }&nbsp;</td>
        </tr>
        <tr>
            <td align="right">QQ：</td>
            <td colspan="5">${stu.stuqq }&nbsp;</td>
        </tr>
        <tr>
            <td align="right">邮箱：</td>
            <td colspan="5">${stu.stuemail }&nbsp;</td>
        </tr>
        <tr>
            <td align="right">地址：</td>
            <td colspan="5">${stu.stuadd }&nbsp;</td>
        </tr>
    </tbody></table>
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
