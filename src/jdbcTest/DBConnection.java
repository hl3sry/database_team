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
            
            System.out.println("Database�� ����Ǿ����ϴ�.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB ���ӽ��� : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
	}	
}