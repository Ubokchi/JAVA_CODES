package edu.java.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// * DB 연결을 위한 환경 설정
// 1. MYSQL 드라이버 다운로드 및 설정
// - mysql-connecter-j-8.0.xx.jar 다운로드
// - 프로젝트 lib 폴더에 추가 -> Build Path jar 파일 추가
// 2. 테이블 생성
// 3. DB 연결 코드 작성
// 4. 자바 코드 수행

public class JDBCMain01 {
	// 1. DB 연동을 위한 상수
	public static final String URL = "jdbc:mysql://localhost:3306";
	public static final String USER = "root";
	public static final String PASSWORD = "020920";
	
	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CONTACT_ID = "contact_id";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";
	
	public static void main(String[] args) {
		System.out.println("JDBC 1 - insert");
		
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
			String sqlInsert =
					"insert into " + TABLE_NAME + 
					" (" + COL_NAME + ", " + COL_PHONE + ", " + COL_EMAIL + ") "
					+ "VALUES ('U', '010-1111-1111', 'test@test.com')";
			System.out.println(sqlInsert);
			
			// 6. SQL 실행
			int result = stmt.executeUpdate(sqlInsert);
			
			// 7. 결과 처리 
			System.out.println(result + "행이 삽입되었습니다.");
			
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
