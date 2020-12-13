package models;

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
	private boolean visited = false;
	
	private ChessCell(int x, int y) {
//		if (isValidCell(x, y)) {
//			throw new IllegalArgumentException("(x, y) coordinates of chess cell should be between [1-8]");
//		}
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
	
	public static boolean isValidCell (int x, int y) {
		return  (x < 1 || x > 8  || y < 1 || y > 8 ) ? false : true; 		
	}
	
	public static boolean isEqual (ChessCell c1, ChessCell c2) {
		return c1.getX() == c2.getX() && c1.getY() == c2.getY();
	}

}
