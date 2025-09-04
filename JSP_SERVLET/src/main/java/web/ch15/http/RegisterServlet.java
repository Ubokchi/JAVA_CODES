package web.ch15.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/ch15/member/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL =
		    "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&characterEncoding=UTF-8";
	public static final String USER = "root";
	public static final String PASSWORD = "020920";

	public RegisterServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// register.jsp의 form method="post"이므로 doPost() 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form에서 보낸 Form Data는 request 객체에 저장되어 있음
		// request parameter로 데이터 참조


		// getParameter의 name == form 태그 input name과 동일
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		// DB 연결 생략
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2. MySQL JDBC 드라이버를 메모리에 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");  
			
			System.out.println("userid = " + userid);
			System.out.println("password = " + password);
			System.out.println("email = " + email);

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


}






