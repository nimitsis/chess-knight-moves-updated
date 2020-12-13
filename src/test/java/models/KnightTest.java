package models;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import models.ChessCell;
import models.Knight;

public class KnightTest {

	private static final List<Integer> CORRECTCOORDS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
	
	int xCoord;
	int yCoord;
	ChessCell currentPosition;
	
	@Before
	public void setup () {
		
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(CORRECTCOORDS.size());
		xCoord = CORRECTCOORDS.get(index);
		index = randomGenerator.nextInt(CORRECTCOORDS.size());
		yCoord = CORRECTCOORDS.get(index);
		currentPosition = ChessCell.getChessCell(xCoord, yCoord);
//		System.out.println(currentPosition.toString());
		
	}
	
	@Test
	public void knightNextStepsTest () {
		
		Knight knight = new Knight (currentPosition);
		System.out.println(" ******** NEXT POSIBLE MOVES ******** : from position: " + currentPosition.toString() + " of color: " + currentPosition.getCellColor());
		knight.possibleMoves().stream().forEach( x -> System.out.println(x.toString() + " " + x.getCellColor()));
		
		assertTrue( knight.possibleMoves().size() > 1 );
	}
	
}
