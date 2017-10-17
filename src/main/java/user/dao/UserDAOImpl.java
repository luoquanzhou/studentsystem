package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;


import info.Userinfo;
import util.DBUtil;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Resource(name="dbu")
	private DBUtil dbutil;
	public void save(Userinfo userinfo) {
		Connection conn=null;
		try {
			conn=dbutil.getConnection();
			String sql="insert into userinform_lqz (usertype,username,userpwd) values(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userinfo.getUsertype());
			ps.setString(2, userinfo.getUsername());
			ps.setString(3, userinfo.getUserpwd());
			ps.executeUpdate();
			
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dbutil.closeConnection(conn);
		}
	}

	public void delete(String username) {
		Connection conn=null;
		try {
			conn=dbutil.getConnection();
			String sql="delete from userinform_lqz where username=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.executeUpdate();
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dbutil.closeConnection(conn);
		}

	}

	public void updateuser(String username, String userpwd) {
		Connection conn=null;
		try {
			conn=dbutil.getConnection();
			String sql="update userinform_lqz set userpwd=? where username=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userpwd);
			ps.setString(2, username);
			ps.executeUpdate();
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dbutil.closeConnection(conn);
		}

	}

	public Userinfo findName(String username) {
		Connection conn=null;
		try {
			conn=dbutil.getConnection();
			String sql="select * from userinform_lqz where username=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String usertype=rs.getString("usertype");
				String userpwd=rs.getString("userpwd");
				return new Userinfo(username, usertype, userpwd);
			}else{
				return null;
			}
		}  catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dbutil.closeConnection(conn);
		}
	}

	public List<Userinfo> findAllUser() {
		Connection conn=null;
		try {
			conn=dbutil.getConnection();
			List<Userinfo> list=new ArrayList<Userinfo>();
			String sql="select * from userinform_lqz ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String usertype=rs.getString("usertype");
				String username=rs.getString("username");
				String userpwd=rs.getString("userpwd");
				list.add(new Userinfo(username, usertype, userpwd));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dbutil.closeConnection(conn);
		}
	}

}
