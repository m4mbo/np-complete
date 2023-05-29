# Knight's Tour Problem Java
This is my attempt on constructing visual representations for the non-deterministic iterative algorithms that solve the NP-complete Knight's Tour problem using Java. 

The Knight's Tour problem consists of an NxN chess board and a knight piece. The goal is to find a sequence of knight moves that visits each tile on the board exactly once. 

Warnsdorff's rule is a heuristic or a strategy that can be used in conjunction with backtracking to solve the Knight's Tour problem more efficiently. It is named after H.C. Warnsdorff, who introduced the rule in the 19th century.

The basic idea behind Warnsdorff's rule is to prioritize the knight's moves based on the number of future moves available from each potential move. The rule suggests that the knight should always move to the square with the fewest possible onward moves.

After comparing the solution applying Warnsdorff's rule optimization and not applying it, one can clearly observe how this rule makes the tour come to an end much faster. The visualization is great for having a better understanding of how backtracking works, which can result particularly useful when teaching about the stack ADT.


