package stu.service;


import java.util.List;
import java.util.Map;

import info.StuCourinfo;
import info.Stuinfo;
import info.TeaCourinfo;

public interface StuService {
	public void addStu(Stuinfo stuinfo);
	public void deleteStu(String stuid);
	public Stuinfo findStuById(String stuid);
	public void updateStu(Stuinfo stu);
	public List<StuCourinfo> findStuCourById(String username);
	public List<TeaCourinfo> findAllCour();
	public void addStuCour(String username, String couid);
	public Map<String, StuCourinfo> findCoursByStuId(String username);
	public void delStuCourById(String stuid, String stucouid);


}
