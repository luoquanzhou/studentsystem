package util;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;

@Service("dbu")
public class DBUtil {
	@Resource(name="ds")
	private  DataSource ds;
	
	
	public  Connection getConnection(){
		try {
		
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public  void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
}