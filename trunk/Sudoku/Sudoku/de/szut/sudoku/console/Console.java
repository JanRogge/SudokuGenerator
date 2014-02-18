package de.szut.sudoku.console;

import java.util.Observable;
import java.util.Scanner;

import de.szut.sudoku.game.IUI;
import de.szut.sudoku.logic.GameData;

public class Console implements IUI{
	private boolean gamefinish = false;
	private int y;
	private int x;
	private String number;
	private GameData data;
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
	private int newx;
	private int newy;
	private boolean test;
	public Console(){
		//printField();
		//setNumber();
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
		while (!gamefinish) {
			Scanner scan = new Scanner(System.in);
			try{
				System.out.print("Bitte geben die X-Coordinate ein:");
				x = scan.nextInt();
			}
			catch(Exception ex){
				System.out.println("Nur Zahlen:");
			}
			try{
				System.out.print("Bitte geben die Y-Coordinate ein:");
				y = scan.nextInt();
				}
				catch(Exception ex){
					System.out.println("Nur Zahlen:");
				}
			System.out.println("Bitte geben die Zahl ein:");
			number = scan.next();
			x = x * 2;
			y = y * 2 - 1;
			spielbrett[y][x] = number.charAt(0);
			printField();
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		data = (GameData) arg1;
		int [][] playableField = data.getField();
		for (x = 0; x < 9; x++){
			for (y = 0; y < 9; y++){
				if (playableField[x][y] != 0){
					newx = (x+1) * 2 - 1;
					newy = (y+1) * 2;
					spielbrett[newx][newy] = (char) ((playableField[x][y]+"").charAt(0));
				}
			}
		}
		printField();
		setNumber();
	}
}
