package jxnu.chisha.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

    static ComboPooledDataSource cpds = new ComboPooledDataSource();
    private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    // 与事务有关.
    public static Connection getConnectionByTransaction() throws SQLException {
        Connection con = tl.get();
        if (con == null) {
            con = cpds.getConnection();
            tl.set(con);
        }
        return con;
    }

    //关闭操作
    public static void closeConnection(Connection con) throws SQLException {
        if(con!=null){
            con.close();
        }
    }
    public static void closeStatement(Statement st) throws SQLException {
        if(st!=null){
            st.close();
        }
    }
    public static void closeResultSet(ResultSet rs) throws SQLException {
        if(rs!=null){
            rs.close();
        }
    }
}
