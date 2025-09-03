package bokchi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImple implements MemberDAO, DBConnection{
	private static MemberDAOImple instance = null;
	
	private MemberDAOImple() {}
	
	public static MemberDAOImple getInstance() {
		if(instance == null) {
			instance = new MemberDAOImple();
		}
		return instance;
	}

	@Override
	public int insert(MemberVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getEmailAgree());
			pstmt.setString(5, vo.getInterestJoin());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getIntroduce());
			
			result = pstmt.executeUpdate();
			System.out.println(result + "행 등록");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	@Override
	public MemberVO selectByUserid(String userid) {
        MemberVO vo = null;

        final String SQL_SELECT_ONE =
            "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_USERID + " = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT_ONE)) {

                pstmt.setString(1, userid);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        vo = new MemberVO();
                        vo.setUserid(rs.getString(COL_USERID));
                        vo.setPassword(rs.getString(COL_PASSWORD));
                        vo.setEmail(rs.getString(COL_EMAIL));
                        vo.setEmailAgree(rs.getString(COL_EMAIL_AGREE));
                        String interestJoined = rs.getString(COL_INTEREST);
                        if (interestJoined != null && !interestJoined.isEmpty()) {
                            vo.setInterest(interestJoined.split("\\s*,\\s*"));
                        } else {
                            vo.setInterest(null);
                        }
                        vo.setPhone(rs.getString(COL_PHONE));
                        vo.setIntroduce(rs.getString(COL_INTRODUCE));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vo;
    }
	
	@Override
    public List<MemberVO> selectAll() {
        List<MemberVO> list = new ArrayList<>();

        final String SQL_SELECT_ALL =
            "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_USERID;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT_ALL);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    MemberVO vo = new MemberVO();
                    vo.setUserid(rs.getString(COL_USERID));
                    vo.setPassword(rs.getString(COL_PASSWORD));
                    vo.setEmail(rs.getString(COL_EMAIL));
                    vo.setEmailAgree(rs.getString(COL_EMAIL_AGREE));
                    String interestJoined = rs.getString(COL_INTEREST);
                    if (interestJoined != null && !interestJoined.isEmpty()) {
                        vo.setInterest(interestJoined.split("\\s*,\\s*"));
                    } else {
                        vo.setInterest(null);
                    }
                    vo.setPhone(rs.getString(COL_PHONE));
                    vo.setIntroduce(rs.getString(COL_INTRODUCE));

                    list.add(vo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
	
	@Override
    public int update(MemberVO vo) {
        int result = 0;

        final String SQL_UPDATE =
            "UPDATE " + TABLE_NAME + " SET "
                + COL_PASSWORD + " = ?, "
                + COL_EMAIL + " = ?, "
                + COL_EMAIL_AGREE + " = ?, "
                + COL_INTEREST + " = ?, "
                + COL_PHONE + " = ?, "
                + COL_INTRODUCE + " = ? "
            + "WHERE " + COL_USERID + " = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE)) {

                pstmt.setString(1, vo.getPassword());
                pstmt.setString(2, vo.getEmail());
                pstmt.setString(3, vo.getEmailAgree());
                pstmt.setString(4, vo.getInterestJoin());
                pstmt.setString(5, vo.getPhone());
                pstmt.setString(6, vo.getIntroduce());
                pstmt.setString(7, vo.getUserid());

                result = pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
	
	@Override
    public int delete(String userid) {
        int result = 0;

        final String SQL_DELETE =
            "DELETE FROM " + TABLE_NAME + " WHERE " + COL_USERID + " = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE)) {

                pstmt.setString(1, userid);
                result = pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}