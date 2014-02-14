package de.szut.sudoku.jGui;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	public GameFrame() {
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setLayout(null);
		setContentPane(new GameField());
	}

}
