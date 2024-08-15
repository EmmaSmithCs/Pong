import javax.swing.JFrame;

public class PongGame extends JFrame {

    // Window size constants
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    public PongGame() {
        // Set the window title
        setTitle("Pong");

        // Set the window size
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Set the window to close when the close button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new GamePanel object
        GamePanel gamePanel = new GamePanel();
        
        // Add the GamePanel to the JFrame
        add(gamePanel);
        
        // Request focus on the GamePanel to ensure it receives key events
        gamePanel.requestFocusInWindow();

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Set the window to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create a new PongGame object
        new PongGame();
    }
}
