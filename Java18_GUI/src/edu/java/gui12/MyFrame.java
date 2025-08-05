package edu.java.gui12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MyFrame(String msg) {
		// JFrame.EXIT_ON_CLOSE: 프로그램 전체 종료
		// JFrame.DISPOSE_ON_CLOSE: 현재 창만 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();	 // frame.getContentPane()과 같은 의미
		contentPane.setBorder(null);
		
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton(msg);
		contentPane.add(btnNewButton);

		
	}

}
