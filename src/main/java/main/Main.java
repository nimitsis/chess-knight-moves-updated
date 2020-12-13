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
		
		ChessPiece piece = new Knight(startCell);
		ChessPaths solution = PathFinder.findAll(piece, endCell, remainingMoves);
		
		printSolutions(solution, startCell, endCell, remainingMoves);

	}

	private static void printSolutions(ChessPaths solution, ChessCell start, ChessCell end, int remainingMoves) {
		System.out.println("All paths so that the Knight from " + start + " to reach the " + end + " at the most " + remainingMoves +" moves");
		if (solution.getPaths().isEmpty() ) {
			System.out.println("No solution found");
		}
		System.out.println(solution.toString().replace('|', '\n'));
	}


}
