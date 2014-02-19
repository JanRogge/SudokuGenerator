package de.szut.sudoku.jGui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

public class LabelKey extends KeyAdapter{
	
	public void keyPressed(KeyEvent e) {
		JLabel source = (JLabel) e.getSource(); //Holt die Source von dem ausgewählten JLabel
		char number = e.getKeyChar(); //Gibt den eingegebenen Character aus
		String strNumber = ""+number; //Konvertiert den char in einen String
		if (e.getKeyCode() == 127 || e.getKeyCode() == 8){ //Entfernt falls man ENTF oder Backspace drückt den inhalt
			source.setText(" ");
		}
		else if (Character.isDigit(e.getKeyChar())){ //Man kann nur Nummern eintragen
			source.setText(strNumber);
		}
	}
}
