package de.szut.sudoku.jGui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class LabelKey extends KeyAdapter{
	
	public void keyPressed(KeyEvent e) {
		JLabel source = (JLabel) e.getSource();
		char number = e.getKeyChar();
		System.out.println(e.getKeyCode());
		String strNumber = ""+number;
		if (e.getKeyCode() == 127 || e.getKeyCode() == 8){
			source.setText(" ");
		}
		else if (Character.isDigit(e.getKeyChar())){
			source.setText(strNumber);
		}
	}
}
