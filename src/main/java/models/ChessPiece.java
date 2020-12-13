package models;

import java.util.List;

public interface ChessPiece {

//	public List<ChessCell> possibleMoves(ChessCell currentCell);
	public List<ChessCell> possibleMoves(List<ChessCell> unavailable);
}
