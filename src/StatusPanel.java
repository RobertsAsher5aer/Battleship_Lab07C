import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {
    private final JLabel missLabel;
    private final JLabel strikeLabel;
    private final JLabel totalMissLabel;
    private final JLabel totalHitLabel;

    public StatusPanel() {
        setLayout(new GridLayout(4, 1));
        missLabel = new JLabel("Miss Counter: 0");
        strikeLabel = new JLabel("Strike Counter: 0");
        totalMissLabel = new JLabel("Total Miss: 0");
        totalHitLabel = new JLabel("Total Hit: 0");

        add(missLabel);
        add(strikeLabel);
        add(totalMissLabel);
        add(totalHitLabel);
    }

    public void updateMissCounter(int value) {
        missLabel.setText("Miss Counter: " + value);
    }

    public void updateStrikeCounter(int value) {
        strikeLabel.setText("Strike Counter: " + value);
    }

    public void updateTotalMissCounter(int value) {
        totalMissLabel.setText("Total Miss: " + value);
    }

    public void updateTotalHitCounter(int value) {
        totalHitLabel.setText("Total Hit: " + value);
    }

    public void resetStatus() {
        updateMissCounter(0);
        updateStrikeCounter(0);
        updateTotalMissCounter(0);
        updateTotalHitCounter(0);
    }
}

