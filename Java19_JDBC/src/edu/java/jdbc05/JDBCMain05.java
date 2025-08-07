package edu.java.jdbc05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMain05 {

	// 1. DB 연동을 위한 상수
	public static final String URL = "jdbc:mysql://localhost:3306/example";
	public static final String USER = "root";
	public static final String PASSWORD = "020920";

	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CONTACT_ID = "contact_id";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";

	// 연락처 등록
	// insert into ex_contact (name, phone, email)
	// values (?, ?, ?)

	public static final String SQL_INSERT =
			"insert into ex_contact (name, phone, email)"
					+ " values (?, ?, ?)";

	public static void main(String[] args) {
		System.out.println("JDBC 5 - 입력받은 데이터를 쿼리에 적용하여 insert");

		Connection conn = null;
		PreparedStatement pstmt = null;
		// PreparedStatement: 매개변수를 갖고 있는 SQL문장을 처리하기 위한 클래스
		//					 Statement와 상속관계

		try {
			// 2. JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			// 3. DB 연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 4. Statement 객체 생성
			pstmt = conn.prepareStatement(SQL_INSERT);

			// 5. SQL 문장 완성 - SQL INSERT 쿼리의 ?를 채워주는 코드
			Scanner sc = new Scanner(System.in);

			System.out.println("이름>");
			String name = sc.next();

			System.out.println("전화번호>");
			String phone = sc.next();

			System.out.println("이메일>");
			String email = sc.next();

			sc.close();
			
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			// 중요) SQL 쿼리의 ? 순서와 parameterIndex의 값은 동일하게 지정
			// 예시) ? 가 첫 번째이면 parameterIndex = 1
			//		첫 번째는 name 칼럼이므로 setString() 사용
			
			// setInt() : DB int 타입
			// setString() : DB varchar 타입
			// setDate() : DB date 타입
			// setTimestamp() : DB timestamp 타입

			// 6. SQL 실행
			int result = pstmt.executeUpdate();
			
			// 7. 결과 처리 
			System.out.println(result + "행이 삽입되었습니다.");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {
			// 8. 리소스 해제
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
