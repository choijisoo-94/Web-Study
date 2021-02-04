package emp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emp.model.domain.EmpDTO;
import util.DBUtil;

public class EmpDAO {

	public static ArrayList<EmpDTO> empAll() throws SQLException {
		
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		ArrayList<EmpDTO> datas = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();

			rset = stmt.executeQuery("select * from emp"); 
			
			datas = new ArrayList<>();
			while(rset.next()) {
				datas.add(new EmpDTO(rset.getInt("empno"), rset.getString("ename"), rset.getString("job")));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		
		return datas;
	}
	
}
