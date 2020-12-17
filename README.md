# knight-moves

## Updates 

* Update the findAll and findPath (old findKnightPath) in order to be more generic and be able to find paths for other kind of pieces:

    * Pass as argument the starting position instead of Knight Piece
    * Initialize a Piece instead of Knight with Polymorphism. 
 
* Simplify the ChessPaths and ChessPath classes:

    * Remove getClone, and make proper use of ChessPaths/ ChessPath constructor in order to instantiate an new List<ChessPath>/ List<ChessCell
    * Remove addPath(), addPaths() methods and add element direct to the lists, by calling getCells() and getPaths()  

* remove public from the interfaces methods
* Update returned type of possibleMoves method in ChessPiece interface 
* Update the Utility argsToChessCell method in order to check the ChessLetter Enum instead of the ASCII codes
* Override the equals and hashcode in ChessCell and use equals instead of isEquals.
* Move shortestPath from ChessPaths to Utilities, make it static, and correct it 
* Resolve the print out issue.

## Program Execution

### From command line:

1. Navigate to the root directory of the project.
1. Give the following command:

``` 
mvn exec:java -Dexec.mainClass=main.Main -Dexec.args="startingPoint destinationPoint"
```

__`startingPoint`__ : the point that the knight is in the beggining, in a Chess notation format , example: A3

__`destinationPoint`__ : the point where the knight is trying to reach,  in a Chess notation format , example: A8

### From an IDE like eclipse: 

From Main Menu -> Run -> Run Configuration:

1. Create a new Java Application Configuration
1. Go to the Arguments tab and place the desired arguments in Program arguments text area, like "startingPoint destinationPoint". Example: `A3 A8`

## Improvements:

**The current implementation allows the Cell' s revisit . From a general point of view this is acceptable, since algorithm is requested to give the whole set of the posible paths. Thus a path A1 -> B3 -> C1 and a A1 -> B3 -> A1 -> B3 -> C1 are both accepted, if start cell is A1, the destination is C1, and the number of permitted moves larger than 4. However, from the preformance perspective this behavior is not optimal.

Things that can increase the algorithm' s efficiency :

* Make use of visited attribute of ChessCell, in order to avoid ChessCell revisit.
* Make use of Color ChessCell attribute. This could be used in order to recognize if there is any possible path to the destination, since:
  * If the color of destination cell is different from the beginning cell's color, then the knight can reach the target only through an odd number of moves
  * If destination and begining colors are the same the the target can be reached in even number of moves.
  * Thus, for example if the remaining steps are 1 and the knight and destination have the same color the it is known that the target cannot be reached,and the possibleMoves is not meaningful to be tested.

Things that can improve the implementation:

* In ChessPaths instead of a List<ChessPath> it would be better to have a Map<Integer, List<ChessPath>> where the Key - Integer will be the number of the ChessCells that the ChessPath has. This way the shortest path could easily retrieved from a value of the Map with the smallest key.
* In genereal a 8-Ary Tree Data Structure could give extra benefits in such kind of problems.
* Create a docker image of the application in order to run it in a docker container, in order to make it available also for users that they do not have JVM.
