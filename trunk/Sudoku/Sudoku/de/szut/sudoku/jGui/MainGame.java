package de.szut.sudoku.jGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGame extends JFrame {

	private JPanel contentPane;
	private JLabel fieldLbl;
	private int spacex;
	private int spacey;
	private int x;
	private int y;
	private JLabel[][] fieldList = new JLabel[9][9];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGame frame = new MainGame();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
				
				fieldLbl.setBounds(10 + (x* 45) + spacey, 10 + (y *45) + spacex, 40, 40);
				fieldLbl.setOpaque(true);
				fieldLbl.setBackground(Color.RED);
				fieldLbl.setHorizontalAlignment(SwingConstants.CENTER);
				fieldLbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
				fieldLbl.setForeground(Color.GREEN);
				contentPane.add(fieldLbl);
				fieldLbl.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						do_lblNewLabel_mouseClicked(arg0);
					}
				});
				fieldList[x][y] = fieldLbl;
			}
		}
	}
	protected void do_lblNewLabel_mouseClicked(MouseEvent arg0) {
		JLabel test = (JLabel) arg0.getSource();
		test.setBackground(Color.CYAN);
		test.setText("5");
		
	}
}
