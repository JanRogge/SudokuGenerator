package de.szut.sudoku.jGui;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.szut.sudoku.game.IUI;
import de.szut.sudoku.logic.GameData;

public class GameField extends JFrame implements IUI{

	private JLabel fieldLbl;
	private int spacex;
	private int spacey;
	private int x;
	private int y;
	private JLabel[][] fieldList = new JLabel[9][9];
	private Listener listen = new Listener();
	private LabelKey key = new LabelKey();
	private GameData data;
	
	public GameField() {
		setTitle("Sudoku");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 500);
		setLayout(null);		
		
		spacey = 0;
		for (x = 0; x < 9; x++){
			spacex = 0;
			if (x % 3 == 0 && x != 0){
				spacey = spacey + 10;
			}
			for (y = 0; y < 9; y++){
				fieldLbl= new JLabel("");
				if (y % 3 == 0 && y != 0){
					spacex = spacex + 10;
				}
				fieldLbl.setLocation(10 + (x* 45) + spacey, 10 + (y *45) + spacex);
				fieldLbl.setSize(40, 40);
				fieldLbl.setOpaque(true);
				fieldLbl.setBackground(Color.white);
				fieldLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
				fieldLbl.setHorizontalAlignment(SwingConstants.CENTER);
				fieldLbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
				fieldLbl.setForeground(Color.blue);
				fieldLbl.addMouseListener(listen);
				fieldLbl.addKeyListener(key);
				fieldList[x][y] = fieldLbl;
				add(fieldLbl);
			}
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		data = (GameData) arg;
		int [][] playableField = data.getField();
		for (x = 0; x < 9; x++){
			for (y = 0; y < 9; y++){
				if (playableField[x][y] != 0){
					fieldList[x][y].setText(playableField[x][y]+"");
					fieldList[x][y].disable();
				}
			}
		}
		revalidate();
		repaint();
	}
}
