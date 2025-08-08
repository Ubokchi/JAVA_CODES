package edu.java.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMain02 {
	
	public static final String URL = "jdbc:mysql://localhost:3306";
	public static final String USER = "root";
	public static final String PASSWORD = "020920";
	
	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CONTACT_ID = "contact_id";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";

	public static void main(String[] args) {
		System.out.println("JDBC 2 - update");
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 2. JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			// 3. DB 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 5. SQL 문장 생성
			String sqlUpdate = 
					"update " + TABLE_NAME + " set " + 
					COL_NAME + " = '둘리', " + 
					COL_PHONE + " = '010-2222-2222', " + 
					COL_EMAIL + " = 'dooli@hoi.com' " + 
					"where " + COL_CONTACT_ID + " = 1";
			System.out.println(sqlUpdate);
			
			// 6. SQL 실행
			int result = stmt.executeUpdate(sqlUpdate);
			// executeUpdate() : INSERT, UPDATE, DELETE 실행
			
			// 7. 결과 처리 
			System.out.println(result + "행이 수정되었습니다.");
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			// 8. 리소스 해제
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
