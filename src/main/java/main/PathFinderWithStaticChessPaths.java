package main;

import java.util.ArrayList;

import models.ChessCell;
import models.ChessPiece;
import models.Knight;
import paths.ChessPath;
import paths.ChessPaths;

public class PathFinderWithStaticChessPaths {
	private static ChessPaths paths;
	
	private PathFinderWithStaticChessPaths() {}
	
	private static void findPath(ChessCell currentPosition,  ChessCell targetPosition, ChessPath currentPath, int remainingMoves) {
        
        ChessPath path = new ChessPath(currentPath.getCells());
        path.getCells().add(currentPosition);
		
		if (! ChessCell.isEqual(currentPosition, targetPosition)) {
			if (remainingMoves > 0) {	
				ChessPiece piece = new Knight(currentPosition);
				piece.possibleMoves().forEach(currentCell -> {
					findPath(currentCell, targetPosition, path, remainingMoves-1 );
				});	
			}
		}
		else {
			paths.getPaths().add(path);
		}
		
	}
	
	public static ChessPaths findAll ( ChessCell startCell, ChessCell targetPosition, int remainingMoves ) {
		
		paths = new ChessPaths(new ArrayList<>());
		ChessPath currentPath = new ChessPath(new ArrayList<>());
		findPath(startCell, targetPosition, currentPath, remainingMoves);
		
		return paths;
	}    
}
