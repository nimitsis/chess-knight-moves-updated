package com.application.chess.main;

import java.util.ArrayList;
import java.util.List;

import com.application.chess.models.ChessCell;
import com.application.chess.models.ChessPiece;
import com.application.chess.models.Knight;
import com.application.chess.paths.ChessPath;
import com.application.chess.paths.ChessPaths;

public class PathFinder {
	
	private static ChessPaths paths;
	
	private PathFinder() {}
	
	private static void findKnightPath(ChessCell currentPosition,  ChessCell targetPosition, ChessPath currentPath, List<ChessCell> unavailableCells , int remainingMoves) {
		
		ChessPath path = currentPath.getClone();
		path.addCell(currentPosition);
		
		if (! ChessCell.isEqual(currentPosition, targetPosition)) {
			if (remainingMoves > 0) {
				unavailableCells.add(currentPosition);
				
				Knight newKnight = new Knight(currentPosition);
				newKnight.possibleMoves(unavailableCells).forEach(currentCell -> {
					findKnightPath(currentCell, targetPosition, path, unavailableCells, remainingMoves-1 );
				});;		
			}
		}
		else {
			paths.addPath(path);
		}
		
	}
	
	public static ChessPaths findAll ( ChessPiece piece, ChessCell targetPosition, int remainingMoves ) {
		
		paths = new ChessPaths(new ArrayList<>());
		ChessPath currentPath = new ChessPath(new ArrayList<>());
		
		if ( piece instanceof Knight) {
			findKnightPath( ((Knight) piece).getCurrentCell(), targetPosition, currentPath, new ArrayList<>(), remainingMoves);
		}	
		if (paths.getPaths().isEmpty()) {
			System.out.println("No solution found");
		}
		
		return paths;
	}
	
}
