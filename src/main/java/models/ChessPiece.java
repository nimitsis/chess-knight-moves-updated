package models;

import java.util.Collection;
// import java.util.List 	;

public interface ChessPiece {

	public Collection<ChessCell> possibleMoves();
}
