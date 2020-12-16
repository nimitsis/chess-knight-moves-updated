package paths;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import models.ChessCell;

public class ChessPath {

	private final List<ChessCell> cells;
	
	// public ChessPath( List<ChessCell> cells) {
	// 	this.cells = cells;
	// }
	public ChessPath(List<ChessCell> cells) {
		this.cells = new ArrayList<>(cells);  // avoid the list to be change from someone else and change my state also , also remove the clone useless
	}

	public List<ChessCell> getCells() {
		return cells;
		//		return Collections.unmodifiableList(cells);	//do not permits add and remove 
	}
	
	// public void addCell(ChessCell cell) {
	// 	this.cells.add(cell);
	// }
	
	// public ChessPath getClone() {
	// 	return new ChessPath(cells.stream().map(cell -> cell).collect(Collectors.toList()));

//		return new ChessPath(cells)// George suggestion

	// }
	
	@Override
	public String toString() {
		return String.join(" , ", cells.stream().map(ChessCell::toString).collect(Collectors.toList()));
	}
	
}
