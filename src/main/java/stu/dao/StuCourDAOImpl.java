package stu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import info.StuCourinfo;

@Repository("stucouDAO")
public class StuCourDAOImpl implements StuCourDAO {
	@Resource(name="jt")
	private JdbcTemplate jt;
	public void savecour(StuCourinfo c) {
		String sql="insert into courinform_lqz values(?,?,?,?,?,?,?,?)";

		Object[] args={c.getStuid(),c.getStucouid(),c.getStucouname(),c.getStustytime(),c.getStuscore(),
				c.getStustatime(),c.getTeaname(),c.getTeaid()};
		jt.update(sql, args);
	}

	public void deletecour(String stuid) {
		String sql="delete from courinform_lqz where stuid=?";
		Object[] args={stuid};
		jt.update(sql, args);
	}

	public void deletecourByTea(String teaid) {
		String sql="delete from courinform_lqz where teaid=?";
		Object[] args={teaid};
		jt.update(sql, args);
		
	}

	public List<StuCourinfo> findStuID(String stuid) {
		String sql="select *from courinform_lqz where stuid=?";
		Object[] args={stuid};
		List<StuCourinfo> list=jt.query(sql, args, new StuCourRowMapping());
		return list;
	}

	public List<StuCourinfo> findCourName(String stucouname) {
		String sql="select *from courinform_lqz where stucouname=?";
		Object[] args={stucouname};
		List<StuCourinfo> list=jt.query(sql, args, new StuCourRowMapping());
		return list;
	}

	public List<StuCourinfo> findTeaName(String teaname) {
		String sql="select *from courinform_lqz where teaname=?";
		Object[] args={teaname};
		List<StuCourinfo> list=jt.query(sql, args, new StuCourRowMapping());
		return list;
	}
	
	public List<StuCourinfo> findCourId(String stucouid) {
		String sql="select *from courinform_lqz where stucouid=?";
		Object[] args={stucouid};
		List<StuCourinfo> list=jt.query(sql, args, new StuCourRowMapping());
		return list;
	}

	public List<StuCourinfo> findAllUser() {
		String sql="select * from courinform_lqz";
		List<StuCourinfo> list=jt.query(sql, new StuCourRowMapping());
		return list;
	}
	class StuCourRowMapping implements RowMapper<StuCourinfo>{
		public StuCourinfo mapRow(ResultSet rs, int arg1) throws SQLException {
			StuCourinfo sc=new StuCourinfo();
			sc.setStuid(rs.getString("stuid"));
			sc.setStucouid(rs.getString("stucouid"));
			sc.setStucouname(rs.getString("stucouname"));
			sc.setStustytime(rs.getString("stustytime"));
			sc.setStuscore(rs.getString("stuscore"));
			sc.setStustatime(rs.getString("stustatime"));
			sc.setTeaname(rs.getString("teaname"));
			sc.setTeaid(rs.getString("teaid"));
			return sc;
		}
	}

	public void delcourByStuId(String stuid) {
		String sql="delete from courinform_lqz where stuid=?";
		Object[] args={stuid};
		jt.update(sql, args);
	}
	public void delcourByTeaId(String teaid) {
		String sql="delete from courinform_lqz where teaid=?";
		Object[] args={teaid};
		jt.update(sql, args);
	}
	public void delcourStuCouId(String stucouid) {
		String sql="delete from courinform_lqz where stucouid=?";
		Object[] args={stucouid};
		jt.update(sql, args);
	}

//	stuid,stucouid,stucouname,stustytime,stuscore,stustatime,teaname,teaid;
	public void updateCour(StuCourinfo sc) {
		String sql="update courinform_lqz set stucouname=?,stustytime=?,stuscore=?,stustatime=? where stucouid=?";
		Object[] args={sc.getStucouname(),sc.getStustytime(),sc.getStuscore(),sc.getStustatime(),sc.getStucouid()};
		jt.update(sql, args);
	}
	
	public void delStuCourByDoubleId(String stuid,String stucouid){
		String sql="delete from courinform_lqz where stuid=? and stucouid=?";
		Object[] args={stuid,stucouid};
		jt.update(sql, args);
	}




}
