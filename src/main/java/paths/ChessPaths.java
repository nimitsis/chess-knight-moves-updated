package paths;

import java.util.List;
import java.util.stream.Collectors;

public class ChessPaths {

	List<ChessPath> paths;
	
	public ChessPaths ( List<ChessPath> paths ) {
		this.paths = paths;
	}
		
	public List<ChessPath> getPaths() {
		return this.paths;
	}
	
	public void addPath(ChessPath path) {
		this.paths.add(path);
	}
	
	public ChessPath shortestPath () {
		// this should return the shortest..
		return null;
	}
	
	public ChessPaths getClone() {
		return new ChessPaths(paths.stream().map(path -> path).collect(Collectors.toList()));
	}
	
	@Override
	public String toString() {
		return String.join(" || ", paths.stream().map(ChessPath::toString).collect(Collectors.toList()));
	}
}
