package models;

/**
 * 
 * @author nmitsis
 *
 * This class is a general implementation for Cell
 * not oriented to Chess
 */
public class GeneralCell implements Cell {

	private final int x;
	private final int y;
	
	private GeneralCell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public static GeneralCell newGeneralCell(int x , int y) {
		return new GeneralCell (x, y);
	}

}
