import java.util.Stack;
public class StackSolver {
    
    int n, i, j, count;
    Board board;

    boolean[][] threats;

    boolean start = false;

    //creating a stack of linked lists
    Stack<Queen> solutions; 


    public StackSolver(int n, Board board){
        this.n = n;
        i = 1;
        j = 0;
        count = 0;
        this.board = board;
        threats = new boolean[n][n];
        solutions = new Stack();


        for(int i = 0; i < n; i++){                                             //initializing every cell as true
            for(int j = 0; j < n; j++){
                threats[i][j] = true;
            }
        }
    }

    public Stack<Queen> solve(){

        if(!start){
            solutions.push(new Queen(0,0,board));
            start = true;
            return solutions;
        }

        while(solutions.size() != n){
            
           while(i < n){

                if(j >= n){
                    backTrack(--i);
                    j = 0;
                    return solutions;
                }

                if(validPosition()){
                    
                    solutions.push(new Queen(i,j,board));
                    i++;
                    j = 0;
                    return solutions;
                }else{
                    j++;
                }  
            }
        }

        return solutions;

    }
    
    public void backTrack(int i){
        
        Queen lastQueen = solutions.pop();

        threats[lastQueen.row][lastQueen.col] = false;

        if(i != n-1){
            for(int j = 0; j < n; j++){
                threats[i+1][j] = true;
            }
        }
    }

    public boolean validPosition(){

        if(!threats[i][j]){
            return false;
        }

        for(int m = 0; m < solutions.size(); m++){
            if(solutions.get(m).isValidMove(i,j)){
                return false;
            }   
        }

        return true;
    }
}

