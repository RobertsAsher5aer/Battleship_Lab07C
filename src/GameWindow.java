import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final BoardPanel boardPanel;
    private final StatusPanel statusPanel;
    private final ControlPanel controlPanel;
    private final GameLogic gameLogic;

    public GameWindow() {
        setTitle("Single Player Battleship");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gameLogic = new GameLogic(this);
        boardPanel = new BoardPanel(gameLogic);
        statusPanel = new StatusPanel();
        controlPanel = new ControlPanel(this);

        add(boardPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.EAST);
        add(controlPanel, BorderLayout.SOUTH);

        gameLogic.placeShips();
        pack();
        setVisible(true);
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public StatusPanel getStatusPanel() {
        return statusPanel;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public void resetGame() {
        gameLogic.resetGame();
        boardPanel.resetBoard();
        statusPanel.resetStatus();
    }
}
