<%@page import="info.StuCourinfo"%>
<%@page import="info.Userinfo"%>
<%@page import="info.Stuinfo"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>我的选修课</title>
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
		
		Object obj2 = request.getAttribute("courses");
		List<StuCourinfo> courses = (List<StuCourinfo>)obj2;
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
                

<h2 class="mbx">教务中心 &gt; 我的选修课</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="stulistcourse.do">我的选修课</a> </li>
    <li><a class="tab1" onclick="" href="stuallcourse.do">选修课列表</a> </li>
</ul>

</div>
<div class="kctable">
    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody><tr>
        		<td>课程号：</td>
            <td>课程名：</td>
            <td>授课老师：</td>
            <td>学时：</td>
            <td>学分：</td>
            <td>开课时间：</td>
            <td>操作：</td>
        </tr>
        <%
        	if(courses != null){
        		for(StuCourinfo sc:courses){
            	
            		%>
            		<tr>
                	<td><%=sc.getStucouid() %>&nbsp;</td>
                	<td><%=sc.getStucouname() %>&nbsp;</td>
                	<td><%=sc.getTeaname() %>&nbsp;</td>
               	<td><%=sc.getStustytime() %>&nbsp;</td>
                	<td><%=sc.getStuscore() %>&nbsp;</td>
                	<td><%=sc.getStustatime() %>&nbsp;</td>
                	<td><a href="studelcourse.do?stucouid=<%=sc.getStucouid() %>&&stuid=<%=sc.getStuid() %>" 
                	onclick="return confirm('确定删除<%=sc.getStucouname() %>吗？');">删除</a></td>
            		</tr>
            		
            		<%
            	}
        	}
        
        %>
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