package com.application.chess.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.application.chess.models.ChessCell;
import com.application.chess.models.ChessPiece;
import com.application.chess.models.Knight;
import com.application.chess.paths.ChessPath;
import com.application.chess.paths.ChessPaths;

public class PathFinder {
	
	
	private PathFinder() {}
	
	private static ChessPaths findKnightPath(ChessPaths currentPaths, ChessCell currentPosition,  ChessCell targetPosition,
						ChessPath currentPath, List<ChessCell> unavailableCells , int remainingMoves) {
		ChessPaths currentPathsClone = currentPaths.getClone();
		List<ChessPath> chessPathList = currentPathsClone.getPaths();
		
		ChessPath path = currentPath.getClone();
		path.addCell(currentPosition);
		
		if (! ChessCell.isEqual(currentPosition, targetPosition)) {
			if (remainingMoves > 0) {
				unavailableCells.add(currentPosition);
				
				Knight newKnight = new Knight(currentPosition);
				List<ChessPath> allPaths = newKnight.possibleMoves(unavailableCells).stream().map(currentCell -> {
					ChessPaths knightPaths = findKnightPath(currentPathsClone, currentCell, targetPosition, path, unavailableCells, remainingMoves-1 );
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
	
	public static ChessPaths findAll ( ChessPiece piece, ChessCell targetPosition, int remainingMoves ) {
		
		ChessPaths paths = new ChessPaths(new ArrayList<>());
		ChessPath currentPath = new ChessPath(new ArrayList<>());
		
		if ( piece instanceof Knight) {
			paths = findKnightPath(paths, ((Knight) piece).getCurrentCell(), targetPosition, currentPath, new ArrayList<>(), remainingMoves);
		}
		if (paths.getPaths().isEmpty()) {
			System.out.println("No solution found");
		}
		
		return paths;
	}
	
}
