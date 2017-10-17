
<%@page import="tea.dao.TeainfoDAO"%>
<%@page import="info.Userinfo"%>
<%@page import="info.Teainfo"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>我的信息</title>
<link href="<%=request.getContextPath() %>/css/stuinformation_list.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/ks.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/check.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.11.1.js"></script>
</head>
<body>
	<%
	Userinfo user = (Userinfo)session.getAttribute("userinfo");
	if(!user.getUsertype().equals("2")){
		response.sendRedirect(request.getContextPath()+"/login/login.html");
		session.removeAttribute("userinfo");
		return;
	}
	String teaid=user.getUsername();
	//Teainfo teacher=new TeainfoDAO().findTeaById(teaid);
	//String teaname=teacher.getTeaname();
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
                    	<%=teaid %>教师：${teacher.teaname }，欢迎您！  
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
                            <a href="tealist.do">我的信息</a>
                        </div>
                        <div>
                            <a href="teaload.do">修改信息</a>
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
                

<h2 class="mbx">教务中心 &gt; 添加新课程</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab1" onclick="" href="teacoulist.do" id="d1">我的课程列表</a> </li>
    <li><a class="tab2" onclick="" href="toteaaddcou.do">添加新课程</a> </li>
</ul>

</div>
<div class="cztable">
	<form action="teaaddcou.do" onsubmit="return checkSec()+checkCode()+checkPawd()==3"method="post">
    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody>
       				<tr>
							<td valign="middle" align="right" class="td_s">课程ID:</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" id="inputcou_id" name="couid" placeholder="课程名首字母大写+三位数字(C100)" onblur="check_courid();"style="float:left;"/> 
								<p class="select_p"><span class="select_error" id="id_selterror" style="color:red;font-size: 13px;float:left;">${info_error }</span></p>
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right" class="td_s">课程名字:</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="couname" /> 
								
							</td>
						</tr>
						<tr>
							<td valign="middle" align="right" class="td_s">学时:</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="coustytime" /> 
							</td>
						</tr>
						
						<tr>
							<td valign="middle" align="right" class="td_s">学分:</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="couscore" /> 
							</td>
						</tr>
						
						<tr>
							<td valign="middle" align="right" class="td_s">开课时间:</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="coustatime" /> 
							</td>
						</tr>
						
					
        
    </tbody></table>
   <input type="submit" class="button" value="确定" />
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
