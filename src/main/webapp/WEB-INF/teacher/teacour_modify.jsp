<%@page import="info.Userinfo"%>
<%@page import="info.Teainfo"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>修改信息</title>
<link href="<%=request.getContextPath() %>/css/stuinformation_list.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/ks.css" rel="stylesheet" type="text/css">

<link href="<%=request.getContextPath() %>/css/jbox.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		Userinfo user = (Userinfo)session.getAttribute("userinfo");
		if(!user.getUsertype().equals("2")){
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
                    	${teacher.teaid }教师：${teacher.teaname }，欢迎您！ 
                    	<a href="tealist.do">我的信息</a> 
                    	<a href="tochangepwd.do">密码修改</a> 
                    	<a href="logout.do">安全退出</a>
                </div>
                <div class="blog_nav">
                    <ul>
                        <li><a href="tealist.do">个人中心</a></li>
                        <li><a href="teacoulist.do">教务中心</a></li>
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
                            <a href="tealist.do" >我的信息</a>
                        </div>
                        <div>
                            <a href="teaload.do2">修改信息</a>
                        </div>
                    </div>
                       <div class="ta1">
                        <strong>教务中心</strong>
                        <div class="leftbgbt2">
                        </div>
                    </div>
                    <div class="cdlist">
                        <div>
                            <a href="teacoulist.do">我的课程列表</a>
                        </div>
                         <div>
                            <a href="toteaaddcou.do">添加新课程</a>
                        </div>
                    </div>
                    </div>
                    </div>
                
            
            <div class="rightbox">
                

<h2 class="mbx">教务中心 &gt; 修改课程</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab1" onclick="" href="teacoufind.do" id="d1">修改课程</a> </li>
    <li><a class="tab2" onclick="" href="toteaaddcou.do">添加新课程</a> </li>
</ul>

</div>
<div class="cztable">
	<form action="teacourmodify.do" method="post">
    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody>
        <tr>
            <td align="right">课程号：</td>
            <td colspan="5">${cour.couid }<input type="hidden" name="couid" value="${cour.couid }"/>&nbsp;</td>
        </tr>
        <tr>
            <td width="91" align="right">课程名：</td>
            <td colspan="5"><input name="couname" value="${cour.couname }"/>&nbsp;</td>
        </tr>
        <tr>
            <td align="right">学时：</td>
            <td colspan="5"><input name="coustytime" value="${cour.coustytime }"/>&nbsp;</td>
        </tr>
        <tr>
            <td align="right">学分：</td>
            <td colspan="5"><input name="couscore" value="${cour.couscore }"/>&nbsp;</td>
        </tr>
         <tr>
            <td align="right">开课时间：</td>
            <td colspan="5"><input name="coustatime" value="${cour.coustatime }"/>&nbsp;</td>
        </tr>
    </tbody></table>
    <p><input type="submit" value="确定"/></p>
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