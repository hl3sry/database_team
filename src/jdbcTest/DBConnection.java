package jdbcTest;

import java.sql.*;

public class DBConnection {
	public static Connection dbConn;
    
    public static Connection getConnection()
    {
        Connection conn = null;
        try {
            String url = "jdbc:oracle:thin:@202.20.119.117:1521:orcl";
            String user = "dbprog0103"; 
            String pw = "dbprog0103";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
	}	
}