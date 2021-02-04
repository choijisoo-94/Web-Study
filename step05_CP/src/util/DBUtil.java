/* 1. 모든 db 연동 로직에서 공통적으로 사용되는 코드들로만 구성된 재사용성 끝장판 클래스
 * 2. 주의사항
 * 	- enterprise 관점
 * 	- 구현하는 로직들은 24시간, 365일 웹서버 통해서 서비스 되는 로직으로 간주
 * 	- 간결성(유지보수, 수정 용이), 가독성이 좋고 확장이 용이한 코드로만 개발 및 관리 
 * 	- 재사용성 필수적인 고려
 *  - 자원 절약(서버와 디비 시스템등)
 */

package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	private static DataSource ds;
	
	static {
	
		try {
			//각 server들의 cp의 설정 방식은 다양 단 사용하고자 하는 java 코드는 표준화
			//표준화된 코드
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			
			//jdbc/playdata라는 이름으로 매핑된 자원 활용하겠다는 의미
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void close(Connection con, Statement stmt) {
		try {
			
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(con != null) {
				con.close();
				con = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if(con != null) {
				con.close();
				con = null;
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(rset != null) {
				rset.close();
				rset = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

