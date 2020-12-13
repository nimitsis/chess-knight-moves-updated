package com.application.chess.models;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CellTest {

	int xCoord;
	int yCoord;
	Cell testCell;
	
	@Before
	public void setup() {
		xCoord = 10;
		yCoord = 12;
		testCell = GeneralCell.newGeneralCell(xCoord, yCoord) ;
	}
	
	@Test
	public void testXCoord() {
		assertTrue("X coordination is: " + xCoord, testCell.getX() == xCoord);
	}
	
	@Test
	public void testYCoord() {
		assertTrue("Y coordination is:" + yCoord, testCell.getY() == yCoord);
	}
	
}
