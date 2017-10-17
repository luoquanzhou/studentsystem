package user.service;

import java.util.List;
import info.Userinfo;
import user.controller.UserInfoParam;
import user.controller.UserRegisterParam;
public interface UserService {
	public Userinfo checkUser(String username,String pwd,String usertype);
	public List<Userinfo> findAllUser();
	public void addUser(UserInfoParam uip);
	public void addUsers(UserRegisterParam urp);
	public Userinfo findByUserName(String username);
	public void updedaUser(Userinfo user);
	public void admDelete(String id);
}
