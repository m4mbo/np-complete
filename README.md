# Knight's Tour Problem 

The Knight's Tour problem consists of an NxN chess board and a knight piece. The goal is to find a sequence of knight moves that visits each tile on the board exactly once. 

# Warnsdorff's Rule

Warnsdorff's rule is a heuristic or a strategy that can be used in conjunction with backtracking to solve the Knight's Tour problem more efficiently. It is named after H.C. Warnsdorff, who introduced the rule in the 19th century.

The basic idea behind Warnsdorff's rule is to prioritize the knight's moves based on the number of future moves available from each potential move. The rule suggests that the knight should always move to the square with the fewest possible onward moves.

# Results

After comparing the solution applying Warnsdorff's rule optimization and not applying it, one can clearly observe how this rule makes the tour come to an end much faster. The visualization is great for having a better understanding of how backtracking works, which can result particularly useful when teaching about the stack ADT.

The space complexity for this solutions is in O(N^2), as a boolean type NxN matrix was created to hold visited tiles, and an adjacency list was implemented to map each move with the needed to avoid tiles in order to prevent repeating moves that will make the tour finish in a dead end.

N=8 :
![ezgif-5-1a9c5ce78c](https://github.com/M4mbo/Knight-Tour-Problem-Java/assets/115642529/fdd3bbb0-6f42-43a4-8b36-1dcdad935810)

N=20 :
![ezgif-5-1daced8716](https://github.com/M4mbo/Knight-Tour-Problem-Java/assets/115642529/b25c91f9-c5a3-4c21-bb9e-f05ae2bc818a)

# N Queens

The N Queens problem is an extension of the famous 8 Queens problem. A solution for this problem requires to place N queens on an NxN chessboard without any two queens attacking each other. This program in particular gives an iterative solution to said problem by using the stack ADT.

# Approach

The problem is solved in a non-deterministic manner, because it is NP-complete. This is done by "guessing" possible Queen configurations and only advancing if there are available Queen position on the next column. A boolean type matrix(NxN) was created to hold the validity of previous attempts. Furthermore, a "Queen" type stack ADT was implemented (each layer would have its own row and column). The program will continue pushing new Queens into the stack until it didn't have any tiles per column left. After we reach this state, we pop the last added Queen (column i) and mark the matrix cell as false, making every other cell marked as false from column i+1 true (because these values can change if we create a new Queen in position i). Then we repeat the process until we reach the desired output. The space complexity of this solution is in O(N^2).

# Results

N = 8

![256667242-cd57e1b8-6cd8-47ed-a078-db1e75f68f0e](https://github.com/m4mbo/np-complete/assets/115642529/160e09ed-12db-4afc-b33a-abc9573f34ba)

N = 20

![256667305-a0136499-0208-46cd-8d36-3020735f43d9](https://github.com/m4mbo/np-complete/assets/115642529/83ad62ac-a2cb-4977-8b75-dc6a27ca3704)


