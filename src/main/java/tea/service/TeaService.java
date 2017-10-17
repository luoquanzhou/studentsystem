package tea.service;

import java.util.List;
import java.util.Map;

import info.TeaCourinfo;
import info.Teainfo;

public interface TeaService {

	public Teainfo findTeaByTeaId(String username);

	public void addTeaCour(TeaCourinfo tc);

	public void teaModify(Teainfo tea);

	public List<TeaCourinfo> findCourByTeaId(String username);

	public void delCourByCouId(String couid);

	public Integer findCouNum(String couid);
	
	public TeaCourinfo findTeaCourByCouId(String couid);

	public void updateCour(TeaCourinfo tc);

	public Map<String, TeaCourinfo> findTeaAllCour();
	
}
