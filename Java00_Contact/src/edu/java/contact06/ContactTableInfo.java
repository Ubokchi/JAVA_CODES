package edu.java.contact06;

public interface ContactTableInfo extends MySQLConnInfo{
	public static final String TABLE_NAME = "ex_contact";
	public static final String COL_CONTACT_ID = "contact_id";
	public static final String COL_NAME = "name";
	public static final String COL_PHONE = "phone";
	public static final String COL_EMAIL = "email";
	
	public static final String SQL_INSERT = 
			"insert into ex_contact (name, phone, email)"
			+ " values (?, ?, ?)";
	
	public static final String SQL_SELECT_BY_CONTACT_ID =
			"SELECT * FROM " + TABLE_NAME + 
			" WHERE " + COL_CONTACT_ID + " = ?";
	
	public static final String SQL_SELECT_ALL =
			"SELECT * FROM " + TABLE_NAME + 
			" ORDER BY " + COL_CONTACT_ID;
	
	public static final String SQL_UPDATE = 
			"update ex_contact "
			+ "set name = ?, phone = ?, email = ? "
			+ "where contact_id = ?";

	public static final String SQL_DELETE = 
			"delete from ex_contact where contact_id = ?";

}
