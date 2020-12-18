package paths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChessPaths {

	List<ChessPath> paths;

	public ChessPaths ( List<ChessPath> paths ) {
		this.paths = new ArrayList<>(paths);
	}
		
	public List<ChessPath> getPaths() {
		return this.paths;
	}

	@Override
	public String toString() {
		return String.join("|", paths.stream().map(ChessPath::toString).collect(Collectors.toList()));
	}
	
	public static ChessPath shortestPath (ChessPaths availablePaths, int remainingMoves) {
		
		int height = remainingMoves+2;
		ChessPath shortest = null;
		for (ChessPath p : availablePaths.getPaths()) {
			if(p.getCells().size() < height ) {
				shortest = p;
				height = p.getCells().size();
			}
		}
		return shortest;
	}
	
}
