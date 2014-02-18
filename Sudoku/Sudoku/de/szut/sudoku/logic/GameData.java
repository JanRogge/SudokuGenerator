package de.szut.sudoku.logic;

public class GameData {
	private int [][] playableField = new int[9][9];
	public void test(){
		playableField[8][8] = 1;
	}
	public int[][] getField() {
		return playableField;
	}

}
