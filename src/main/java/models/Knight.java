package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * This Class represents the Knight Entity
 * Contains the logic for the possible moves that
 * a Knight can do from the position that it is.
 */
public class Knight implements ChessPiece {
	
	// All the possible moves a Knight can do
	private static final List<GeneralCell> POSSIBLE_POSITIONS = new ArrayList<GeneralCell> (Arrays.asList( 
			GeneralCell.newGeneralCell(1, 2),
			GeneralCell.newGeneralCell(2, 1),
			GeneralCell.newGeneralCell(-1, 2),
			GeneralCell.newGeneralCell(-2, 1),
			GeneralCell.newGeneralCell(1, -2),
			GeneralCell.newGeneralCell(2, -1),
			GeneralCell.newGeneralCell(-1, -2),
			GeneralCell.newGeneralCell(-2, -1)
			));

	private ChessCell currentCell;
	private List<ChessCell> nextMoves = new ArrayList<ChessCell> ();
	
	public Knight ( ChessCell currentCell ) {
		this.currentCell = currentCell;
	}

	public ChessCell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(ChessCell currentCell) {
		this.currentCell = currentCell;
	}
	
	/**
	 * This method calculates the permitted moves of the Knight 
	 * against the current position
	 */
	
	public List<ChessCell> possibleMoves() {
		
		Iterator<GeneralCell> it = POSSIBLE_POSITIONS.iterator();
		
		while (it.hasNext()) {
			GeneralCell position = it.next();
			int xPosition = currentCell.getX() + position.getX();
			int yPosition = currentCell.getY() + position.getY();
			ChessCell newCell = ChessCell.getChessCell(xPosition , yPosition);
			if ( newCell != null ) {
				nextMoves.add(ChessCell.getChessCell(xPosition , yPosition));
			}
		}
				
		return nextMoves;
	}

}
