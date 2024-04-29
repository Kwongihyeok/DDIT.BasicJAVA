package kr.or.ddit.study06.sec05.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) {
		DBMain obj = new DBMain();
		obj.process();
	}	
	public void process() {
		Connection conn = null; //DB 접속
		Statement stmt = null;  //Query 날림
		ResultSet rs = null;    //Query 응답
		
		conn = DBconn.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "Select * from member";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("mem_id");
				String name = rs.getString("mem_name");
				String job = rs.getString("mem_job");
				String mail = rs.getString("mem_mail");
				String like = rs.getString("mem_like");
				if (!job.equals("주부")) continue;
				System.out.println(id+"\t"+name+"\t"+job +"\t" + mail + "\t"+ like);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
