package de.szut.sudoku.jGui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameField extends JPanel {

	private JPanel contentPane;
	private JLabel fieldLbl;
	private int spacex;
	private int spacey;
	private int x;
	private int y;
	private JLabel[][] fieldList = new JLabel[9][9];
	private Listener listen = new Listener();
	
	public GameField() {
		setSize(500, 500);
		contentPane = new JPanel();
		contentPane.setLayout(null);		
		
		spacey = 0;
		for (x = 0; x < 9; x++){
			spacex = 0;
			if (x % 3 == 0 && x != 0){
				spacey = spacey + 10;
			}
			for (y = 0; y < 9; y++){
				fieldLbl= new JLabel("1");
				if (y % 3 == 0 && y != 0){
					spacex = spacex + 10;
				}
				
				fieldLbl.setLocation(10 + (x* 45) + spacey, 10 + (y *45) + spacex);
				fieldLbl.setSize(40, 40);
				fieldLbl.setOpaque(true);
				fieldLbl.setBackground(Color.RED);
				fieldLbl.setHorizontalAlignment(SwingConstants.CENTER);
				fieldLbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
				fieldLbl.setForeground(Color.GREEN);
				add(fieldLbl);
				fieldLbl.addMouseListener(listen);
				fieldList[x][y] = fieldLbl;
			}
		}
	}
	public JPanel getField(){
		return this;
	}

}
