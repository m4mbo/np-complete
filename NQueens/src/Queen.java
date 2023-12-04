import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Queen {
    public int row,col,x,y;
	//passing the board to get tile size
	Board board;
		
	Image sprite;
	
	//constructor
	public Queen(int row, int col, Board board) {
		
		this.row = row;
		this.col = col;
		//poition calculated by multiplying the row and col times the tile size of the board
		x = board.TILE_SIZE * row;
		y = board.TILE_SIZE * col;
		this.board = board;
		try {
            this.sprite = new ImageIcon("N-Queens-Problem-Java/NQueens/res/WQueen.png").getImage();
            // Image loaded successfully, continue with your logic
        } catch (Exception e) {
            // Error loading image, handle the exception
            e.printStackTrace();
        }
	}

	//default draw method
	public void draw(Graphics g) {
		g.drawImage(sprite, x, y, board.TILE_SIZE, board.TILE_SIZE, null);
	}
	
	//overwritten is valid move method
	public boolean isValidMove(int row, int col) {
		//checking if the tile is in the same row or column than the current queen tile
		if(this.col == col || this.row == row) {
			return true;
		}
		//checking if the tile is in the same diagonal than the current queen tile
		if(Math.abs(col - this.col) == Math.abs(row - this.row)) {
			return true;
		}
		
		return false;
	}
}
