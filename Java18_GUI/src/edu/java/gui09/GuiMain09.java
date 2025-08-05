package edu.java.gui09;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class GuiMain09 {

	private JFrame frame;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain09 window = new GuiMain09();
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
	public GuiMain09() {
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
		
		JCheckBox chckbxMusic = new JCheckBox("음악");
		chckbxMusic.setBounds(6, 6, 67, 23);
		frame.getContentPane().add(chckbxMusic);
		
		JCheckBox chckbxMovie = new JCheckBox("영화");
		chckbxMovie.setBounds(132, 6, 67, 23);
		frame.getContentPane().add(chckbxMovie);
		
		JCheckBox chckbxReading = new JCheckBox("독서");
		chckbxReading.setEnabled(false);
		chckbxReading.setBounds(254, 6, 67, 23);
		frame.getContentPane().add(chckbxReading);
		
		JButton btnOutput = new JButton("출력");
		btnOutput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = "음악: " + chckbxMusic.isSelected()
					+ "영화: " + chckbxMovie.isSelected()
					+ "독사: " + chckbxReading.isAncestorOf(chckbxReading);
				textArea.setText(result);
			}
		});
		btnOutput.setBounds(333, 5, 117, 29);
		frame.getContentPane().add(btnOutput);
		
		textArea = new JTextArea();
		textArea.setBounds(6, 41, 438, 225);
		frame.getContentPane().add(textArea);
	}
}
