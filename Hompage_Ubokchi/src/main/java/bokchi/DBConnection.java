package bokchi;
public interface DBConnection {
	String URL = "jdbc:mysql://localhost:3306/sys";
	String USER = "root";
	String PASSWORD = "020920";
	
	String COL_USERID = "USERID";
	String COL_PASSWORD = "PASSWORD";
	String COL_EMAIL = "EMAIL";
	String COL_EMAIL_AGREE = "EMAIL_AGREE";
	String COL_INTEREST = "INTEREST";
	String COL_PHONE = "PHONE";
	String COL_INTRODUCE = "INTRODUCE";
	String TABLE_NAME = "TEST_MEMBER";
	
	String SQL_INSERT = "INSERT INTO " + TABLE_NAME 
			+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	String SQL_SELECT = "SELECT * FROM " + TABLE_NAME // 아이디로 조회
	        + " WHERE " + COL_USERID + " = ?";
	
	String SQL_SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
	
	String SQL_UPDATE = "UPDATE " + TABLE_NAME 	// 아이디로 수정
	        + " SET " 
	        + COL_PASSWORD + " = ?, "
	        + COL_EMAIL + " = ?, "
	        + COL_EMAIL_AGREE + " = ?, "
	        + COL_INTEREST + " = ?, "
	        + COL_PHONE + " = ?, "
	        + COL_INTRODUCE + " = ? "
	        + " WHERE " + COL_USERID + " = ?";
}