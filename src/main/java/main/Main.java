package main;

import models.ChessCell;
import models.ChessPiece;
import models.Knight;
import paths.ChessPaths;
import util.Utilities;

public class Main {

	public static void main (String [] args) {
		
		ChessCell startCell = null;
		ChessCell endCell = null;
		int remainingMoves = 3;
		// Validate input arguments and initialize starting and ending position  
		try {
			if (args.length != 2) {
				throw new IllegalArgumentException("Wrong number of arguments :" + args.length);
			}
			startCell = Utilities.argsToChessCell(args[0]);
			endCell = Utilities.argsToChessCell(args[1]);
		} catch (IllegalArgumentException ms) {
			ms.printStackTrace();
			return;
		} 
		
		// Initialize the piece
		ChessPiece piece = new Knight(startCell);
		// ChessPaths solution = PathFinder.findAll(piece, endCell, remainingMoves);
		// Or someone may use the static implementation of the algorythm
		ChessPaths solution = PathFinderWithStaticChessPaths.findAll(piece, endCell, remainingMoves);
		
		// Print problem's solutions, if any
		Utilities.printSolutions(solution, startCell, endCell, remainingMoves);

	}

}
