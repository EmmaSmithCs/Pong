import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    // Constants for the ball and paddle
    private static final int BALL_SIZE = 20;
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 100;

    // Positions of the ball and paddles
    private int ballX = 400;
    private int ballY = 300;
    private int player1Y;
    private int player2Y;

    // Ball speed
    private int ballSpeed = 3;

    // Ball direction
    private int ballXDirection = -1;
    private int ballYDirection = -2;

    // Paddle direction
    private int player1Direction = 0;
    private int player2Direction = 0;

    public GamePanel() {
        // Set the size of the panel
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);

        Timer timer = new Timer(5, this);
        timer.start();

        setFocusable(true); // Make sure the panel is focusable
        requestFocusInWindow(); // Request focus to ensure it receives key events

        addKeyListener(this); // Register key listener
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Initialize paddle positions if they haven't been set yet
        if (player1Y == 0 && player2Y == 0) {
            initializePaddles();
        }

        g.setColor(Color.WHITE);

        // Draw the left paddle (Player 1)
        g.fillRect(50, player1Y, PADDLE_WIDTH, PADDLE_HEIGHT);

        // Draw the right paddle (Player 2)
        g.fillRect(getWidth() - 50 - PADDLE_WIDTH, player2Y, PADDLE_WIDTH, PADDLE_HEIGHT);

        // Draw the ball
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        initializePaddles();
    }

    private void initializePaddles() {
        player1Y = (getHeight() - PADDLE_HEIGHT) / 2;
        player2Y = (getHeight() - PADDLE_HEIGHT) / 2;
    }

    public void actionPerformed(ActionEvent e) {
        move();
        checkCollision();
        repaint();
    }

    public void move() {
        // Move the ball
        ballX += ballSpeed * ballXDirection;
        ballY += ballSpeed * ballYDirection;

        // Move the paddles
        player1Y += player1Direction;
        player2Y += player2Direction;
    }

    private void checkCollision() {
        // Bounce the ball off the top and bottom of the screen
        if (ballY <= 0 || ballY >= getHeight() - BALL_SIZE) {
            ballYDirection = -ballYDirection;
        }

        // Bounce the ball off the paddles
        if (ballX <= 50 + PADDLE_WIDTH && ballY >= player1Y && ballY <= player1Y + PADDLE_HEIGHT) {
            ballXDirection = -ballXDirection;
        }

        if (ballX >= getWidth() - 50 - PADDLE_WIDTH - BALL_SIZE && ballY >= player2Y && ballY <= player2Y + PADDLE_HEIGHT) {
            ballXDirection = -ballXDirection;
        }

        // Reset the ball if it goes off the screen
        if (ballX <= 0 || ballX >= getWidth() - BALL_SIZE) {
            ballX = 400;
            ballY = 300;

            // Reset the ball direction
            ballXDirection = -ballXDirection;
        }

        // Keep the paddles on the screen
        if (player1Y <= 0) {
            player1Y = 0;
        }

        if (player1Y >= getHeight() - PADDLE_HEIGHT) {
            player1Y = getHeight() - PADDLE_HEIGHT;
        }

        if (player2Y <= 0) {
            player2Y = 0;
        }

        if (player2Y >= getHeight() - PADDLE_HEIGHT) {
            player2Y = getHeight() - PADDLE_HEIGHT;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Debugging output to check key events
        System.out.println("Key Pressed: " + e.getKeyCode());

        // Move the paddles when the arrow keys are pressed
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player2Direction = -7;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player2Direction = 7;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player1Direction = -7;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            player1Direction = 7;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Debugging output to check key events
        System.out.println("Key Released: " + e.getKeyCode());

        // Stop the paddles when the arrow keys are released
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            player2Direction = 0;
        }
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
            player1Direction = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}