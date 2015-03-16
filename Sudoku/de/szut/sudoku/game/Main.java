package de.szut.sudoku.game;

import de.szut.sudoku.console.Console;
import de.szut.sudoku.jGui.GameField;
import de.szut.sudoku.logic.GameData;
import de.szut.sudoku.logic.GenerateSudoku;
import de.szut.sudoku.logic.Logic;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		GameData data = new GameData(); 
		Logic logic = new Logic();
		//Auswählen welches Interface man nutzen möchte
		//IUI ui = new GameField();
		IUI ui = new Console();
		Controller.Instance(logic, ui, data);
	}
}