import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardPanel extends JPanel {
    private final JButton[][] boardButtons = new JButton[10][10];
    private final GameLogic gameLogic;

    public BoardPanel(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        setLayout(new GridLayout(10, 10));
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JButton button = new JButton("~");
                button.setBackground(Color.WHITE);
                button.addActionListener(new BoardButtonListener(row, col));
                boardButtons[row][col] = button;
                add(button);
            }
        }
    }

    private class BoardButtonListener implements ActionListener {
        private final int row;
        private final int col;

        public BoardButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            gameLogic.handleButtonClick(row, col, boardButtons[row][col]);
        }
    }

    public void resetBoard() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                boardButtons[row][col].setText("~");
                boardButtons[row][col].setBackground(Color.WHITE);
                boardButtons[row][col].setEnabled(true);
            }
        }
    }
}
