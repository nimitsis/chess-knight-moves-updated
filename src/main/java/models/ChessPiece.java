package models;

import java.util.Collection;

public interface ChessPiece {
	Collection<ChessCell> possibleMoves();
}
