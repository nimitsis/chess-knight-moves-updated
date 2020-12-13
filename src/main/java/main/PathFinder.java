package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.ChessCell;
import models.ChessPiece;
import models.Knight;
import paths.ChessPath;
import paths.ChessPaths;

public class PathFinder {
	
	
	private PathFinder() {}
	
	private static ChessPaths findKnightPath(ChessPaths visitedPaths, ChessCell currentPosition,  ChessCell targetPosition,
						ChessPath currentPath, int remainingMoves) {
		
		ChessPaths visitedPathsClone = visitedPaths.getClone(); //Cloning list in order to avoid children' s adding paths that do not reach the destination 
		List<ChessPath> chessPathList = visitedPathsClone.getPaths();
		
		ChessPath path = currentPath.getClone();
		path.addCell(currentPosition);
		
		if (! ChessCell.isEqual(currentPosition, targetPosition)) { // currentPosition != targetPosition
			if (remainingMoves > 0) {
				// Check all path according to the remaining possible moves
				Knight newKnight = new Knight(currentPosition);
				List<ChessPath> allPaths = newKnight.possibleMoves().stream().map(currentCell -> {
					ChessPaths knightPaths = findKnightPath(visitedPathsClone, currentCell, targetPosition, path, remainingMoves-1 );
					return knightPaths.getPaths();
				}).flatMap(List::stream).distinct().collect(Collectors.toList());

				chessPathList.addAll(allPaths);
			}
		}
		else {
			chessPathList.add(path); // adds the path if the currentPosition == targetPosition
		}

		return new ChessPaths(chessPathList); // Finally all paths that resolve the issue
	}
	
	public static ChessPaths findAll ( ChessPiece piece, ChessCell targetPosition, int remainingMoves ) {
		
		ChessPaths paths = new ChessPaths(new ArrayList<>());
		ChessPath currentPath = new ChessPath(new ArrayList<>());
		
		if ( piece instanceof Knight) {
			paths = findKnightPath(paths, ((Knight) piece).getCurrentCell(), targetPosition, currentPath, remainingMoves);
		}
		if (paths.getPaths().isEmpty()) {
			System.out.println("No solution found");
		}
		
		return paths;
	}
	
}
