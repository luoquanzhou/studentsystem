package util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
/**
 * MaBatis插入数据为null时转换
 * @author soft01
 *
 */
public class NullValueHander implements TypeHandler<String> {

	public String getResult(ResultSet arg0, String arg1) throws SQLException {
		
		return arg0.getString(arg1);
	}

	public String getResult(ResultSet arg0, int arg1) throws SQLException {
		
		return arg0.getString(arg1);
	}

	public String getResult(CallableStatement arg0, int arg1) throws SQLException {
		
		return arg0.getString(arg1);
	}

	public void setParameter(PreparedStatement pstmt, int index, String value, JdbcType jdbc) throws SQLException {
		if(value==null&&jdbc==JdbcType.VARCHAR){
			pstmt.setString(index, "");
		}else{
			pstmt.setString(index, value);
		}
		
	}

}
