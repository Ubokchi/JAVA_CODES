package edu.java.gui08;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiMain08 {

	private JFrame frame;
	
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain08 window = new GuiMain08();
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
	public GuiMain08() {
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

		Icon[] dogs = new Icon[4];
		dogs[0] = new ImageIcon("res/dog1.jpg");
		dogs[1] = new ImageIcon("res/dog2.jpg");
		dogs[2] = new ImageIcon("res/dog3.jpg");
		dogs[3] = new ImageIcon("res/dog4.jpg");
		
		JLabel lblOutput = new JLabel();
		lblOutput.setIcon(dogs[0]);
		lblOutput.setFont(new Font("굴림", Font.BOLD, 42));
		lblOutput.setBounds(119, 6, 225, 197);
		frame.getContentPane().add(lblOutput);

		JButton btnPrev = new JButton("이전");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index > 0) {
					index--;
				} else {
					index = dogs.length - 1;
				}
				lblOutput.setIcon(dogs[index]);
			}
		});
		btnPrev.setBounds(6, 215, 213, 201);
		btnPrev.setFont(new Font("굴림", Font.BOLD, 42));
		frame.getContentPane().add(btnPrev);

		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (index < dogs.length -1) {
					index ++;
				} else  {
					index = 0;
				}
				lblOutput.setIcon(dogs[index]);
			}
		});
		btnNext.setFont(new Font("굴림", Font.BOLD, 42));
		btnNext.setBounds(219, 215, 225, 201);
		frame.getContentPane().add(btnNext);


	}

}
