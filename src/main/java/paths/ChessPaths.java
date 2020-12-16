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
		// this.paths = paths;
		this.paths = new ArrayList<>(paths);
	}
		
	public List<ChessPath> getPaths() {
		return this.paths;
	}
	
	// public void addPath(ChessPath path) {
	// 	this.paths.add(path);
	// }

	// public ChessPaths getClone() {
	// 	return new ChessPaths(paths.stream().map(path -> path).collect(Collectors.toList()));

	//		return new ChessPaths(paths)

	// }
	
	@Override
	public String toString() {
		return String.join("|", paths.stream().map(ChessPath::toString).collect(Collectors.toList()));
	}
}
