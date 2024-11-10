import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    public ControlPanel(GameWindow gameWindow) {
        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(e -> gameWindow.resetGame());
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));
        add(playAgainButton);
        add(quitButton);
    }
}
