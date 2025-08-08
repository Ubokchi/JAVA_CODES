package edu.java.jdbc07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import edu.java.jdbc03.ContactVO;

public class JDBCMain07 {
   // 1. DB 연동을 위한 상수
   public static final String URL = "jdbc:mysql://localhost:3306";
   public static final String USER = "root";
   public static final String PASSWORD = "020920";
   
   public static final String TABLE_NAME = "ex_contact";
   public static final String COL_CONTACT_ID = "contact_id";
   public static final String COL_NAME = "name";
   public static final String COL_PHONE = "phone";
   public static final String COL_EMAIL = "email";
   // SELECT * FROM EX_CONTACT WHERE CONTACT_ID = ?;
   public static final String SQL_SELECT_BY_CONTACT_ID =
         "SELECT * FROM " + TABLE_NAME + 
         " WHERE " + COL_CONTACT_ID + " = ?";

   public static void main(String[] args) {
      System.out.println("JDBC 7 - select");
      
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null; // select query 결과 저장할 클래스
      
      try {
         // 2. MySQL JDBC 드라이버를 메모리에 로드
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("드라이버 로드 성공");
         
         // 3. DB와 Connection(연결)을 맺음
         conn = DriverManager.getConnection(URL, USER, PASSWORD);
         System.out.println("DB 연결 성공");   
         
         // 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
         pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);
         
         Scanner sc = new Scanner(System.in);
         System.out.println("인덱스 입력>");
         int contactId = sc.nextInt();
         
         // 5. SQL 문장 작성
         pstmt.setInt(1, contactId);
         
         // 6. SQL 문장 실행(DB 서버로 SQL 전송)
         rs = pstmt.executeQuery(); 
         
         // 7. DB 서버가 보낸 결과 확인/처리
         // ResultSet.next() :
         // ResultSet에서 다음 행(row or record)이 있으면
         // true를 리턴하고, ResultSet이 가리키는 위치를 다음 위치로 변경
         
         
         if(rs.next()) { // 레코드가 존재할 때까지
            contactId = rs.getInt(1); // CONTACT_ID 컬럼
            String name = rs.getString(2); // NAME 컬럼
            String phone = rs.getString(3); // PHONE 컬럼
            String email = rs.getString(4); // EMAIL 컬럼
            
            ContactVO vo = new ContactVO(contactId, name, phone, email);
            System.out.println(vo);
         }
         
         sc.close();
         
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

   } // end main()

} // end JDBCMain07
