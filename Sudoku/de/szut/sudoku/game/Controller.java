package de.szut.sudoku.game;

import java.util.Observer;

import de.szut.sudoku.logic.GameData;
import de.szut.sudoku.logic.Logic;

public class Controller {
	
	private static Controller instance;
	private static Logic logic;
	private static IUI iui;
	private static GameData data;
	
	private Controller(Logic logic, IUI iui, GameData data){
		this.logic = logic;
		this.iui = iui;
		iui.update(logic, data); //Updatet die UI mit den Sudoku daten
		logic.addObserver((Observer) iui); //Fügt einen Observer hinzu
	}
	public static Controller Instance(Logic logic, IUI iui, GameData data){
		if (instance == null) {
			instance = new Controller(logic, iui, data);
		}
		return instance;
	}
	public static Controller getI(){
		return instance;
	}
}
