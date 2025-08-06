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
	public static final String URL = "jdbc:mysql://localhost:3306/example";
	public static final String USER = "root";
	public static final String PASSWORD = "020920";
	
	public static void main(String[] args) {
		System.out.println("JDBC 1 - insert");
		
		Connection conn = null;
		Statement statement = null;
		
		try {
			// 2. JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
