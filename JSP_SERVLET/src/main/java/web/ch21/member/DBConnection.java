package web.ch21.member;

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
	
}