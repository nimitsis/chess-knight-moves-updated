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
		
		// ChessPaths visitedPathsClone = visitedPaths.getClone(); //Cloning list in order to avoid children' s adding paths that do not reach the destination 
		ChessPaths visitedPathsClone = new ChessPaths(visitedPaths.getPaths());
		List<ChessPath> chessPathList = visitedPathsClone.getPaths();
		
		// ChessPath path = currentPath.getClone();	//an den to clonopoihsw tote bazei ola ta current positions sto solution
		ChessPath path = new ChessPath(currentPath.getCells());

		// path.addCell(currentPosition);
		path.getCells().add(currentPosition); //A1 -> B3: 1h klhsh add(A1), 2h add(B3)
		
		// if (! ChessCell.isEqual(currentPosition, targetPosition)) { // currentPosition != targetPosition
		if (! currentPosition.equals(targetPosition)) { 	// currentPosition != targetPosition
			if (remainingMoves > 0) {
				// Check all path according to the remaining possible moves
				Knight newKnight = new Knight(currentPosition);
				List<ChessPath> allPaths = newKnight.possibleMoves().stream().map(currentCell -> {
					ChessPaths knightPaths = findKnightPath(visitedPathsClone, currentCell, targetPosition, path, remainingMoves-1 );
					return knightPaths.getPaths();
				}).flatMap(List::stream).distinct().collect(Collectors.toList()); // epistrefei mia lista apo olla ta 

				chessPathList.addAll(allPaths); // exoume exetasei es bathos ola ta paths bathous 3 enos enos  stouxeiou bathos 2 A1, C2, D4 , epestrepse oti soloutions exeis brei an exeis brei 
			}
		}
		else {
			chessPathList.add(path); // adds the path if the currentPosition == targetPosition
		}

		return new ChessPaths(chessPathList); // epistrefoume ola ta paths pou dinoun solution sto panw epipedo
	}
	
	public static ChessPaths findAll ( ChessPiece piece, ChessCell targetPosition, int remainingMoves ) {
		
		ChessPaths paths = new ChessPaths(new ArrayList<>());
		ChessPath currentPath = new ChessPath(new ArrayList<>());
		
		if ( piece instanceof Knight) {
			paths = findKnightPath(paths, ((Knight) piece).getCurrentCell(), targetPosition, currentPath, remainingMoves);
		}
		
		return paths;
	}
	
}
