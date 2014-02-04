package de.szut.sudoku.jGui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class MainTest extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTest frame = new MainTest();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setContentPane(new GameField());
		setLayout(null);
	}

}
