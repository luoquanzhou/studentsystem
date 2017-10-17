package user.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.AddUserException;
import exception.ApplicationException;
import info.Userinfo;
import mail.MailServiceImpl;
import stu.dao.StuDAO;
import tea.dao.TeainfoDAO;
import user.service.UserService;
import util.AuthCodeUtil;
import util.MailUtil;

@Controller
public class UserController {
	@Resource(name="ac")
	private AuthCodeUtil ac;
	@Resource(name="userService")
	private UserService userservice;
	@Resource(name="teainfoDAO")
	private TeainfoDAO teadao;
	@Resource(name="stuDAO")
	private StuDAO studao;
	@Resource(name="mailservice")
	private MailServiceImpl msi;
	@ExceptionHandler
	public String exception(Exception e,HttpServletRequest request){
		if(e instanceof ApplicationException){
			request.setAttribute("info_error", e.getMessage());
			return "login/login";
		}
		if(e instanceof AddUserException){
			System.out.println("AddUserException");
			request.setAttribute("info_error", e.getMessage());
			return "admin/addUser";
		}
		
		
		System.out.println("SystemException");
		return "error/error";
	}
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "login/login";
	}
	
	//登录验证
	@RequestMapping("/login/login.do")
	public String login(UserParam up,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		System.out.println(up.getUsername());
		String autocode=up.getAutocode();
	
		if(autocode==null){
			
			return selsetLogo(request, response, session, up);
			
		}else{
			String code=(String) session.getAttribute("code");
			if(!code.toLowerCase().equals(autocode.toLowerCase())){
				request.setAttribute("info_error", "验证码错误");
				return "login/login";
			}
			return selsetLogo(request, response, session, up);
		}
		
	}
	//获取验证码
	@RequestMapping("/login/autocode.do")
	public void code(HttpServletRequest request,HttpServletResponse response) throws IOException{
		BufferedImage image=ac.getAuthCode(5, request);
		response.setContentType("image/jpeg");
		OutputStream out=response.getOutputStream();
		javax.imageio.ImageIO.write(image, "jpeg", out);
		out.close();
	}
	
	//选择登录方式
		private String selsetLogo(HttpServletRequest request,HttpServletResponse response,HttpSession session,UserParam up){
			String username=up.getUsername();
			String pwd=up.getUserpwd();
			String usertype=up.getUsertype();
			Userinfo user=null;
				user=userservice.checkUser(username, pwd,usertype);
				
				session.setAttribute("userinfo", user);
				
				if(usertype.equals("0")){
					return "redirect:../admin/admlist.do";
				}else if(usertype.equals("1")){
					session.setAttribute("stu", studao.findstuid(username));
					return "redirect:../student/stulist.do";
				}else if(usertype.equals("2")){
					session.setAttribute("teacher", teadao.findTeaById(username));
					return "redirect:../teacher/tealist.do";
				}else{
					return "error/error";
				}
		}
		//登出
		@RequestMapping("/*/logout.do")
		public void Logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
			try {
				
				session.removeAttribute("userinfo");
				response.sendRedirect(request.getContextPath()+"/login/login.html");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		//登录后直接显示用户列表界面
		@RequestMapping("/admin/admlist.do")
		public String Admlist(HttpServletRequest request){
			List<Userinfo> list=userservice.findAllUser();
			
			request.setAttribute("list", list);
			return "admin/admininformation";
		}
		//转到添加用户信息界面
		@RequestMapping("/admin/toAddUser.do")
		public String toAddUser(){
			return "admin/addUser";
		}
		//添加一个用户
		@RequestMapping("/admin/admadd.do")
		public String addUser(UserInfoParam uip) throws Exception{
				userservice.addUser(uip);
			return "redirect:admlist.do";
		}
		//通过id查找对应用户的信息
		@RequestMapping("/admin/admfind.do")
		public String admFindById(HttpServletRequest request){
			String username=request.getParameter("id");
			Userinfo user=userservice.findByUserName(username);
			request.setAttribute("use", user);
			return "admin/updateUse";
		}
		//修改用用户信息
		@RequestMapping("/admin/admupdate.do")
		public String admUpdate(UserInfoParam uip){
			Userinfo user=new Userinfo();
			user.setUsername(uip.getUsername());
			user.setUserpwd(uip.getUserpwd());
			user.setUsertype(uip.getUsertype());
			userservice.updedaUser(user);
			return "redirect:admlist.do";
		}
		//跳转到修改密码的界面
		@RequestMapping("/*/tochangepwd.do")
		public String toChangePwd(HttpSession session){
			Userinfo user=(Userinfo) session.getAttribute("userinfo");
			if(user.getUsertype().equals("0")){
				return "admin/changepwd";
			}else if(user.getUsertype().equals("1")){
				return "student/changepwd";
			}else{
				return "teacher/changepwd";
			}
			
		}
		//修改密码
		@RequestMapping("/*/changepwd.do")
		public void changePwd(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
			System.out.println(111);
			String userpwd=request.getParameter("changepwd");
			Userinfo user=(Userinfo) request.getSession().getAttribute("userinfo");
			if(user.getUserpwd().equals(userpwd)){
				request.setAttribute("mesg", "修改失败！与之前密码一样");
				request.getRequestDispatcher("tochangepwd.do").forward(request, response);
				return;
			}
			user.setUserpwd(userpwd);
			userservice.updedaUser(user);
			request.setAttribute("mesg1", "密码修改成功");
			request.getSession().removeAttribute("userinfo");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('密码修改成功！请返回重新登录');");
			out.print("window.location.href='"+request.getContextPath()+"/login/login.html'");
			out.print("</script>");
			out.close();
		}
		
		@RequestMapping("/admin/admdel.do")
		public String admDel(HttpServletRequest request){
			String id=request.getParameter("id");
			userservice.admDelete(id);
			return "redirect:admlist.do";
		}
		
		@RequestMapping("/*/admcheckname.do")
		public void admCheckName(HttpServletRequest request,HttpServletResponse response){
			String name=request.getParameter("name");
			response.setContentType("text/html;charset=utf-8");
			try {
				PrintWriter out=response.getWriter();
				if(userservice.findByUserName(name)!=null){
					out.println(1);
				}else{
					out.println(2);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		@RequestMapping("/*/getregcode.do")
		public void getRegCode(HttpServletRequest request,HttpServletResponse response,HttpSession session){
			response.setContentType("text/html;charset=utf-8");
			try {
				PrintWriter out=response.getWriter();
				String email=request.getParameter("emailadd");
				String regcode=(String) session.getAttribute("regcode");
				if(regcode!=null){
					session.removeAttribute("regcode");
				}
				
				regcode=msi.sendAttachMail(email);
				if(regcode!=null){
					session.setAttribute("regcode", regcode);
					System.out.println(regcode);
					out.println(1);
				}else{
					out.println(2);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		@RequestMapping("/*/register.do")
		public void register(UserRegisterParam urp,HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException{
			response.setContentType("text/html;charset=utf-8");
			
			try {
				PrintWriter out=response.getWriter();
				userservice.addUsers(urp);
				out.println("注册成功，请返回登录<a href='/spring-exercise/login/login.html'>返回登录</a>");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("toerror.do");
			}	
		}
		@RequestMapping("/*/toerror.do")
		public String toError(){
			return "error/error";
		}
		
		@RequestMapping("/*/checkcode.do")
		public void checkCode(HttpServletRequest request,HttpServletResponse response,HttpSession session){
			response.setContentType("text/html;charset=utf-8");
			
			String regcode=(String) session.getAttribute("regcode");
			String reggistercode=request.getParameter("reggistercode");
			PrintWriter out=null;
			try {
				out=response.getWriter();
				if(regcode.toLowerCase().equals(reggistercode.toLowerCase())){
					out.println(1);
				}else{
					out.println(3);
				}
			} catch (IOException e) {
				e.printStackTrace();
				out.println(2);
			}
			
		}
		
}
