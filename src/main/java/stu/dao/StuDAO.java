package stu.dao;

import java.util.List;

import info.Stuinfo;

public interface StuDAO {
	public void savestu(Stuinfo stuinfo);
	public void deletestu(String stuid);
	public Stuinfo findstuid(String stuid);
	public Stuinfo findstuname(String stuname);
	public List<Stuinfo> findstuall();
	public void updatestu(Stuinfo stuinfo);
}
