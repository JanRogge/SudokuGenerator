package de.szut.sudoku.jGui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class LabelKey extends KeyAdapter{
	
	public void keyPressed(KeyEvent e) {
		JLabel source = (JLabel) e.getSource();
		char number = e.getKeyChar();
		String baum = ""+number;
		source.setText(baum);
	}
}
