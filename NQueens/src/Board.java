import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{

    int n;

    int PANEL_SIZE = 700;
    int TILE_SIZE;
    
    Graphics graphics;

    Image image;

	Stack<Queen> Queens;

	StackSolver solver;

	Timer timer;

    public Board(int n){
        this.n = n;

        TILE_SIZE = PANEL_SIZE/n;

		solver = new StackSolver(n, this);

		Queens = new Stack();

        setLayout(null);
		setSize(PANEL_SIZE, PANEL_SIZE);												// setting the size of the panel
	    setFocusable(true);													// setting focusable to true to receive keyboard input 
	    
	    setVisible(true);

		start();
		
    }

    public void paint(Graphics g) {
		image = createImage(PANEL_SIZE, PANEL_SIZE);
		graphics = image.getGraphics();
		draw(graphics);																	// calling draw method
		g.drawImage(image,1,1,this);
	}

	public void start() {
    	timer = new Timer(500, this);
    	timer.start();
    }

    public void draw(Graphics g) {
		
		//printing the white and black tiles
		
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				//if row+col is even, draw a white tile
				
				if((i+j) % 2 == 0) {
					g.setColor(new Color(249, 172, 113));
				}else {
					
					//if it is odd, draw a black tile
					
					g.setColor(new Color(103, 51, 20));
				}
				
				g.fillRect(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE);

			}
		}

		for(int i = 0; i < Queens.size(); i++){
			Queens.get(i).draw(g);
		}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Queens = solver.solve();
		repaint();
	}


}
