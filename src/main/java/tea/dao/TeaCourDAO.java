package tea.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import info.TeaCourinfo;
@Repository("teaCourDAO")
public interface TeaCourDAO {
	public void taeacousave(TeaCourinfo teacou);
	public TeaCourinfo findTeaCourByCouId(String couid);
	public TeaCourinfo findTeaCourByCouName(String couname);
	public List<TeaCourinfo> findTeaCourByTeaId(String teaid);
	public List<TeaCourinfo> findTeaCourByTeaName(String teaname);
	public List<TeaCourinfo> findTeaCourAll();
	public void deleteTeaCourByCouID(String couid);
	public void deleteTeaCourByTeaID(String teaid);
	public void updateTeaCour(TeaCourinfo teacour);
}
