import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends JPanel {
    
    public TitleScreen(final CardLayout cardLayout, final JPanel container) {
        // Set the size and background color of the panel
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setLayout(null); // Use absolute positioning for simplicity

        // Create and add the title label
        JLabel titleLabel = new JLabel("Pong Game", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 100, 800, 100);
        add(titleLabel);

        // Create and add the "Start Game" button
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(325, 300, 150, 50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(container, "Game");
                // Request focus on the GamePanel after switching
                container.getComponent(1).requestFocusInWindow();
            }
        });
        add(startButton);

        // Create and add the "Exit" button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(325, 400, 150, 50);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);
    }
}