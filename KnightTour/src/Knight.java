import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Knight {
    public int row,col,x,y;
	//passing the board to get tile size
	Board board;
		
	Image sprite;
	
	//constructor
	public Knight(int row, int col, Board board) {
		
		this.row = row;
		this.col = col;
		//poition calculated by multiplying the row and col times the tile size of the board
		x = board.TILE_SIZE * row;
		y = board.TILE_SIZE * col;
		this.board = board;
		try {
            this.sprite = new ImageIcon("res/BKnight.png").getImage();
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
	
}
