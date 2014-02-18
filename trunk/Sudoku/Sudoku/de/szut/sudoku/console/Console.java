package de.szut.sudoku.console;

import java.util.Scanner;

import de.szut.sudoku.game.IUI;

public class Console implements IUI{
	private boolean gamefinish = false;
	private int y;
	private int x;
	private String number;
	private char[][] spielbrett = {
			{ ' ', '╔', '═', '═', '═', '═', '═', '═', '═', '═', '═', '═','═', '═', '═', '═', '═', '═', '═', '╗' },
			{ '1', '║', ' ', '│', ' ', '│', ' ', '║', ' ', '│', ' ', '│',' ', '║', ' ', '│', ' ', '│', ' ', '║' },
			{ ' ', '║', '─', '│', '─', '│', '─', '║', '─', '│', '─', '│','─', '║', '─', '│', '─', '│', '─', '║' },
			{ '2', '║', ' ', '│', ' ', '│', ' ', '║', ' ', '│', ' ', '│',' ', '║', ' ', '│', ' ', '│', ' ', '║' },
			{ ' ', '║', '─', '│', '─', '│', '─', '║', '─', '│', '─', '│','─', '║', '─', '│', '─', '│', '─', '║' },
			{ '3', '║', ' ', '│', ' ', '│', ' ', '║', ' ', '│', ' ', '│',' ', '║', ' ', '│', ' ', '│', ' ', '║' },
			{ ' ', '║', '═', '═', '═', '═', '═', '║', '═', '═', '═', '═','═', '║', '═', '═', '═', '═', '═', '║' },
			{ '4', '║', ' ', '│', ' ', '│', ' ', '║', ' ', '│', ' ', '│',' ', '║', ' ', '│', ' ', '│', ' ', '║' },
			{ ' ', '║', '─', '│', '─', '│', '─', '║', '─', '│', '─', '│','─', '║', '─', '│', '─', '│', '─', '║' },
			{ '5', '║', ' ', '│', ' ', '│', ' ', '║', ' ', '│', ' ', '│',' ', '║', ' ', '│', ' ', '│', ' ', '║' },
			{ ' ', '║', '─', '│', '─', '│', '─', '║', '─', '│', '─', '│','─', '║', '─', '│', '─', '│', '─', '║' },
			{ '6', '║', ' ', '│', ' ', '│', ' ', '║', ' ', '│', ' ', '│',' ', '║', ' ', '│', ' ', '│', ' ', '║' },
			{ ' ', '║', '═', '═', '═', '═', '═', '║', '═', '═', '═', '═','═', '║', '═', '═', '═', '═', '═', '║' },
			{ '7', '║', ' ', '│', ' ', '│', ' ', '║', ' ', '│', ' ', '│',' ', '║', ' ', '│', ' ', '│', ' ', '║' },
			{ ' ', '║', '─', '│', '─', '│', '─', '║', '─', '│', '─', '│','─', '║', '─', '│', '─', '│', '─', '║' },
			{ '8', '║', ' ', '│', ' ', '│', ' ', '║', ' ', '│', ' ', '│',' ', '║', ' ', '│', ' ', '│', ' ', '║' },
			{ ' ', '║', '─', '│', '─', '│', '─', '║', '─', '│', '─', '│','─', '║', '─', '│', '─', '│', '─', '║' },
			{ '9', '║', ' ', '│', ' ', '│', ' ', '║', ' ', '│', ' ', '│',' ', '║', ' ', '│', ' ', '│', ' ', '║' },
			{ ' ', '╚', '═', '═', '═', '═', '═', '═', '═', '═', '═', '═','═', '═', '═', '═', '═', '═', '═', '╝' },
			{ ' ', ' ', '1', ' ', '2', ' ', '3', ' ', '4', ' ', '5', ' ','6', ' ', '7', ' ', '8', ' ', '9', ' ' } // X-Achse

	};
	public Console(){
		printField();
		setNumber();
	}
	public void printField(){
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(spielbrett[i][j]);
			}
			System.out.println();
		}
	}
	public void setNumber(){
		while (gamefinish == false) {
			Scanner scan = new Scanner(System.in);
			x = scan.nextInt();
			y = scan.nextInt();
			number = scan.next();
			x = x * 2;
			y = y * 2 - 1;
			spielbrett[y][x] = '1';
			printField();
		}
	}
	@Override
	public void showField() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendData() {
		// TODO Auto-generated method stub
		
	}

}
