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
	
	private static ChessPaths findPath(ChessPaths visitedPaths, ChessCell currentPosition,  ChessCell targetPosition,
						ChessPath currentPath, int remainingMoves) {
		
		ChessPaths newPaths = new ChessPaths(visitedPaths.getPaths());
		List<ChessPath> chessPathList = newPaths.getPaths();		
		ChessPath path = new ChessPath(currentPath.getCells());
		path.getCells().add(currentPosition); 
		
		if (! currentPosition.equals(targetPosition)) { 	
			if (remainingMoves > 0) {

				// Check all path according to the remaining possible moves
				ChessPiece piece = new Knight(currentPosition);
				List<ChessPath> allPaths = piece.possibleMoves().stream().map(currentCell -> {
					ChessPaths knightPaths = findPath(newPaths, currentCell, targetPosition, path, remainingMoves-1 );
					return knightPaths.getPaths();
				}).flatMap(List::stream).distinct().collect(Collectors.toList()); 

				chessPathList.addAll(allPaths); 
			}
		}
		else {
			chessPathList.add(path); 
		}

		return new ChessPaths(chessPathList);
	}
	
	public static ChessPaths findAll ( ChessCell startCell, ChessCell targetPosition, int remainingMoves ) {
		
		ChessPaths paths = new ChessPaths(new ArrayList<>());
		ChessPath currentPath = new ChessPath(new ArrayList<>());
		paths = findPath(paths, startCell, targetPosition, currentPath, remainingMoves);
		return paths;
	}
	
}
