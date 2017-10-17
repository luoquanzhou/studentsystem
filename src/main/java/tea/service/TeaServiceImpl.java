package tea.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import exception.ApplicationException;
import info.StuCourinfo;
import info.TeaCourinfo;
import info.Teainfo;
import stu.dao.StuCourDAO;
import tea.dao.TeaCourDAO;
import tea.dao.TeainfoDAO;

@Service("teaService")
public class TeaServiceImpl implements TeaService {
	@Resource(name="teaCourDAO")
	private TeaCourDAO teacoudao;
	@Resource(name="teainfoDAO")
	private TeainfoDAO teadao;
	@Resource(name="stucouDAO")
	private StuCourDAO stucourdao;
	public Teainfo findTeaByTeaId(String username) {
		return teadao.findTeaById(username);
	}

	public void addTeaCour(TeaCourinfo tc) {
		TeaCourinfo tcs=teacoudao.findTeaCourByCouId(tc.getCouid());
		if(tcs!=null){
			throw new ApplicationException("此课程ID已经存在");
		}else{
			teacoudao.taeacousave(tc);
		}
	}

	public void teaModify(Teainfo tea) {
		teadao.teaUpdate(tea);
	}

	public List<TeaCourinfo> findCourByTeaId(String username) {
		return teacoudao.findTeaCourByTeaId(username);
	}

	public void delCourByCouId(String couid) {
		List<StuCourinfo> list=stucourdao.findCourId(couid);
		if(list!=null){
			
			stucourdao.delcourStuCouId(couid);
		
		}
		teacoudao.deleteTeaCourByCouID(couid);
	}

	public Integer findCouNum(String couid) {
		List<StuCourinfo> list=stucourdao.findCourId(couid);
		return list.size();
	}

	public TeaCourinfo findTeaCourByCouId(String couid) {
		
		return teacoudao.findTeaCourByCouId(couid);
	}

	public void updateCour(TeaCourinfo tc) {
			List<StuCourinfo> list=stucourdao.findCourId(tc.getCouid());
			if(list!=null){
				for(StuCourinfo sc:list){
					sc.setStucouname(tc.getCouname());
					sc.setStuscore(tc.getCouscore());
					sc.setStustatime(tc.getCoustatime());
					sc.setStustytime(tc.getCoustytime());
					stucourdao.updateCour(sc);
				}
			}
			teacoudao.updateTeaCour(tc);	
	}

	public Map<String, TeaCourinfo> findTeaAllCour() {
		List<TeaCourinfo> list=teacoudao.findTeaCourAll();
		Map<String, TeaCourinfo> map=new HashMap<String, TeaCourinfo>();
		for(TeaCourinfo tc:list){
			map.put(tc.getCouid(), tc);
		}
		return map;
	}
	
}
