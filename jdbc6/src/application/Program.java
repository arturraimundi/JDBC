package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.Dbexception;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			//int x = 1;
			//if(x == 1) {
			//	throw new SQLException("Fake error");
			//}
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			conn.commit();
			System.out.println("Rows 1:" + rows1);
			System.out.println("Rows 2:" + rows2);
			
			
			
			
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new Dbexception("Transaction rolled back! Cause by: "+ e.getMessage());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new Dbexception("Error trying to rollback! Cause by: " + e1.getMessage()); 
			}
			
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}