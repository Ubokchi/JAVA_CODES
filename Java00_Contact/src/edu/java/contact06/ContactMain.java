package edu.java.contact06;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ContactMain implements OracleQuery{

	private JFrame frame;
	private JTextField txtName, txtPhone, txtEmail, txtIndex;
	private JTextArea txtAreaInfo, txtAreaLog;

	private ContactDAO dao;
	private ArrayList<ContactVO> contactList = new ArrayList<>();

	/* 스윙 테이블을 사용하기 위한 멤버 변수 선언 */  
	private JTable table;
	private String[] colNames = {"No", "이름", "전화번호", "이메일"}; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain window = new ContactMain();
					window.frame.setVisible(true);

					// 2. JDBC 드라이버 로드
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("드라이버 로드 성공");

					// 3. DB 연결
					conn = DriverManager.getConnection(URL, USER, PASSWORD);
					System.out.println("DB 연결 성공");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContactMain() {
		dao = ContactDAOImple.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Font lblFont = new Font("굴림", Font.PLAIN, 44);
		int lblWidth = 176;
		int lblHeight = 55;
		JLabel lblNewLabel = new JLabel("연락처 프로그램 Version 0.5");
		lblNewLabel.setFont(lblFont);
		lblNewLabel.setBounds(12, 10, 746, 66);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblName = new JLabel("이름");
		lblName.setFont(lblFont);
		lblName.setBounds(12, 86, lblWidth, lblHeight);
		frame.getContentPane().add(lblName);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setFont(lblFont);
		lblPhone.setBounds(12, 151, lblWidth, lblHeight);
		frame.getContentPane().add(lblPhone);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(lblFont);
		lblEmail.setBounds(12, 216, lblWidth, lblHeight);
		frame.getContentPane().add(lblEmail);

		Font txtFont = new Font("굴림", Font.PLAIN, 34);
		int txtWidth = 286;
		int txtHeight = 55;
		txtName = new JTextField();
		txtName.setFont(txtFont);
		txtName.setBounds(200, 86, txtWidth, txtHeight);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setFont(txtFont);
		txtPhone.setBounds(200, 151, txtWidth, txtHeight);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(txtFont);
		txtEmail.setBounds(200, 216, txtWidth, txtHeight);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		Font btnFont = new Font("굴림", Font.PLAIN, 24);

		JButton btnInsert = new JButton("등록");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertContact();
			}
		});
		btnInsert.setFont(btnFont);
		btnInsert.setBounds(12, 281, 110, 46);
		frame.getContentPane().add(btnInsert);

		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectContact(conn, pstmt);
			}
		});

		btnSearch.setFont(btnFont);
		btnSearch.setBounds(256, 281, 110, 46);
		frame.getContentPane().add(btnSearch);

		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});

		btnUpdate.setFont(btnFont);
		btnUpdate.setBounds(12, 337, 110, 46);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteContact();
			}
		});

		btnDelete.setFont(btnFont);
		btnDelete.setBounds(134, 337, 110, 46);
		frame.getContentPane().add(btnDelete);

		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.addActionListener((e) -> {
			selectAllContact();
			selectAllContactTable();
		});
		btnAllSearch.setFont(btnFont);
		btnAllSearch.setBounds(256, 337, 190, 46);
		frame.getContentPane().add(btnAllSearch);

		txtIndex = new JTextField();

		txtIndex.setText("번호입력");
		txtIndex.setFont(new Font("굴림", Font.PLAIN, 17));
		txtIndex.setBounds(134, 281, 108, 46);
		txtIndex.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtIndex.setText("");
			}
		});

		frame.getContentPane().add(txtIndex);
		txtIndex.setColumns(5);

		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 393, 480, 95);
		frame.getContentPane().add(scrollPane1);

		txtAreaInfo = new JTextArea();
		txtAreaInfo.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane1.setViewportView(txtAreaInfo);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(12, 498, 480, 95);
		frame.getContentPane().add(scrollPane2);

		txtAreaLog = new JTextArea();
		txtAreaLog.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane2.setViewportView(txtAreaLog);

		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(504, 281, 254, 312);
		frame.getContentPane().add(scrollPane3);

		// 테이블 초기화
		tableModel = new DefaultTableModel(colNames, 0); // 0 = 초기 행 개수
		table = new JTable(tableModel);

		table.setFont(new Font("굴림", Font.PLAIN, 15));

		scrollPane3.setViewportView(table);

	} // end initialize()

	// contactList 배열에 Contact 인스턴스를 저장
	private void insertContact() {

		try {
			// 4. Statement 객체 생성
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			String name = txtName.getText();
			String phone = txtPhone.getText();
			String email = txtEmail.getText();
			if(validInput(name, phone, email)) {
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				pstmt.setString(3, email);
				int result = pstmt.executeUpdate();

				if(result == 1) {
					ContactVO vo = new ContactVO(name, phone, email);

					int size = getSize();
					txtAreaLog.setText("등록된 연락처 개수 : " + getSize() + "\n" + "연락처 등록 완료");
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}



	} // end insertContact()

	private void selectAllContact() {
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery(); 

			StringBuilder sb = new StringBuilder();

			while (rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");

				ContactVO vo = new ContactVO(name, phone, email);
				sb.append(vo.toString()).append("\n");
			}

			txtAreaInfo.setText(sb.toString());

		} catch(SQLException e) {
			e.printStackTrace();
		}
	} // end selectAllContact()

	private void selectContact(Connection conn, PreparedStatement pstmt) {
		try {
			ResultSet rs = null;
			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);

			int contactId = Integer.parseInt(txtIndex.getText());

			// 5. SQL 문장 작성
			pstmt.setInt(1, contactId);

			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery(); 

			// 7. DB 서버가 보낸 결과 확인/처리
			// ResultSet.next() :
			// ResultSet에서 다음 행(row or record)이 있으면
			// true를 리턴하고, ResultSet이 가리키는 위치를 다음 위치로 변경


			if(rs.next()) { // 레코드가 존재할 때까지
				try {
					contactId = rs.getInt(1); // CONTACT_ID 컬럼
					String name = rs.getString(2); // NAME 컬럼
					String phone = rs.getString(3); // PHONE 컬럼
					String email = rs.getString(4); // EMAIL 컬럼

					ContactVO vo = new ContactVO(name, phone, email);
					txtAreaInfo.setText(vo.toString());
				} catch (NumberFormatException e) {
					txtAreaLog.setText("올바른 인덱스를 입력하십시오.");
				}

			} else {
				txtAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

	} // end selectContact()

	private void updateContact() {
	    try {
	        int index = Integer.parseInt(txtIndex.getText());
	        if (index < 0 || index >= contactList.size()) {
	            txtAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
	            return;
	        }

	        ContactVO vo = contactList.get(index);

	        String name = txtName.getText();
	        String phone = txtPhone.getText();
	        String email = txtEmail.getText();
	        int contactId = Integer.parseInt(txtIndex.getText());
	        
	        if (validInput(name, phone, email)) {
	            pstmt = conn.prepareStatement(SQL_UPDATE);
	            pstmt.setString(1, name);
	            pstmt.setString(2, phone);
	            pstmt.setString(3, email);
	            pstmt.setInt(4, contactId);
	            
	            int result = pstmt.executeUpdate();
	            if (result == 1) {
	                txtAreaLog.setText("연락처 수정 완료!");
	                selectAllContactTable();
	            }
	        }

	    } catch (NumberFormatException | SQLException e) {
	        e.printStackTrace();
	        txtAreaLog.setText("수정 중 오류 발생");
	    }
	} // end updateContact()

	private void deleteContact() {
		try {
			int contactId = Integer.parseInt(txtIndex.getText());

			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, contactId);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				txtAreaLog.setText("연락처 삭제 완료!");
				selectAllContactTable();
			} else {
				txtAreaLog.setText("해당 인덱스에 연락처가 없습니다.");
			}

		} catch (NumberFormatException e) {
			txtAreaLog.setText("올바른 인덱스를 입력하십시오.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // deleteContact()   

	private void selectAllContactTable() {
	    tableModel.setRowCount(0);
	    contactList.clear(); 

	    ArrayList<ContactVO> list = dao.select(); 
	    for (int i = 0; i < list.size(); i++) {
	        ContactVO vo = list.get(i);
	        contactList.add(vo); 
	        records[0] = i; 
	        records[1] = vo.getName();
	        records[2] = vo.getPhone();
	        records[3] = vo.getEmail();
	        tableModel.addRow(records);
	    }
	}

	private boolean validInput(String name, String phone, String email) {      
		// name, phone, email 중 하나라도 입력되지 않으면
		// 경고창 띄우고 기능 실행 안되도록 구현
		if(name.equals("") || phone.equals("") || email.equals("")) {
			JOptionPane.showMessageDialog(
					frame,   // 다이얼로그가 위치할 부모 컴포넌트 (null이면 화면 중앙)
					"이름 전화번호 이메일을 입력해 주세요.", // 메시지
					"경고",             // 제목
					JOptionPane.WARNING_MESSAGE // 메시지 타입
					);
			return false;
		}
		return true;

	}

	private int getSize() {
		int count = 0;
		try (
				PreparedStatement pstmt = conn.prepareStatement(SQL_COUNT);
				ResultSet rs = pstmt.executeQuery()
				) {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
} // end ContactMain05