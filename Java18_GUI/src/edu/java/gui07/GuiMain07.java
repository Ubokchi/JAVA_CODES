package edu.java.gui07;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiMain07 {

	private JFrame frame;

	private static final String[] NAMES = {
			"김민성",
			"박기룡",
			"송우진",
			"신민섭",
			"오관영",
			"유다현",
			"유동환",
			"이경민",
			"이민규",
			"이영우",
			"장영환",
			"최성민",
			"한석준",
			"홍정민"
	};

	private int index = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain07 window = new GuiMain07();
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
	public GuiMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblOutput = new JLabel(NAMES[0]);
		lblOutput.setFont(new Font("굴림", Font.BOLD, 42));
		lblOutput.setBounds(12, 10, 200, 100);
		frame.getContentPane().add(lblOutput);

		JButton btnPrev = new JButton("이전");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index > 0) {
					index--;
				} else {
					index = NAMES.length - 1;
				}
				lblOutput.setText(NAMES[index]);
			}
		});
		btnPrev.setBounds(12, 150, 200, 201);
		btnPrev.setFont(new Font("굴림", Font.BOLD, 42));
		frame.getContentPane().add(btnPrev);

		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index < NAMES.length -1) {
					index ++;
				} else  {
					index = 0;
				}
				lblOutput.setText(NAMES[index]);
			}
		});
		btnNext.setFont(new Font("굴림", Font.BOLD, 42));
		btnNext.setBounds(224, 150, 198, 201);
		frame.getContentPane().add(btnNext);


	}
}
