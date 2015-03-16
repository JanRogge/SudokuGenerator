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
	public Console(){
	}
	public void printField(){ //Gibt das Spielfeld aus
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(spielbrett[i][j]);
			}
			System.out.println();
		}
	}
	public void setNumber(){
		while (!gamefinish) { //Eingabe fordern solange des Spiel nicht beendet worde
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in); //Öffnet den Scanner
			try{
				System.out.print("Bitte geben die X-Coordinate ein. (Oder geben sie für eine der folgenden Zahlen einen Null ein um das Programm zu beenden.)");
				x = scan.nextInt(); //Eingabe für die X Position
			}
			catch(Exception ex){
				System.out.println("Nur Zahlen:");
			}
			try{
				System.out.print("Bitte geben die Y-Coordinate ein:");
				y = scan.nextInt(); //Eingabe für die Y Position
				}
			catch(Exception ex){
					System.out.println("Nur Zahlen:");
			}
			System.out.println("Bitte geben die Zahl ein:");
			number = scan.next(); //Eingabe für die Zahl
			if (x == 0|| y == 0|| number == "0"){ //Beendet das Programm wenn eine 0 eingeben wird
				System.exit(0);
			}
			x = x * 2;
			y = y * 2 - 1;
			try{
				spielbrett[y][x] = number.charAt(0); //Fügt die Zahl dem Spielfeld hinzu
			}
			catch(Exception ex){
				System.out.println("Die bist außerhalb des Arrays");
			}
			printField();
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		data = (GameData) arg1;
		int [][] playableField = data.getplayableField();
		//Setzt die Felder vom Generierten Feld
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
