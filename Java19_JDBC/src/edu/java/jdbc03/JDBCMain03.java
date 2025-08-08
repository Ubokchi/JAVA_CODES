package edu.java.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCMain03 {
	public static final String URL = "jdbc:mysql://localhost:3306";
	public static final String USER = "root";
	public static final String PASSWORD = "020920";
	
	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CONTACT_ID = "contact_id";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("JDBC 3 - select all");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select query 결과를 저장할 클래스
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			stmt = conn.createStatement();
			
			String sqlSelect = 
					"select * from " + TABLE_NAME + 
					" order by " + COL_CONTACT_ID;
			System.out.println(sqlSelect);
			
			rs = stmt.executeQuery(sqlSelect); // 쿼리 실행 결과 저장
			
			ArrayList<ContactVO> list = new ArrayList<ContactVO>();
			while (rs.next()) {	 // 레코드가 존재할 때까지
				int contactId = rs.getInt(COL_CONTACT_ID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				ContactVO vo = new ContactVO(contactId, name, phone, email);
				System.out.println(vo);
				list.add(vo);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
