package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CellLetterTest {

	String a = "A";
	String f = "F";
	String w = "W";
	
	@Test 
	public void testLetterA () {
		CellLetter testA = CellLetter.valueOf("A");
		assertEquals(a, testA.toString());	
	}
	
	@Test
	public void testLeterF () {
		CellLetter testF = CellLetter.valueOf(f); 
		assertEquals(f, testF.toString());
	}
	
	@Test ( expected = IllegalArgumentException.class)
	public void testLetterW () {
		CellLetter testW = CellLetter.valueOf(w);
		assertEquals(w, testW.toString());
	}
	
	
	
}
