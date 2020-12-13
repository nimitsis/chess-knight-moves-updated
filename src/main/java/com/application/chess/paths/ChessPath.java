package com.application.chess.paths;

import java.util.List;
import java.util.stream.Collectors;

import com.application.chess.models.ChessCell;

public class ChessPath {

	private final List<ChessCell> cells;
	
	public ChessPath( List<ChessCell> cells) {
		this.cells = cells;
	}

	public List<ChessCell> getCells() {
		return cells;
	}
	
	public void addCell(ChessCell cell) {
		this.cells.add(cell);
	}
	
	public ChessPath getClone() {
		return new ChessPath(cells.stream().map(cell -> cell).collect(Collectors.toList()));
	}
	
	@Override
	public String toString() {
		return String.join(", ", cells.stream().map(cell -> cell.toString()).collect(Collectors.toList()));
	}
	
}
