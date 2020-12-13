package com.application.chess.main;

import org.junit.Before;
import org.junit.Test;

import com.application.chess.models.ChessCell;
import com.application.chess.models.Knight;
import com.application.chess.paths.ChessPaths;

public class PathFinderTest {

	 Knight knight;
	 ChessCell start;
	 ChessCell target;
	
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
	}
	
	@Test
	public void test2 () {
		start = ChessCell.getChessCell(6, 4);
		target = ChessCell.getChessCell(5, 8);
		knight = new Knight(start);
		ChessPaths paths = PathFinder.findAll(knight, target, 3);
		System.out.println(paths);
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
	}
	
}
