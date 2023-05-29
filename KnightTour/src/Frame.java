import javax.swing.JFrame;

public class Frame extends JFrame{
    
    int FRAME_WIDTH  = 713;
    int FRAME_HEIGHT = 739;

    Board board;

    public Frame(){

        board = new Board(8);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);				//setting the frame to the constant values declared as properties
		setTitle("N Queens");						    // setting a title to the frame
		setLocationRelativeTo(null);					//setting frame location to the middle of the screen
	
		add(board);										// adding a panel
		setVisible(true);								// making the frame visible
		setResizable(false);					        // disabling the frame to be resizable
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
    }
}
