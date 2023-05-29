import java.util.Stack;

public class StackSolver{

    int n;
    Board board;
    boolean start = false;
    boolean[][] visited;

    Stack<Position> tour;

    public StackSolver(int n, Board board){
        this.n = n;
        this.board = board;
        visited = new boolean[n][n];
        tour = new Stack();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
    }

    public Stack<Position> solve(){
        if(!start){
            tour.push(new Position(0,0));
            start = true;
            return tour;
        }

        while(tour.size() != n*n){

            if(availableTiles()){
                chooseNewTile();
            }else{
                backtrack();
            }
        }

        return tour;
    }

    public void chooseNewTile(){

    }

    public boolean availableTiles(){

        Position lastPos = tour.peek();

        if(lastPos.row + 1 > n && lastPos.col - 2 < 0){
            if(!visited[lastPos.row + 1][lastPos.col - 2]){
                return true;
            }
        }else if (lastPos.row - 1 < 0 && lastPos.col - 2 < 0){
            if(!visited[lastPos.row - 1][lastPos.col - 2]){
                return true;
            }
        }else if (lastPos.row + 1 > n && lastPos.col + 2 > n){
            if(!visited[lastPos.row + 1][lastPos.col + 2]){
                return true;
            }
        }else if (lastPos.row - 1 < 0 && lastPos.col + 2 > n){
            if(!visited[lastPos.row - 1][lastPos.col + 2]){
                return true;
            }
        }else if (lastPos.row - 2 < 0 && lastPos.col - 1 < 0){
            if(!visited[lastPos.row - 2][lastPos.col - 1]){
                return true;
            }
        }else if (lastPos.row - 2 < 0 && lastPos.col + 1 > n){
            if(!visited[lastPos.row - 2][lastPos.col + 1]){
                return true;
            }
        }else if (lastPos.row + 2 > n && lastPos.col - 1 < 0){
            if(!visited[lastPos.row + 2][lastPos.col - 1]){
                return true;
            }
        }else if (lastPos.row + 2 > n && lastPos.col + 1 > n){
            if(!visited[lastPos.row + 2][lastPos.col + 1]){
                return true;
            }
        }

        return false;
        
    }

    public void backtrack(){

    }



}