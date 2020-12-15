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
	 public static final List<Integer> PATHSIZESPERTESTCASE = new ArrayList<> (Arrays.asList(3 , 6, 2, 0)); 
	
	@Before
	public void steup () {
	
		start = ChessCell.getChessCell(1, 1);
		target = ChessCell.getChessCell(2, 3);
		knight = new Knight(start);
		
	}
	
	@Test
	public void test1 () {
		ChessPaths paths = PathFinder.findAll(knight, target, 3);
		System.out.println(paths);
		assertEquals(paths.getPaths().size(), (int)PATHSIZESPERTESTCASE.get(0));
		
	}
	
	@Test
	public void test2 () {
		start = ChessCell.getChessCell(6, 4);
		target = ChessCell.getChessCell(5, 8);
		knight = new Knight(start);
		ChessPaths paths = PathFinder.findAll(knight, target, 3);
		System.out.println(paths);
		assertEquals(paths.getPaths().size(), (int)PATHSIZESPERTESTCASE.get(1));
	}
	
	@Test
	public void test3 () {
		start = ChessCell.getChessCell(6, 4);
		target = ChessCell.getChessCell(5, 3);
		knight = new Knight(start);
		ChessPaths paths = PathFinder.findAll(knight, target, 2);
		if (paths.getPaths().isEmpty() ) {
			System.out.println("No solution found");
		}
		System.out.println(paths);
		assertEquals(paths.getPaths().size(), (int)PATHSIZESPERTESTCASE.get(2));
	}

	@Test
	public void test4 () {
		start = ChessCell.getChessCell(1, 1);
		target = ChessCell.getChessCell(2, 2);
		knight = new Knight(start);
		ChessPaths paths = PathFinder.findAll(knight, target, 2);
		if (paths.getPaths().isEmpty() ) {
			System.out.println("No solution found");
		}
		System.out.println(paths);
		assertEquals(paths.getPaths().size(), (int)PATHSIZESPERTESTCASE.get(3));
	}
	
}
