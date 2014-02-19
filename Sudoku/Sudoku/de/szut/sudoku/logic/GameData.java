package de.szut.sudoku.logic;

public class GameData {
	private int [][] playableField = new int[9][9];
	private int [][] finishedField = new int[9][9];
	private int y;
	private int x;
	public GameData(){
		GenerateSudoku sudoku = new GenerateSudoku();
		sudoku.genSudoku(); //generiert das Sudoku
		int[][] generatedfield = sudoku.getfield();
		int[][] solvedfield = sudoku.getsolvedfield();
		//Überträgt das gelöste und undgelöste Sudoku in die GameData
		for (x = 0; x < 9; x++){
			for (y = 0; y < 9; y++){
				playableField[x][y] = generatedfield[x][y];
			}
		}
		for (x = 0; x < 9; x++){
			for (y = 0; y < 9; y++){
				finishedField[x][y] = solvedfield[x][y];
			}
		}
	}
	public int[][] getplayableField() {
		return playableField;
	}
	public int[][] getsolvedField() {
		return finishedField;
	}

}
