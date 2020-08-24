package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = DB.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("Select * ");
		sb.append("  from department ");
		
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sb.toString());
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
		
	}

}
