package de.szut.sudoku.logic;

public class GameData {
	private int [][] playableField = {
			{7,1,9,4,3,5,2,6,8},
			{5,3,8,7,2,6,9,4,1},
			{4,6,2,9,0,8,5,7,3},
			{1,9,5,2,8,7,6,3,4},
			{8,4,3,6,5,1,7,2,9},
			{2,7,6,3,4,9,1,8,5},
			{3,2,7,5,9,4,8,1,6},
			{9,8,4,1,6,2,3,5,7},
			{6,5,1,8,7,3,4,9,2}
	};
	public int[][] getField() {
		return playableField;
	}

}
