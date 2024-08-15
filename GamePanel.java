import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    
    //Constants for the ball and paddle
    private static final int BALL_SIZE = 20;
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 100;
 
    // Positions of the ball and paddles
    private int ballX = 400;
    private int ballY = 300;
    private int player1Y = 250;
    private int player2Y = 250;

    public GamePanel(){

        //Set the size of the panel
        setPreferredSize(new Dimension(800, 600));

        //Set the background color of the panel
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
    
        // Draw the left paddle (Player 1)
        g.fillRect(50, player1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
    
        // Draw the right paddle (Player 2)
        // Adjusting the position of the right paddle so it doesn't go outside the screen
        g.fillRect(getWidth() - 50 - PADDLE_WIDTH, player2Y, PADDLE_WIDTH, PADDLE_HEIGHT);
    
        // Draw the ball
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }



}
