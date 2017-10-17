package tea.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.ApplicationException;
import info.TeaCourinfo;
import info.Teainfo;
import info.Userinfo;
import tea.service.TeaService;

@Controller("teaController")
@RequestMapping("/teacher")
public class TeaController {
	@Resource(name="teaService")
	private TeaService teaservice;
	
	@ExceptionHandler
	public String exception1(Exception e,HttpServletRequest request){
		if(e instanceof ApplicationException){
			request.setAttribute("info_error", e.getMessage());
			return "teacher/teaaddcou";
		}
		return "error/error";
	}
	@RequestMapping("/tealist.do")
	public String teaList(){
		return "teacher/teainformation";
	}
	
	@RequestMapping("/teaload.do")
	public String teaLoad(){
		return "teacher/teainfo_modify";	
	}
	@RequestMapping("/toteaaddcou.do")
	public String toTeaAddCou(){
		return "teacher/teaaddcou";
	}
	@RequestMapping("teaaddcou.do")
	public String teaAddCou(HttpServletRequest request,HttpSession session) throws SQLException{
		TeaCourinfo tc=new TeaCourinfo();
		tc.setCouid(request.getParameter("couid"));
		tc.setCouname(request.getParameter("couname"));
		tc.setCouscore(request.getParameter("couscore"));
		tc.setCoustatime(request.getParameter("coustatime"));
		tc.setCoustytime(request.getParameter("coustytime"));
		Teainfo tea=(Teainfo) session.getAttribute("teacher");
		tc.setCouteaid(tea.getTeaid());
		tc.setCouteaname(tea.getTeaname());
		
		teaservice.addTeaCour(tc);
		
		return "redirect:teacoulist.do";
	}
	
	@RequestMapping("/teamodify.do")
	public String teaModify(HttpSession session,Teainfo tea){
		teaservice.teaModify(tea);
		session.setAttribute("teacher", tea);
		return "teacher/teainformation";
	}
	
	@RequestMapping("/teacoulist.do")
	public String teaCouList(HttpServletRequest request,HttpSession session){
		Userinfo user=(Userinfo) session.getAttribute("userinfo");
		List<TeaCourinfo> list=teaservice.findCourByTeaId(user.getUsername());
		Map<TeaCourinfo, Integer> map=new HashMap<TeaCourinfo, Integer>();
		for(TeaCourinfo tc:list){
			Integer num=teaservice.findCouNum(tc.getCouid());
			map.put(tc, num);
		}
		request.setAttribute("map", map);
		return "teacher/teacourlist";
	}
	@RequestMapping("/teadelcourse.do")
	public String teaDelCourse(HttpServletRequest request){
		String couid=request.getParameter("teacouid");
		teaservice.delCourByCouId(couid);
		return "teacher/teacourlist";
	}
	
	@RequestMapping("/teacoufind.do")
	public String teaCouFind(HttpServletRequest request){
		String couid=request.getParameter("id");
		TeaCourinfo cour=teaservice.findTeaCourByCouId(couid);
		request.setAttribute("cour", cour);
		return "teacher/teacour_modify";
	}
	
	@RequestMapping("/teacourmodify.do")
	public String teaCourModify(HttpServletRequest request,HttpSession session){
		TeaCourinfo tc=new TeaCourinfo();
		tc.setCouid(request.getParameter("couid"));
		tc.setCouname(request.getParameter("couname"));
		tc.setCouscore(request.getParameter("couscore"));
		tc.setCoustatime(request.getParameter("coustatime"));
		tc.setCoustytime(request.getParameter("coustytime"));
		Teainfo tea=(Teainfo) session.getAttribute("teacher");
		tc.setCouteaid(tea.getTeaid());
		tc.setCouteaname(tea.getTeaname());
		teaservice.updateCour(tc);
		return "redirect:teacoulist.do";
	}
	
	@RequestMapping("/checkcourid.do")
	public void checkCourid(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out=response.getWriter();
			String couid=request.getParameter("couid");

			Map<String, TeaCourinfo> list=teaservice.findTeaAllCour();
			if(list.containsKey(couid)){
				out.println("此课程ID已存在");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
