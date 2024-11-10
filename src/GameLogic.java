import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameLogic {
    private final GameWindow gameWindow;
    private final int[][] board = new int[10][10];
    private int missCounter = 0;
    private int strikeCounter = 0;
    private int totalMissCounter = 0;
    private int totalHitCounter = 0;

    public GameLogic(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public void placeShips() {
        int[] shipSizes = {5, 4, 3, 3, 2};
        Random random = new Random();

        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                int orientation = random.nextInt(2);
                int row = random.nextInt(10);
                int col = random.nextInt(10);

                if (canPlaceShip(size, row, col, orientation)) {
                    for (int i = 0; i < size; i++) {
                        if (orientation == 0) {
                            board[row][col + i] = 1;
                        } else {
                            board[row + i][col] = 1;
                        }
                    }
                    placed = true;
                }
            }
        }
    }

    private boolean canPlaceShip(int size, int row, int col, int orientation) {
        if (orientation == 0) {
            if (col + size > 10) return false;
            for (int i = 0; i < size; i++) {
                if (board[row][col + i] != 0) return false;
            }
        } else {
            if (row + size > 10) return false;
            for (int i = 0; i < size; i++) {
                if (board[row + i][col] != 0) return false;
            }
        }
        return true;
    }

    public void handleButtonClick(int row, int col, JButton button) {
        button.setEnabled(false);

        if (board[row][col] == 1) {
            button.setText("X");
            button.setBackground(Color.RED);
            totalHitCounter++;
            missCounter = 0;
            gameWindow.getStatusPanel().updateTotalHitCounter(totalHitCounter);

            if (totalHitCounter == 17) {
                JOptionPane.showMessageDialog(null, "You won! All ships sunk!");
                gameWindow.resetGame();
            }
        } else {
            button.setText("M");
            button.setBackground(Color.BLACK);
            missCounter++;
            totalMissCounter++;
            gameWindow.getStatusPanel().updateMissCounter(missCounter);
            gameWindow.getStatusPanel().updateTotalMissCounter(totalMissCounter);

            if (missCounter == 5) {
                strikeCounter++;
                missCounter = 0;
                gameWindow.getStatusPanel().updateStrikeCounter(strikeCounter);

                if (strikeCounter == 3) {
                    JOptionPane.showMessageDialog(null, "You lost! Three strikes.");
                    gameWindow.resetGame();
                }
            }
        }
    }

    public void resetGame() {
        missCounter = 0;
        strikeCounter = 0;
        totalMissCounter = 0;
        totalHitCounter = 0;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                board[row][col] = 0;
            }
        }
        placeShips();
    }
}

