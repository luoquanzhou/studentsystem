package stu.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import exception.AddUserException;
import info.StuCourinfo;
import info.Stuinfo;
import info.TeaCourinfo;
import stu.dao.StuCourDAO;
import stu.dao.StuDAO;
import tea.dao.TeaCourDAO;
@Service("stuService")
public class StuServiceImpl implements StuService {
	@Resource(name="stucouDAO")
	private StuCourDAO stucoudao;
	@Resource(name="stuDAO")
	private StuDAO studao;
	@Resource(name="teaCourDAO")
	private TeaCourDAO teacoudao;
	public void addStu(Stuinfo stuinfo){
		try {
			studao.savestu(stuinfo);	
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddUserException("该用户名已经存在");
		}
	
		
	}
	public void deleteStu(String stuid) {
		
		
	}
	public Stuinfo findStuById(String stuid) {
		Stuinfo stu=studao.findstuid(stuid);
		return stu;
	}
	public void updateStu(Stuinfo stu) {
		studao.updatestu(stu);
	}
	public List<StuCourinfo> findStuCourById(String username) {
		return stucoudao.findStuID(username);
	}
	public List<TeaCourinfo> findAllCour() {
		List<TeaCourinfo> list=teacoudao.findTeaCourAll();
		return list;
	}

	public void addStuCour(String username, String couid) {
		TeaCourinfo tc=teacoudao.findTeaCourByCouId(couid);
		if(tc!=null){
			StuCourinfo sc=new StuCourinfo();
			sc.setStuid(username);
			sc.setStucouid(tc.getCouid());
			sc.setStucouname(tc.getCouname());
			sc.setStuscore(tc.getCouscore());
			sc.setStustatime(tc.getCoustatime());
			sc.setStustytime(tc.getCoustytime());
			sc.setTeaid(tc.getCouteaid());
			sc.setTeaname(tc.getCouteaname());
			stucoudao.savecour(sc);
		}
	}
	public Map<String, StuCourinfo> findCoursByStuId(String username) {
		Map<String,StuCourinfo> map=new HashMap<String, StuCourinfo>();
		List<StuCourinfo> list=stucoudao.findStuID(username);
		for(StuCourinfo sc:list){
			map.put(sc.getStucouid(), sc);
		}
		return map;
	}
	public void delStuCourById(String stuid, String stucouid) {
		stucoudao.delStuCourByDoubleId(stuid, stucouid);
	}
	

}
