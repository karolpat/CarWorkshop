package pl.carWorkshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbUtil {
	
	
//	private static DataSource ds;
//	@SuppressWarnings("unused")
//	public static Connection getConn () throws SQLException{
//		
//		return getInstance().getConnection();
//	}
//	
//	private static DataSource getInstance() {
//		
//		if (ds==null) {
//			try {
//				Context ctx = new InitialContext();
//				ds= (DataSource)ctx.lookup("java:comp/env/crm");
//			}catch (NamingException e) {
//				e.printStackTrace();
//			}
//		}
//		return ds;
//	}
	

	private static String DB_URL = "jdbc:mysql://localhost:3306/crm?useSSL=false";
	private static String DB_USRNM = "root";
	private static String DB_PSSWRD = "coderslab";
	
	public static Connection getConn () throws SQLException {
		

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch (Exception e) {
			
		}
		
		return DriverManager.getConnection(DB_URL, DB_USRNM, DB_PSSWRD);
		
	}
}
