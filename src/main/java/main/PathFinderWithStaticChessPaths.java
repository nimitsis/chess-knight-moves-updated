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
	
	private static void findKnightPath(ChessCell currentPosition,  ChessCell targetPosition, ChessPath currentPath, int remainingMoves) {
        
        ChessPath path = new ChessPath(currentPath.getCells());
        // ChessPath path = currentPath.getClone();
        path.getCells().add(currentPosition);
		// path.addCell(currentPosition);
		
		if (! ChessCell.isEqual(currentPosition, targetPosition)) {
			if (remainingMoves > 0) {
				
				Knight newKnight = new Knight(currentPosition);
				newKnight.possibleMoves().forEach(currentCell -> {
					findKnightPath(currentCell, targetPosition, path, remainingMoves-1 );
				});	
			}
		}
		else {
			paths.getPaths().add(path);
		}
		
	}
	
	public static ChessPaths findAll ( ChessPiece piece, ChessCell targetPosition, int remainingMoves ) {
		
		paths = new ChessPaths(new ArrayList<>());
		ChessPath currentPath = new ChessPath(new ArrayList<>());
		
		if ( piece instanceof Knight) {
			findKnightPath(((Knight) piece).getCurrentCell(), targetPosition, currentPath, remainingMoves);
		}
		if (paths.getPaths().isEmpty()) {
			System.out.println("No solution found");
		}
		
		return paths;
	}    
}
