package de.szut.sudoku.jGui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Listener extends MouseAdapter{
	private JLabel oldLable;
	private JLabel newLable;
	public void mouseClicked(MouseEvent clk) {
		newLable = (JLabel) clk.getSource();
		newLable.requestFocusInWindow();
		if (newLable.isEnabled() != false){
			if (newLable == oldLable){
				newLable.setBackground(Color.gray);
			}
			else if (oldLable != null){
				newLable.setBackground(Color.gray);
				oldLable.setBackground(Color.white);
			}
			else{
				newLable.setBackground(Color.white);
			}
			oldLable = newLable;
		}		
	}
}
