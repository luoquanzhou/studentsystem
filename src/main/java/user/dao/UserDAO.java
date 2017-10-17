package user.dao;

import java.util.List;

import info.Userinfo;

public interface UserDAO {
	public void save(Userinfo userinfo);
	public void delete(String username);
	public void updateuser(String username,String userpwd);
	public Userinfo findName(String username);
	public List<Userinfo> findAllUser();
}
