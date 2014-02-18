package de.szut.sudoku.jGui;

import javax.swing.JFrame;

import de.szut.sudoku.game.IUI;

public class GameFrame extends JFrame implements IUI{
	public GameFrame() {
		setTitle("Sudoku");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 500);
		setLayout(null);
		setContentPane(new GameField());
	}
}
