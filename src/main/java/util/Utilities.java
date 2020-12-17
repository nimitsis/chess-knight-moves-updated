package util;

import models.CellLetter;
import models.ChessCell;
import paths.ChessPath;
import paths.ChessPaths;

public class Utilities {

	private Utilities() {}
	
	/**
	 * Evaluates if the inputArgument is valid and if so it converts the input String to a ChessCell 
	 * @param inputArg
	 * @return
	 */
	public static ChessCell argsToChessCell(String inputArg) {
		
		// Checks if the input argument length is correct 
		if (inputArg.length() != 2 ) {
			throw new IllegalArgumentException("Wrong argument " + inputArg);
		}
		
		// Checks if the input argument has a valid chess letter as x Coord
		String xCoordStr= String.valueOf(inputArg.toUpperCase().charAt(0));
		int xCoord = -1;
		try {
			xCoord = CellLetter.valueOf(xCoordStr).ordinal() + 1;
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Wrong argument "+ inputArg);
		}

		String yCoordStr = String.valueOf(inputArg.toUpperCase().charAt(1));
		 int yInt = yCoordStr.charAt(0);
		 if ( yInt < 49 || yInt > 56 ) {
		 	throw new IllegalArgumentException("Wrong argument "+ inputArg);
		 }
		 int yCoord = Integer.parseInt(yCoordStr);
	
		return ChessCell.getChessCell(xCoord, yCoord);
	}
	
	/**
	 * This methods is just to display the results
	 * @param solution
	 * @param start
	 * @param end
	 * @param remainingMoves
	 */
	public static void printSolutions(ChessPaths solution, ChessCell start, ChessCell end, int remainingMoves) {
		System.out.println("All paths so that the Knight from " + start + " to reach the " + end + " at the most " + remainingMoves +" moves");
		if (solution.getPaths().isEmpty() ) {
			System.out.println("No solution found");
		}
		else { 
			System.out.println(solution.toString().replace('|', '\n'));
			System.out.println("A shortest path is: " + shortestPath(solution, remainingMoves));
		}
	}
	
	private static ChessPath shortestPath (ChessPaths availablePaths, int remainingMoves) {
		
		int height = remainingMoves+2;
		ChessPath shortest = null;
		for (ChessPath p : availablePaths.getPaths()) {
			if(p.getCells().size() < height ) {
				shortest = p;
				height = p.getCells().size();
			}
		}

		return shortest;
		
	}
	
}
