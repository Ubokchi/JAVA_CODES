package edu.java.gui02;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GuiMain02 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain02 window = new GuiMain02();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMain02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOutput = new JLabel("오늘은 금요일!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setForeground(Color.BLUE);
		lblOutput.setFont(new Font("Apple SD Gothic Neo", Font.BOLD, 18));
		lblOutput.setBounds(6, 6, 438, 73);
		frame.getContentPane().add(lblOutput);
		
		JTextField txtInput = new JTextField();
		txtInput.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 24));
		txtInput.setBounds(19, 81, 410, 73);
		txtInput.setColumns(10);
		frame.getContentPane().add(txtInput);
		
		JButton btnInput = new JButton("입력");
		
		// 이벤트: 마우스로 버튼을 클릭했을 때
		btnInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("마우스 클릭됨");
				// 버튼을 클릭했을 때 해야할 기능 작성
				// JTextField에 입력된 내용을 읽어서 JLabel에 쓰기
				String msg = txtInput.getText();
				lblOutput.setText(msg);
			}
			
		});
		
		btnInput.setFont(new Font("Apple SD Gothic Neo", Font.PLAIN, 18));
		btnInput.setBounds(19, 166, 410, 81);
		frame.getContentPane().add(btnInput);
		
		System.out.println("initailize 메소드 호출 끝");
	}
}
