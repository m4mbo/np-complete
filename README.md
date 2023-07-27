# Knight's Tour Problem Java
This is my attempt on constructing visual representations for the non-deterministic iterative algorithms that solve the NP-complete Knight's Tour problem using Java. 

The Knight's Tour problem consists of an NxN chess board and a knight piece. The goal is to find a sequence of knight moves that visits each tile on the board exactly once. 

Warnsdorff's rule is a heuristic or a strategy that can be used in conjunction with backtracking to solve the Knight's Tour problem more efficiently. It is named after H.C. Warnsdorff, who introduced the rule in the 19th century.

The basic idea behind Warnsdorff's rule is to prioritize the knight's moves based on the number of future moves available from each potential move. The rule suggests that the knight should always move to the square with the fewest possible onward moves.

After comparing the solution applying Warnsdorff's rule optimization and not applying it, one can clearly observe how this rule makes the tour come to an end much faster. The visualization is great for having a better understanding of how backtracking works, which can result particularly useful when teaching about the stack ADT.

The space complexity for this solutions is in O(N^2), as a boolean type NxN matrix was created to hold visited tiles, and an adjacency list was implemented to map each move with the needed to avoid tiles in order to prevent repeating moves that will make the tour finish in a dead end.

N=8 :
![ezgif-5-1a9c5ce78c](https://github.com/M4mbo/Knight-Tour-Problem-Java/assets/115642529/fdd3bbb0-6f42-43a4-8b36-1dcdad935810)

N=20 :
![ezgif-5-1daced8716](https://github.com/M4mbo/Knight-Tour-Problem-Java/assets/115642529/b25c91f9-c5a3-4c21-bb9e-f05ae2bc818a)

