package de.szut.sudoku.jGui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Listener extends MouseAdapter{
	public void mouseClicked(MouseEvent clk) {
		JLabel test = (JLabel) clk.getSource();
		test.requestFocusInWindow();
		if (test.requestFocusInWindow()){
			test.setBackground(Color.gray);
		}
	}
}
