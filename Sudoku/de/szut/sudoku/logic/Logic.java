package de.szut.sudoku.logic;

import java.util.Observable;

public class Logic extends Observable{
	public void test(GameData data){	
		setChanged();
		System.out.println(countObservers());
		notifyObservers(data);
	}
}
