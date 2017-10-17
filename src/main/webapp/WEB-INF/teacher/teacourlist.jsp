<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="info.TeaCourinfo"%>
<%@page import="info.Userinfo"%>
<%@page import="info.Teainfo"%>
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
                

<h2 class="mbx">教务中心 &gt; 我的课程列表</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="teacoulist.do" id="d1">我的课程列表</a> </li>
    <li><a class="tab1" onclick="" href="toteaaddcou.do">添加新课程</a> </li>
</ul>

</div>
<div class="cztable">
	    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody><tr>
        		<td>课程号：</td>
            <td>课程名：</td>
            <td>学时：</td>
            <td>学分：</td>
            <td>开课时间：</td>
            	<td>所选人数：</td>
            <td>操作：</td>
        </tr>
        <%
        Object obj2 = request.getAttribute("map");
			Map<TeaCourinfo,Integer> map=(Map<TeaCourinfo,Integer>)obj2;
        	if(map != null){
        		Set<Entry<TeaCourinfo,Integer>> m=map.entrySet();
        		for(Entry<TeaCourinfo,Integer> sc:m){
            	
            		%>
            		<tr>
                	<td><%=sc.getKey().getCouid() %>&nbsp;</td>
                	<td><%=sc.getKey().getCouname() %>&nbsp;</td>
                	<td><%=sc.getKey().getCoustytime() %>&nbsp;</td>
               		<td><%=sc.getKey().getCouscore() %>&nbsp;</td>
                	<td><%=sc.getKey().getCoustatime() %>&nbsp;</td>
                	<td><%=sc.getValue() %></td>
                	<td><a href="teadelcourse.do?teacouid=<%=sc.getKey().getCouid() %>" 
                	onclick="return confirm('确定删除<%=sc.getKey().getCouname() %>吗？');">删除</a>
                	&nbsp;<a href="teacoufind.do?id=<%=sc.getKey().getCouid()%>">修改</a></td>
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
