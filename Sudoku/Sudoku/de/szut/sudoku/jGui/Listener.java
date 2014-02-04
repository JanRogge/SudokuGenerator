package de.szut.sudoku.jGui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Listener extends MouseAdapter{
	
	protected void FieldLbl_mouseClicked(MouseEvent Clk) {
		JLabel test = (JLabel) Clk.getSource();
		test.setBackground(Color.GRAY);
		test.setText("5");
		
	}
	
}
