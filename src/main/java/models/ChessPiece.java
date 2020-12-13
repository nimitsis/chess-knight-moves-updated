package models;

import java.util.List;

public interface ChessPiece {

	public List<ChessCell> possibleMoves();
}
