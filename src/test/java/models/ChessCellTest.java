package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import models.CellColor;
import models.ChessCell;

public class ChessCellTest {
	
	private static final List<Integer> CORRECTCOORDS = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
	int wrongCoord = 12;
	int xCoord;
	int yCoord;
	int blackXCoord = 7;
	int blackYCoord = 3;
	String blackCellLetterCoord = "G3";
	int whiteXCoord = 4;
	int whiteYCoord = 5;
	String whiteCellLetterCoord = "D5";
	
	ChessCell cell;
	@Before
	public void setup() {
		
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(CORRECTCOORDS.size());
		xCoord = CORRECTCOORDS.get(index);
		index = randomGenerator.nextInt(CORRECTCOORDS.size());
		yCoord = CORRECTCOORDS.get(index);
		cell = ChessCell.getChessCell(xCoord, yCoord);
		
	}
	
	@Test
	public void testXCoord () {
		assertTrue("X coordination is: " + xCoord, cell.getX() == xCoord);
	}
	
	@Test
	public void testYCoord() {
		assertTrue("Y coordination is:" + yCoord, cell.getY() == yCoord);
	}
	
//	@Test ( expected = IllegalArgumentException.class)
	@Test
	public void testXCoordException () {
		xCoord = wrongCoord;
		cell = ChessCell.getChessCell(xCoord, yCoord);
//		assertTrue("X coordination is: " + xCoord, cell.getX() == xCoord);
		assertTrue("X coordination is: " + xCoord, cell == null);
	}
	
//	@Test ( expected = IllegalArgumentException.class)
	@Test
	public void testYCoordException () {
		yCoord = wrongCoord;
		cell = ChessCell.getChessCell(xCoord, yCoord);
		assertTrue("Y coordination is: " + yCoord, cell == null);
	}
	
	@Test
	public void testBlackCellColor () {
		cell = ChessCell.getChessCell(blackXCoord, blackYCoord);
		assertEquals(CellColor.BLACK, cell.getCellColor());
	}
	
	@Test
	public void testWhiteCellColor () {
		cell = ChessCell.getChessCell(whiteXCoord, whiteYCoord);
		assertEquals(CellColor.WHITE, cell.getCellColor());
	}
	
	@Test
	public void testLetterRepresentationOfWhiteCell () {
		System.out.println(cell.getX() + " , " + cell.getY() + " = " + cell.toString() + " IS " + cell.getCellColor());
		
		cell = ChessCell.getChessCell(whiteXCoord, whiteYCoord);
		assertEquals(whiteCellLetterCoord, cell.toString());
	}
	
	@Test
	public void testLetterRepresentationOfBlackCell () {
		cell = ChessCell.getChessCell(blackXCoord, blackYCoord);
		assertEquals(blackCellLetterCoord, cell.toString());
	}

	@Test
	public void checkIsEqual() {
		ChessCell t1 = ChessCell.getChessCell(4, 4);
		ChessCell t2 = ChessCell.getChessCell(4, 4);
		ChessCell t3 = t1;
		
		boolean testIsEquals  = ChessCell.isEqual(t1, t2);
		assertEquals(true, testIsEquals);
		
		
		boolean testEquals = t1.equals(t2);
//		assertEquals(false, testEquals);	//If equals and hashcode has not been implemented
		assertEquals(true, testEquals);	//If equals and hashcode has been implemented
		
		boolean testEquals2 = t1.equals(t3);
		assertEquals(true, testEquals2);
	}
	
}
