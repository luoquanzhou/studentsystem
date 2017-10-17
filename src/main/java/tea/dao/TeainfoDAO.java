package tea.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import info.Teainfo;
@Repository("teainfoDAO")
public interface TeainfoDAO {
	public void teasave(Teainfo tea);
	public void teadelete(String teaid);
	public Teainfo findTeaById(String teaid);
	public Teainfo findTeaByName(String teaid);
	public List<Teainfo> findTeaAll();
	public void teaUpdate(Teainfo tea);
}
