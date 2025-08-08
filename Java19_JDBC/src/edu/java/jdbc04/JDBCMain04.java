package edu.java.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.java.jdbc03.ContactVO;

public class JDBCMain04 {
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
		System.out.println("JDBC 4 - select by index");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // select query 결과를 저장할 클래스
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			stmt = conn.createStatement();
			
			String sqlSelectById = 
					"select * from " + TABLE_NAME + 
					" where " + COL_CONTACT_ID + " = 1";
			System.out.println(sqlSelectById);
			
			rs = stmt.executeQuery(sqlSelectById); // 쿼리 실행 결과 저장
			
			if (rs.next()) {
				int contactId = rs.getInt(COL_CONTACT_ID);
				String name = rs.getString(COL_NAME);
				String phone = rs.getString(COL_PHONE);
				String email = rs.getString(COL_EMAIL);
				
				ContactVO vo = new ContactVO(contactId, name, phone, email);
				System.out.println(vo);
			} else {
				System.out.println("해당 ID의 연락처가 없습니다.");
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
