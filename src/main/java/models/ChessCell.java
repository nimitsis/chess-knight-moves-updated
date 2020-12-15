package models;

import java.util.Objects;

/**
 * 
 * @author nmitsis
 * ChessCell is any cell where 
 * x coord is 1<= x<= 8
 * y coord is 1<=y<=8
 * 
 */

public class ChessCell implements Cell {
 
	private final int x;
	private final int y;
	private CellColor cellColor;
	private boolean visited = false; //property that keep track  if the cell is already visited
	
	private ChessCell(int x, int y) {
		this.x = x;
		this.y = y;
		this.cellColor = calcCellColor(x, y);
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	/**
	 * Method that calculates the color of a cell
	 * @param x
	 * @param y
	 * @return
	 */
	private CellColor calcCellColor(int x, int y) {
		return (x+y) % 2 == 0 ? CellColor.BLACK : CellColor.WHITE; 
	}

	public CellColor getCellColor() {
		return cellColor;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * This method returns the Chess Cell notation format
	 */
	@Override
	public String toString () {
		return CellLetter.values()[this.getX() -1 ].toString().concat(String.valueOf(this.getY()));
	}

	/**
	 * Method that returns a new ChessCell if x, y arguments are valid chess board points
	 * @param x
	 * @param y
	 * @return
	 */
	public static ChessCell getChessCell (int x, int y) {
		return isValidCell(x, y) ? new ChessCell(x, y) : null;
	}
	
	/**
	 * Method that checks if a given cell is valid
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean isValidCell (int x, int y) {
		return  (x < 1 || x > 8  || y < 1 || y > 8 ) ? false : true; 		
	}
	
	/**
	 * Method that checks if 2 cells are equal
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static boolean isEqual (ChessCell c1, ChessCell c2) {
		return c1.getX() == c2.getX() && c1.getY() == c2.getY();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessCell other = (ChessCell) obj;
		return x == other.x && y == other.y;
	}

}
