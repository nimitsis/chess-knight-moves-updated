package main;

import models.ChessCell;

public class Main {

	public static void main (String [] args) {
		
		//improvement, give arguments like start=... end=...
		// The following line of codes just verify the correction of input arguments 
		String startingCellStr = args[0];	
		String endingCellStr = args[1];
		
		if (startingCellStr.length() > 2 || startingCellStr.length() < 1 || endingCellStr.length() > 2 || endingCellStr.length() < 1 ) {
			System.out.println("Wrong input arguments...");
			return;
		}
		
		int startingPointLetter = (int)startingCellStr.toUpperCase().charAt(0);
		if ( !( startingPointLetter >= 65 || startingPointLetter <= 72 )) {
			System.out.println("Not a cell point");
			return;
		}
		
		int startingInt = startingCellStr.charAt(1);
		if ( ! (startingInt < 1 || startingInt > 8 ) ) {
			System.out.println("Not a valid");
			return;
		}
		
		int endingPointLetter = (int) endingCellStr.toUpperCase().charAt(0);
		if ( !(endingPointLetter >= 65 || endingPointLetter <= 72)) {
			System.out.println("Not a cell point");
			return;
		}
		
		int endingInt = endingCellStr.charAt(1);
		if ( ! (endingInt < 1 || endingInt > 8 ) ) {
			System.out.println("Not a valid");
			return;
		}
		
		
		ChessCell startingCell = ChessCell.getChessCell(startingPointLetter, startingInt);
		ChessCell endingCell = ChessCell.getChessCell(endingPointLetter, endingInt);
		
		System.out.println("Start point: " + startingCell.toString());
		System.out.println("Start point: " + endingCell.toString());
		
		
		/* 
		 * 1. Set arguments to .jar
		 * https://stackoverflow.com/questions/456636/how-do-i-pass-parameters-to-a-jar-file-at-the-time-of-execution
		 * 2. make a jar executable  (java no main manifest attribute in jar)
		 * https://stackoverflow.com/questions/9689793/cant-execute-jar-file-no-main-manifest-attribute
		 */
		
	}
}
