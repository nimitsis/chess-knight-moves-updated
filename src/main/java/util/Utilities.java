package util;

import models.CellLetter;
import models.ChessCell;
import paths.ChessPaths;

public class Utilities {

	private Utilities() {}
	
	public static ChessCell argsToChessCell(String inputArg) {
		
		// Checks if the input argument length is correct 
		if (inputArg.length() != 2 ) {
			throw new IllegalArgumentException("Wrong argument " + inputArg);
		}
		
		// Checks if the input argument has a valid chess letter as x Coord
		String xCoordStr= String.valueOf(inputArg.toUpperCase().charAt(0));
		int chessChar = (int) xCoordStr.charAt(0);
		if (chessChar < 65 || chessChar > 72) {
			throw new IllegalArgumentException("Wrong argument "+ inputArg);
		}
		int xCoord = CellLetter.valueOf(xCoordStr).ordinal() + 1;
		
		// Checks if the input argument has a valid number as u Coord
		String yCoordStr = String.valueOf(inputArg.toUpperCase().charAt(1));
		int yInt = yCoordStr.charAt(0);
		if ( yInt < 49 || yInt > 56 ) {
			throw new IllegalArgumentException("Wrong argument "+ inputArg);
		}
		int yCoord = Integer.parseInt(yCoordStr);
	
		return ChessCell.getChessCell(xCoord, yCoord);
	}
	
	public static void printSolutions(ChessPaths solution, ChessCell start, ChessCell end, int remainingMoves) {
		System.out.println("All paths so that the Knight from " + start + " to reach the " + end + " at the most " + remainingMoves +" moves");
		if (solution.getPaths().isEmpty() ) {
			System.out.println("No solution found");
		}
		System.out.println(solution.toString().replace('|', '\n'));
		
		System.out.println("The shortest path is: " + solution.shortestPath() );
	}

	
}
