package de.szut.sudoku.jGui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Listener extends MouseAdapter{
	
	protected void FieldLbl_mouseClicked(MouseEvent clk) {
		JLabel test = (JLabel) clk.getSource();
		test.setBackground(Color.GRAY);		
	}
	
}
