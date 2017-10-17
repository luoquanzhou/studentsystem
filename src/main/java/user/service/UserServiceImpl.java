package user.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import exception.AddUserException;
import exception.ApplicationException;
import info.StuCourinfo;
import info.Stuinfo;
import info.TeaCourinfo;
import info.Teainfo;
import info.Userinfo;
import stu.dao.StuCourDAO;
import stu.dao.StuDAO;
import tea.dao.TeaCourDAO;
import tea.dao.TeainfoDAO;
import user.controller.UserInfoParam;
import user.controller.UserRegisterParam;
import user.dao.UserDAO;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDAO")
	private UserDAO userdao;
	@Resource(name="stuDAO")
	private StuDAO studao;
	@Resource(name="teainfoDAO")
	private TeainfoDAO teadao;
	@Resource(name="stucouDAO")
	private StuCourDAO stucouDAO;
	@Resource(name="teaCourDAO")
	private TeaCourDAO teacouDAO;
//	@Resource(name="user")
//	private Userinfo user;
	public Userinfo checkUser(String username, String pwd,String usertype) {
		
		Userinfo user=userdao.findName(username);
		if(user==null){
			throw new ApplicationException("用户名不存在");
		}
		if(!usertype.equals(user.getUsertype())){
			throw new ApplicationException("登录方式有误");
		}
		if(!pwd.equals(user.getUserpwd())){
			throw new ApplicationException("密码错误");
		}
		return user;
	}
	
	public List<Userinfo> findAllUser(){
		List<Userinfo> list=userdao.findAllUser();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getUsertype().equals("0")){
				list.remove(i);
			}
		}
		return list;
	}

	public void addUser(UserInfoParam uip){
		Userinfo user=new Userinfo();
		
		user.setUsername(uip.getUsername());
		user.setUserpwd(uip.getUserpwd());
		user.setUsertype(uip.getUsertype());
		if(uip.getUsername()==null||uip.getUsertype()==null||uip.getUserpwd()==null){
			throw new AddUserException("用户名、密码或类型不能为空");
		}
		
		if(uip.getUsertype().equals("1")){
			Stuinfo stu=new Stuinfo();
			stu.setStuid(uip.getUsername());
			try {
				studao.savestu(stu);
			} catch (Exception e) {
				throw new AddUserException("该用户名已经存在");
			}
			
				
		}
		if(uip.getUsertype().equals("2")){
			Teainfo tea=new Teainfo();
			tea.setTeaid(uip.getUsername());
			try {
				teadao.teasave(tea);
			} catch (Exception e) {
				throw new AddUserException("该用户名已经存在");
			}
			
		}
		userdao.save(user);
		
	}

	public Userinfo findByUserName(String username) {
		Userinfo user=userdao.findName(username);
		return user;
	}

	public void updedaUser(Userinfo user) {
		userdao.updateuser(user.getUsername(), user.getUserpwd());
		
	}

	public void admDelete(String id) {
		Userinfo user=userdao.findName(id);
		if(user.getUsertype().equals("1")){
			List<StuCourinfo> list1=stucouDAO.findStuID(id);
			if(list1!=null){
				stucouDAO.delcourByStuId(id);
			}
			if(studao.findstuid(id)!=null){
				studao.deletestu(id);
			}
			userdao.delete(id);
		}
		if(user.getUsertype().equals("2")){
			List<TeaCourinfo> list1=teacouDAO.findTeaCourByTeaId(id);
			for(TeaCourinfo tc:list1){
				List<StuCourinfo> list2=stucouDAO.findCourId(tc.getCouid());
				if(list2!=null){
					stucouDAO.delcourByTeaId(id);
				}
			}
			if(list1!=null){
				teacouDAO.deleteTeaCourByTeaID(id);
			}
			if(teadao.findTeaById(id)!=null){
				teadao.findTeaById(id);
			}
			userdao.delete(id);
		}
	}


	public void addUsers(UserRegisterParam urp) {
		Userinfo user=new Userinfo();
		user.setUsername(urp.getUserid());
		user.setUserpwd(urp.getUserpwd());
		user.setUsertype("1");
		userdao.save(user);
		Stuinfo stu=new Stuinfo();
		stu.setStuid(urp.getUserid());
		stu.setStuemail(urp.getUseremail());
		studao.savestu(stu);
	}
}
