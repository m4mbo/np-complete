import java.util.ArrayList;
import java.util.Stack;

public class StackSolver{

    int n;
    Board board;
    boolean start = false;
    ArrayList<ArrayList<Position>> avoid;
    boolean[][] visited;
    int code; //1 to 8 for 8 possible ways a knight can move assuming the best case

    Stack<Position> tour;

    public StackSolver(int n, Board board){
        this.n = n;
        this.board = board;
        visited = new boolean[n][n];
        tour = new Stack<>();
        avoid = new ArrayList<>(n*n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
    }

    public Stack<Position> solve(){
        if(!start){
            tour.push(new Position(0,0,0));
            avoid.add(new ArrayList<>(8));
            start = true;
            return tour;
        }

        while(tour.size() != n*n){

            if(availableTiles()){
                chooseNewTile();
                return tour;
            }else{
                backtrack();
                return tour;
            }
        }

        return tour;
    }

    public void chooseNewTile(){

        Position lastPos = tour.peek();

        switch(code){
            case 1:
                tour.push(new Position(lastPos.row + 1, lastPos.col - 2, tour.size()));
                visited[lastPos.row + 1][lastPos.col - 2] = true;
                avoid.add(new ArrayList<>(8));
                break;
            case 2:
                tour.push(new Position(lastPos.row - 1, lastPos.col - 2, tour.size()));
                visited[lastPos.row - 1][lastPos.col - 2] = true;
                avoid.add(new ArrayList<>(8));
                break;
            case 3:
                tour.push(new Position(lastPos.row + 1, lastPos.col + 2, tour.size()));
                visited[lastPos.row + 1][lastPos.col + 2] = true;
                avoid.add(new ArrayList<>(8));
                break;
            case 4:
                tour.push(new Position(lastPos.row - 1, lastPos.col + 2, tour.size()));
                visited[lastPos.row - 1][lastPos.col + 2] = true;
                avoid.add(new ArrayList<>(8));
                break;
            case 5:
                tour.push(new Position(lastPos.row - 2, lastPos.col - 1, tour.size()));
                visited[lastPos.row - 2][lastPos.col - 1] = true;
                avoid.add(new ArrayList<>(8));
                break;
            case 6:
                tour.push(new Position(lastPos.row - 2, lastPos.col + 1, tour.size()));
                visited[lastPos.row - 2][lastPos.col + 1] = true;
                avoid.add(new ArrayList<>(8));
                break;
            case 7:
                tour.push(new Position(lastPos.row + 2, lastPos.col - 1, tour.size()));
                visited[lastPos.row + 2][lastPos.col - 1] = true;
                avoid.add(new ArrayList<>(8));
                break;
            case 8:
                tour.push(new Position(lastPos.row + 2, lastPos.col + 1, tour.size()));
                visited[lastPos.row + 2][lastPos.col + 1] = true;
                avoid.add(new ArrayList<>(8));
                break;
        }
 
    }

    public boolean avoidTile(int row, int col){
        
        for(int i = 0; i < avoid.get(tour.size()-1).size() ; i++){
            if(avoid.get(tour.size()-1).get(i).row == row && avoid.get(tour.size()-1).get(i).col == col){
                return true;
            }
        }
        
        return false;
    }

    public boolean availableTiles(){

        Position lastPos = tour.peek();

        if(lastPos.row + 1 < n && lastPos.col - 2 >= 0){
            if(!visited[lastPos.row + 1][lastPos.col - 2] && !avoidTile(lastPos.row + 1, lastPos.col - 2)){
                code = 1;
                return true;
            }
        }
        if (lastPos.row - 1 >= 0 && lastPos.col - 2 >= 0){
            if(!visited[lastPos.row - 1][lastPos.col - 2] && !avoidTile(lastPos.row - 1, lastPos.col - 2)){
                code = 2;
                return true;
            }
        }
        if (lastPos.row + 1 < n && lastPos.col + 2 < n){
            if(!visited[lastPos.row + 1][lastPos.col + 2] && !avoidTile(lastPos.row + 1, lastPos.col + 2)){
                code = 3;
                return true;
            }
        }
        if (lastPos.row - 1 >= 0 && lastPos.col + 2 < n){
            if(!visited[lastPos.row - 1][lastPos.col + 2] && !avoidTile(lastPos.row - 1, lastPos.col + 2)){
                code = 4;
                return true;
            }
        }
        if (lastPos.row - 2 >= 0 && lastPos.col - 1 >= 0){
            if(!visited[lastPos.row - 2][lastPos.col - 1] && !avoidTile(lastPos.row - 2, lastPos.col - 1)){
                code = 5;
                return true;
            }
        }
        if (lastPos.row - 2 >= 0 && lastPos.col + 1 < n){
            if(!visited[lastPos.row - 2][lastPos.col + 1] && !avoidTile(lastPos.row - 2, lastPos.col + 1)){
                code = 6;
                return true;
            }
        }
        if (lastPos.row + 2 < n && lastPos.col - 1 >= 0){
            if(!visited[lastPos.row + 2][lastPos.col - 1] && !avoidTile(lastPos.row + 2, lastPos.col - 1)){
                code = 7;
                return true;
            }
        }
        if (lastPos.row + 2 < n && lastPos.col + 1 < n){
            if(!visited[lastPos.row + 2][lastPos.col + 1] && !avoidTile(lastPos.row + 2, lastPos.col + 1)){
                code = 8;
                return true;
            }
        }

        return false;
        
    }

    public void backtrack(){
        Position lastPos = tour.pop();
        avoid.remove(lastPos.order);
        avoid.get(tour.size()-1).add(lastPos);
        visited[lastPos.row][lastPos.col] = false;
    }



}
