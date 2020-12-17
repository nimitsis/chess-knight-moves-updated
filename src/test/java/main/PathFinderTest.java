package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.PathFinder;
import models.ChessCell;
import models.Knight;
import paths.ChessPaths;

public class PathFinderTest {

	 Knight knight;
	 ChessCell start;
	 ChessCell target;
	 public static final List<Integer> PATHSIZESPERTESTCASE = new ArrayList<> (Arrays.asList(3 , 6, 2, 0, 9)); 
	
	@Before
	public void steup () {
		start = ChessCell.getChessCell(1, 1);
		target = ChessCell.getChessCell(2, 3);
	}
	
	@Test
	public void testFromA1toB3 () {
		ChessPaths paths = PathFinder.findAll(start, target, 3);
		System.out.println(paths);
		assertEquals(paths.getPaths().size(), (int)PATHSIZESPERTESTCASE.get(0));
		
	}
	
	@Test
	public void testFromF4ToE8 () {
		start = ChessCell.getChessCell(6, 4);
		target = ChessCell.getChessCell(5, 8);
		ChessPaths paths = PathFinder.findAll(start, target, 3);
		System.out.println(paths);
		assertEquals(paths.getPaths().size(), (int)PATHSIZESPERTESTCASE.get(1));
	}
	
	@Test
	public void testFromF4ToE3 () {
		start = ChessCell.getChessCell(6, 4);
		target = ChessCell.getChessCell(5, 3);
		ChessPaths paths = PathFinder.findAll(start, target, 3);
		if (paths.getPaths().isEmpty() ) {
			System.out.println("No solution found");
		}
		System.out.println(paths);
		assertEquals(paths.getPaths().size(), (int)PATHSIZESPERTESTCASE.get(2));
	}

	@Test
	public void testFromA1toB2 () {
		start = ChessCell.getChessCell(1, 1);
		target = ChessCell.getChessCell(2, 2);
		ChessPaths paths = PathFinder.findAll(start, target, 3);
		if (paths.getPaths().isEmpty() ) {
			System.out.println("No solution found");
		}
		System.out.println(paths);
		assertEquals(paths.getPaths().size(), (int)PATHSIZESPERTESTCASE.get(3));
	}
	
	@Test
	public void testFromC3ToF5 () {
		start = ChessCell.getChessCell(3, 3);
		target = ChessCell.getChessCell(6, 5);
		ChessPaths paths = PathFinder.findAll(start, target, 3);
		if (paths.getPaths().isEmpty() ) {
			System.out.println("No solution found");
		}
		System.out.println(paths);
		assertEquals(paths.getPaths().size(), (int)PATHSIZESPERTESTCASE.get(4));
	}

}
