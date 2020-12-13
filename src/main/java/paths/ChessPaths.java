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
		this.paths = paths;
	}
		
	public List<ChessPath> getPaths() {
		return this.paths;
	}
	
	public void addPath(ChessPath path) {
		this.paths.add(path);
	}
	
	/**
	 * Finds the shortest path among all paths
	 * @return
	 */
	public ChessPath shortestPath () {
		// this should return the shortest..
		Map<Integer, List<ChessPath>> pathsDictionary = new HashMap <> ();
		for (int i = 0 ; i < paths.size() ; i++) {
			Integer keySize = (int) paths.get(i).getCells().stream().count();
			if (!pathsDictionary.containsKey(keySize)) {
				List<ChessPath> n = new ArrayList<> ();
				pathsDictionary.put(keySize, n);
			}
			pathsDictionary.get(keySize).add(paths.get(i));
		}
		List<Integer> l = new ArrayList<> (pathsDictionary.keySet());
		Collections.sort(l);
		int smallestKey = l.get(0);
		if (smallestKey != 0) {
			return pathsDictionary.get(smallestKey).get(0);
		}
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
