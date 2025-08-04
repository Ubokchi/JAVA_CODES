package edu.java.contact05;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JButton;

public class ContactMain {

	private static ContactDAO dao;
	private JFrame frame; // 메인 프레임
	// 이름, 전화번호, 이메일, 인덱스를 입력받는 textField
	private JTextField txtName, txtPhone, txtEmail, txtIndex;
	// 연락처 정보, 로그 정보를 출력하는 textArea
	private JTextArea txtAreaInfo, txtAreaLog;

	/* 스윙 테이블을 사용하기 위한 멤버 변수 선언 */
	private JTable table;
	// 테이블 헤더에 들어갈 이름들
	private String[] colNames = {"No", "이름", "전화번호", "이메일"};
	// 테이블 데이터를 저장할 배열 객체
	private Object[] records = new Object[colNames.length];
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수



	public static void main(String[] args) {
		dao = ContactDAOImple.getInstance(); // 다형성. 싱글톤 인스턴스 생성
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain window = new ContactMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ContactMain() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// JLabel 변수 선언, 인스턴스 생성 및 font, bounds 설정. 4개
		Font txtFont = new Font("굴림", Font.PLAIN, 40);
		Font txtFontSmall = new Font("굴림", Font.PLAIN, 15);

		JLabel lblNewLabel = new JLabel("연락처 프로그램 Ver 0.5");
		lblNewLabel.setBounds(12, 12, 480, 33);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(txtFont);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(12, 66, 140, 43);
		frame.getContentPane().add(lblName);
		lblName.setFont(txtFont);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setBounds(12, 121, 140, 43);
		frame.getContentPane().add(lblPhone);
		lblPhone.setFont(txtFont);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(12, 176, 117, 43);
		frame.getContentPane().add(lblEmail);
		lblEmail.setFont(txtFont);

		// JTextField 인스턴스 생성 및 font, bounds 설정. 4개
		txtName = new JTextField();
		txtName.setBounds(188, 57, 304, 52);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setFont(txtFont);

		txtPhone = new JTextField();
		txtPhone.setBounds(188, 112, 304, 52);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		txtPhone.setFont(txtFont);

		txtEmail = new JTextField();
		txtEmail.setBounds(188, 167, 304, 52);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setFont(txtFont);

		txtIndex = new JTextField();
		txtIndex.setColumns(10);
		txtIndex.setBounds(159, 252, 140, 48);
		frame.getContentPane().add(txtIndex);
		txtIndex.setFont(txtFont);

		// JButton 변수 선언, 인스턴스 생성 및 font, bounds
		// addAciontListener 및 메소드 오버라이드 설정. 5개

		JButton btnInsert = new JButton("등록");
		btnInsert.setBounds(12, 251, 140, 52);
		frame.getContentPane().add(btnInsert);
		btnInsert.setFont(txtFont);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String phone = txtPhone.getText();
				String email = txtEmail.getText();
				if (name.equals("") || phone.equals("") || email.equals(""))  {
					txtAreaLog.append("모든 항목을 입력해주세요.");
				} else {
					ContactVO vo = new ContactVO(name, phone, email);
					int result = dao.insert(vo);
					if (result == 1) {
						txtAreaLog.append("연락처 정보 등록 완료\n");
					}
				}
			}
		});

		JButton btnSearch = new JButton("검색");
		btnSearch.setBounds(311, 251, 140, 52);
		frame.getContentPane().add(btnSearch);
		btnSearch.setFont(txtFont);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int index = Integer.parseInt(txtIndex.getText());
					ContactVO vo = dao.select(index);
					if (vo != null) {
						txtAreaInfo.setText(vo.toString() + "\n");
					}
				} catch (Exception ex) {
					txtAreaInfo.setText("해당 인덱스에 연락처가 없습니다\n");
				}
			}
		});

		JButton btnUpdate = new JButton("수정");
		btnUpdate.setBounds(159, 308, 140, 55);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.setFont(txtFont);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
                    int index = Integer.parseInt(txtIndex.getText());
                    String name = txtName.getText();
                    String phone = txtPhone.getText();
                    String email = txtEmail.getText();
                    ContactVO vo = new ContactVO(name, phone, email);
                    int result = dao.update(index, vo);
                    if (result == 1) {
                        txtAreaLog.append("연락처 수정 완료\n");
                    }
                } catch (Exception ex) {
                    txtAreaLog.append("해당 인덱스에 연락처가 없습니다\n");
                }
			}
		});

		JButton btnDelete = new JButton("삭제");
		btnDelete.setBounds(12, 309, 140, 52);
		frame.getContentPane().add(btnDelete);
		btnDelete.setFont(txtFont);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
                    int index = Integer.parseInt(txtIndex.getText());
                    int result = dao.delete(index);
                    if (result == 1) {
                        txtAreaLog.append("연락처 삭제 완료\n");
                    }
                } catch (Exception ex) {
                    txtAreaLog.append("해당 인덱스에 연락처가 없습니다\n");
                }
			}
		});

		JButton btnAllSearch = new JButton("전체검색");
		btnAllSearch.setBounds(311, 307, 181, 52);
		frame.getContentPane().add(btnAllSearch);
		btnAllSearch.setFont(txtFont);
		btnAllSearch.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ArrayList<ContactVO> list = dao.select();
		        StringBuilder sb = new StringBuilder();
		        
		        for (int i = 0; i < list.size(); i++) {
		            sb.append(list.get(i).toString()).append("\n");
		        }
		        txtAreaInfo.setText(sb.toString());
		        txtAreaLog.append("등록된 연락처 개수: " + list.size() + "\n");

		        tableModel.setRowCount(0);
		        for (int i = 0; i < list.size(); i++) {
		            ContactVO vo = list.get(i);
		            Object[] row = { i, vo.getName(), vo.getPhone(), vo.getEmail() };
		            tableModel.addRow(row);
		        }
		    }
		});

		// JScrollPane 변수 선언, 인스턴스 생성 및 설정. 3개
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 393, 480, 95);
		frame.getContentPane().add(scrollPane1);

		txtAreaInfo = new JTextArea();
		// TODO: txtAreaInfo font 설정 추가
		scrollPane1.setViewportView(txtAreaInfo);
		txtAreaInfo.setFont(txtFontSmall);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(12, 498, 480, 95);
		frame.getContentPane().add(scrollPane2);

		txtAreaLog = new JTextArea();
		// TODO : txtAreaLog font 설정 추가
		scrollPane2.setViewportView(txtAreaLog);
		
		txtAreaLog.setFont(txtFontSmall);


		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(503, 252, 255, 341);
		frame.getContentPane().add(scrollPane3);
		
		tableModel = new DefaultTableModel(colNames, 0);
		table = new JTable(tableModel);
		table.setBounds(503, 252, 266, 341);
		scrollPane3.setViewportView(table);
		
		
		

	}
}


