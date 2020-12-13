package paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChessPaths {

	List<ChessPath> paths;
//	Map<Integer, List<ChessPath>> pathsMap;
	
	public ChessPaths() {
		paths = new ArrayList<ChessPath> ();
//		pathsMap = new HashMap<> ();
	}
	
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
		for (int i = 0 ; i < paths.size() ; i++) {
			
		}
		System.out.println(paths.get(0).getCells().stream().count());
		System.out.println(paths.get(1).getCells().stream().count());

		return null;
	}
	
	public ChessPaths getClone() {
		return new ChessPaths(paths.stream().map(path -> path).collect(Collectors.toList()));
	}
	
	@Override
	public String toString() {
		return String.join("|", paths.stream().map(ChessPath::toString).collect(Collectors.toList()));
	}
}
