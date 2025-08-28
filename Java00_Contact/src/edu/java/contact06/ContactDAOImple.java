package edu.java.contact06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactDAOImple implements ContactDAO, ContactTableInfo {
    
    // 싱글톤 디자인 패턴 적용
    private static ContactDAOImple instance = null;
    
    private ContactDAOImple() {}
    
    public static ContactDAOImple getInstance() {
        if (instance == null) {
            instance = new ContactDAOImple();
        }
        return instance;
    }
    
    @Override
    public int insert(ContactVO vo) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로드 성공");
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("DB 연결 성공");

            pstmt = conn.prepareStatement(SQL_INSERT);

            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getPhone());
            pstmt.setString(3, vo.getEmail());

            result = pstmt.executeUpdate();

            System.out.println(result + "행이 삽입되었습니다.");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(conn, pstmt);
        }
        return result;
    }

    @Override
    public ArrayList<ContactVO> select() {
        ArrayList<ContactVO> list = new ArrayList<ContactVO>();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로드 성공");
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("DB 연결 성공");    
            
            pstmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = pstmt.executeQuery(); 

            while(rs.next()) {
                int contactId = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                
                ContactVO vo = new ContactVO(contactId, name, phone, email);
                System.out.println(vo);
                list.add(vo);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
        	DBConnManager.close(conn, pstmt, rs);
        }
        return list;
    }

    @Override
    public ContactVO select(int contactId) {
        ContactVO vo = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);
            pstmt.setInt(1, contactId);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String email = rs.getString(4);
                
                vo = new ContactVO(id, name, phone, email);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(conn, pstmt, rs);
        }
        return vo;
    }

    // ✅ 연락처 정보 수정
    @Override
    public int update(int contactId, ContactVO vo) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            pstmt = conn.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getPhone());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, contactId);
            
            result = pstmt.executeUpdate();
            System.out.println(result + "행이 수정되었습니다.");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(conn, pstmt);
        }
        return result;
    }

    // ✅ 연락처 정보 삭제
    @Override
    public int delete(int contactId) {
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, contactId);
            
            result = pstmt.executeUpdate();
            System.out.println(result + "행이 삭제되었습니다.");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnManager.close(conn, pstmt);
        }
        return result;
    }
}
