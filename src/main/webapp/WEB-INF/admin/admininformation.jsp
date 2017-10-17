<%@page import="java.util.List"%>
<%@page import="info.Userinfo"%>
<%@page import="info.Teainfo"%>
<%@page import="info.Stuinfo"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>管理员</title>
<link href="<%=request.getContextPath() %>/css/admininformation_list.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath() %>/css/jbox.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/css/ks.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath() %>/js/jquery-1.js" type="text/javascript"></script>
    
</head>
<body>
	<%
		Userinfo user = (Userinfo)session.getAttribute("userinfo");
		if(!user.getUsertype().equals("0")){
			response.sendRedirect(request.getContextPath()+"/login/login.html");
			session.removeAttribute("userinfo");
			return;
		}
		
		List<Userinfo> list=(List<Userinfo>)request.getAttribute("list");
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
                

<h2 class="mbx">管理中心 &gt; 用户管理</h2>  
<div class="morebt">
    

<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="admlist.do">用户管理</a> </li>
</ul>
<ul id="ulStudMsgHeadTab">
    <li><a class="tab2" onclick="" href="#">课程管理</a> </li>
</ul>
</div>
<div class="cztable">
	
    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody>
       			 <tr class="table_header" style="background-color: #98c9ee;font-size: 18px;">
							<td>用户类型</td>
							<td>帐号</td>
							<td>密码</td>
							<td>操作</td>
						</tr>
        	<%
							
							for(int i=0;i<list.size();i++){
								Userinfo e=list.get(i);%>
						<tr class="row<%=(i%2+1) %>">
							<td><%=e.getUsertype() %></td>
							<td><%=e.getUsername() %></td>
							<td><%=e.getUserpwd() %></td>
							<td><a href="admdel.do?id=<%=e.getUsername() %>" onclick="return confirm('确定要删除<%=e.getUsername() %>吗？')">
							删除</a>&nbsp;<a href="admfind.do?id=<%=e.getUsername()%>">修改</a></td>
						</tr>
							<%}%>
        
        
    </tbody></table>
    <p><input type="button" class="button" value="添加用户" onclick="location='toAddUser.do'"/></p>
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
       			 