package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Knight implements ChessPiece {
	
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
	
//	public List<ChessCell> moves(ChessCell currentCell) { // if null the it gets the this.current ChessCell
	public List<ChessCell> possibleMoves(List<ChessCell> unavailable) {
//		if (currentCell == null) {
//			currentCell = this.getCurrentCell();
//		}
		
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
