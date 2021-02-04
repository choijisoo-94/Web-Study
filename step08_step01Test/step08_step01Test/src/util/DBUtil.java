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
            Context initContext = new InitialContext();
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/myoracle");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public static void close(Connection con, Statement stmt, ResultSet rset) {
        try {
            if(rset != null) {
                rset.close(); 
                rset = null;
            }
            if(stmt != null) {
                stmt.close();
            }
            if(con != null) {
                con.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection con, Statement stmt) {
        try {
            if(stmt != null) {
                stmt.close();
            }
            if(con != null) {
                con.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

