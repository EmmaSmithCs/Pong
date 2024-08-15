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

        // Set the window to be visible
        setVisible(true);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Create a new GamePanel object
        add(new GamePanel());
        
        setVisible(true);

    }

    public static void main(String[] args) {
        // Create a new PongGame object
        new PongGame();
    }
}

