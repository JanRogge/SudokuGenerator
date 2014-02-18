package de.szut.sudoku.logic;

public class GenerateSudoku {
	private int avalibelNumbers[] = new int[8];
	private int x;
	public void fillNumbers(){
		for (x = 0; x < 9; x++){
			avalibelNumbers[x] = x+1;
			System.out.println(avalibelNumbers[x]);
		}
	}
}
