package stu.dao;

import java.util.List;
import info.StuCourinfo;
public interface StuCourDAO {
	public void savecour(StuCourinfo courinfo);
	public void deletecour(String stuid);
	public void deletecourByTea(String teaid);
	public List<StuCourinfo> findStuID(String stuid);
	public List<StuCourinfo> findCourName(String stucouname);
	public List<StuCourinfo> findTeaName(String teaname);
	public List<StuCourinfo> findCourId(String courid);
	public List<StuCourinfo> findAllUser();
	public void delcourByStuId(String stuid);
	public void delcourByTeaId(String teaid);
	public void delcourStuCouId(String stucouid);
	public void updateCour(StuCourinfo sc);
	public void delStuCourByDoubleId(String stuid,String stucouid);

}
