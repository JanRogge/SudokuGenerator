package de.szut.sudoku.jGui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class LabelKey extends KeyAdapter{
	
	private GameField gui;
	public LabelKey(GameField gui){
		this.gui = gui;
	}
	public void keyPressed(KeyEvent e) {
		JLabel source = (JLabel) e.getSource();
		char getChar = e.getKeyChar();
		source.setText("5");
	}
}
