package stu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import info.Stuinfo;
@Repository("stuDAO")
public class StuDAOImpl implements StuDAO {
	@Resource(name="jt")
	private JdbcTemplate jt;
	//保存学生信息
	public void savestu(Stuinfo stuinfo) {
		String sql="insert into studentinform_lqz (stuid, stuname, stusex, stuage, stuadd, stutel, stuqq, stuemail, stuclass, stuprocour) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		Object[] args={stuinfo.getStuid(),stuinfo.getStuname(),stuinfo.getStusex(),
				stuinfo.getStuage(),stuinfo.getStuadd(),stuinfo.getStutel(),stuinfo.getStuqq(),
				stuinfo.getStuemail(),stuinfo.getStuclass(),stuinfo.getStuprocour()};
		jt.update(sql, args);
	}
	//删出一个学生信息
	public void deletestu(String stuid) {
		String sql="delete from studentinform_lqz where stuid=?";
		Object[] args={stuid};
		jt.update(sql, args);
	}
	//通过学生id查询学生信息
	public Stuinfo findstuid(String stuid) {
		String sql="select * from studentinform_lqz where stuid=?";
		Object[] args={stuid};
		Stuinfo stu=jt.queryForObject(sql,args,new StuRowMapping());
		return stu;
	}
	//通过学生姓名查找学生信息
	public Stuinfo findstuname(String stuname) {
		String sql="select * from studentinform_lqz where stuname=?";
		Object[] args={stuname};
		Stuinfo stu=jt.queryForObject(sql,args,new StuRowMapping());
		return stu;
	}
	//查询所有学生信息
	public List<Stuinfo> findstuall() {
		String sql="select * from studentinform_lqz";
		List<Stuinfo> list=jt.query(sql, new StuRowMapping());
		return list;
	}
	class StuRowMapping implements RowMapper<Stuinfo>{
//stuid, stuname, stusex, stuage, stuadd, stutel, stuqq, stuemail, stuclass, stuprocour, 
		public Stuinfo mapRow(ResultSet rs, int arg1) throws SQLException {
			Stuinfo stu=new Stuinfo();
			stu.setStuid(rs.getString("stuid"));
			stu.setStuname(rs.getString("stuname"));
			stu.setStusex(rs.getString("stusex"));
			stu.setStuage(rs.getString("stuage"));
			stu.setStuadd(rs.getString("stuadd"));
			stu.setStutel(rs.getString("stutel"));
			stu.setStuqq(rs.getString("stuqq"));
			stu.setStuemail(rs.getString("stuemail"));
			stu.setStuclass(rs.getString("stuclass"));
			stu.setStuprocour(rs.getString("stuprocour"));
			return stu;
		}
	}
	//更新学生信息
	public void updatestu(Stuinfo s) {
		String sql="update studentinform_lqz set stuname=?,stusex=?,"
				+ "stuage=?, stuadd=?, stutel=?, stuqq=?, stuemail=?, "
				+ "stuclass=?, stuprocour=? where stuid=?";
		Object[] args={s.getStuname(),s.getStusex(),s.getStuage(),s.getStuadd(),s.getStutel(),s.getStuqq(),s.getStuemail(),s.getStuclass(),s.getStuprocour(),s.getStuid()};
		jt.update(sql, args);
	}

}
