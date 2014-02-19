package de.szut.sudoku.logic;

public class GenerateSudoku {

	private boolean[][] colum = new boolean[9][10]; //Ein Array aus Booleans in dem jede zahl ihr eigendes true/false in der spalte hat
	private boolean[][] row = new boolean[9][10]; //Ein Array aus Booleans in dem jede zahl ihr eigendes true/false in der zeile hat
	private boolean[][] box = new boolean[9][10]; //Ein Array aus Booleans in dem jede zahl ihr eigendes true/false in der box hat
	private int[][] field = new int[9][9]; //Array in das das Sudoku-Feld generiert wird
	private int[][] partfield = new int[9][9]; //Array zum eintragen der vorübergehenden Zahlen
	private int[][] solvedfield = new int[9][9]; //Array für das spätere vollständige Feld
	private int empty_field = 0; //Zahl die für freie felder ins Array eingesetzt wird
	private int fillednumbers = 100; //Je höher die Zahl hier gewählt wird desto länger dauert die erzeugung des Feldes und desto mehr Zahlen sind im Sudoku
	
	public GenerateSudoku() {
		start(); //Führt die start sequenz aus
	}

	private void start() { //Start sequenz
		for (int boxnumber = 0; boxnumber < 9; boxnumber++) { 
			for (int number = 1; number < 10; number++) {
				this.box[boxnumber][number] = false; //Setzt alle Werte der Box auf False also alle werte sind wieder verfügbar
			}
		}
		for (int colum = 0; colum < 9; colum++) {
			for (int row = 0; row < 9; row++) {
				this.colum[colum][row + 1] = false; //Setzt alle Werte der Spalte auf False also alle werte sind wieder verfügbar
				this.row[colum][row + 1] = false; //Setzt alle Werte der Zeile auf False also alle werte sind wieder verfügbar
				this.field[colum][row] = empty_field; //Setzt alle werte des Feldes auf Null
				if (!isClear(partfield[colum][row])) { // Wenn an dieser Stelle ein Fester Wert ist
					this.field[colum][row] = partfield[colum][row];
					this.colum[colum][partfield[colum][row]] = true;
					this.row[row][partfield[colum][row]] = true;
					this.box[getBox(colum, row)][partfield[colum][row]] = true;
				}
			}
		}
	}
	public boolean solve(int counter) { //Solver um zu überprüfen ob das Sudoku lösbar ist
		int colum = counter / 9;
		int row = counter % 9;

		for (int number = 1; number < 10; number++) { //For-Schleifen für alle Zahlen von 1-9
			if (possibleturn(colum, row, number)) { //Überprüfen ob der zug gültig ist
				boolean z = this.colum[colum][number]; //Zwischenspeichern des Zustands
				boolean s = this.row[row][number]; //Zwischenspeichern des Zustands
				boolean b = this.box[getBox(colum, row)][number]; //Zwischenspeichern des Zustands
				this.field[colum][row] = number; //Setzten der Nummer an der gewählten position im Array
				//Setzten der Werte auf True damit sie nicht nochmal verwendet werden
				this.colum[colum][number] = true; 
				this.row[row][number] = true;
				this.box[getBox(colum, row)][number] = true;
				if (counter < 80) { //
					if (solve(counter + 1)) {
						return true; //Zurückgeben des Wertes True weil das Sudoku lösbar ist
					} else {
						this.field[colum][row] = partfield[colum][row];
						this.colum[colum][number] = z;
						this.row[row][number] = s;
						this.box[getBox(colum, row)][number] = b;
					}
				} else {
					return true; //Zurückgeben des Wertes True weil das Sudoku lösbar ist
				}
			}
		}
		return false; //Zurückgeben des Wertes False weil das Sudoku nicht lösbar ist
	}
	public void genSudoku() { //Erstellen des Sudokus
		do {
			for (int colum = 0; colum < partfield.length; colum++) {
				for (int row = 0; row < partfield[colum].length; row++) {
					partfield[colum][row] = empty_field; //Setzt alle felder des temporären Arrays auf das leere Feld
				}
			}
			start(); //Führt die Start sequenz erneuert aus
			for (int i = 0; i <= fillednumbers; i++) { //for-schleife zum erzeugen der zahlen im array.
				int colum = (int) (Math.random() * 9); //Zufälliges auswählen der Spalte
				int row = (int) (Math.random() * 9); //Zufälliges auswählen der Zeile
				int number = 1 + (int) (Math.random() * 9); ////Zufällsiges auswählen der einzutragenden Nummber
				if (possibleturn(colum, row, number)) { //Überprüfung ob der Zug überhaupt gültig ist
					this.field[colum][row] = number; //Eintragen der Nummer in das Array and der gewählten stelle
					this.colum[colum][number] = true; //Setzen des Wertes der gewählten zahl in der Spalte damit sie nicht nochmal dort drinne vorkommt
					this.row[row][number] = true; //Setzen des Wertes der gewählten zahl in der Zeile damit sie nicht nochmal dort drinne vorkommt
					this.box[getBox(colum, row)][number] = true; //Setzen des Wertes der gewählten zahl in der Box damit sie nicht nochmal dort drinne vorkommt
					partfield[colum][row] = number; //Eintragen der Nummer in das vorübergehende Array
				}
			}
			start(); //Führt die Start sequenz erneuert aus
		} while (!solve(0)); //Erstellt solange Arrays bis es einen Lösung für das erstellte Array gibt
		copy_solved_sudoku(); //Kopiert das Feld wenn es gelöst werden kann
		start(); //Führt die Start sequenz erneuert aus
	}
	private boolean possibleturn(int colum, int row, int number) { //Überprüft ob die ausgewählten zahlen schon gesetzt worden oder schon in der Zeile/Spalte/Box vorhanden sind
		return (partfield[colum][row] == number || isClear(partfield[colum][row])
				&& !this.colum[colum][number]
				&& !this.row[row][number]
				&& !this.box[getBox(colum, row)][number]);
	}
	private void copy_solved_sudoku(){ //Kopiert das gelöste Feld in ein neues Array das später ausgelesen werden kann
		for (int colum = 0; colum < 9; colum++) {
			for (int row = 0; row < 9; row++) {
				solvedfield[colum][row] =field[colum][row]; //Kopieren des Arrays
			}
		}
	}
	private boolean isClear(int number) {
		return number <= 0 || number > 9;
	}
	private int getBox(int colum, int row) {
		return 3 * (colum / 3) + (row / 3);
	}
	public int[][] getsolvedfield(){ //Returned das gelöste Feld
		return solvedfield;
	}
	public int[][] getfield(){ //Returned das ungelöste Feld
		return field;
	}
}
