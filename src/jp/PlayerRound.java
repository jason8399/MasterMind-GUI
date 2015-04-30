package jp;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JasonPan on 4/30/15.
 * MASTER MIND Player to guess what computer think.
 */
public class PlayerRound extends JPanel {
    private SubmitPanel subPanel;
    private ConfirmPanel conPanel;
    private JTextField finalMessage;

    PlayerRound(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        conPanel = new ConfirmPanel();
        this.add(conPanel);
        subPanel = new SubmitPanel();
        this.add(subPanel);
        finalMessage = new JTextField(30);
        finalMessage.setEditable(false);
        this.add(finalMessage);
    }

    class SubmitPanel extends JPanel {
        JButton RButton;
        JButton GButton;
        JButton BButton;
        JButton YButton;
        JButton OButton;
        JButton SubmitButton;
        JButton BackspaceButton;
        JPanel buttonPanel;
        JPanel subPanel;

        SubmitPanel() {
            this.setLayout(new GridLayout(2, 0));
            buttonPanel = new JPanel(new GridLayout(0, 5));
            buttonPanel.add(RButton = new JButton("R"));
            buttonPanel.add(GButton = new JButton("G"));
            buttonPanel.add(BButton = new JButton("B"));
            buttonPanel.add(YButton = new JButton("Y"));
            buttonPanel.add(OButton = new JButton("O"));
            subPanel = new JPanel(new GridLayout(0, 2));
            subPanel.add(SubmitButton = new JButton("Submit"));
            subPanel.add(BackspaceButton = new JButton("Backspace"));
            this.add(buttonPanel);
            this.add(subPanel);
        }
    }

    class ConfirmPanel extends JPanel {
        Trial[] trials;

        ConfirmPanel() {
            this.setLayout(new GridLayout(0, 1));
            this.trials = new Trial[10];
            for (int i = 0; i < 10; i++) {
                add(this.trials[i] = new Trial(i + 1));
            }
        }

        class Trial extends JPanel {
            JLabel trialLabel;
            JTextField field;
            JLabel blackPin;
            JTextField bkField;
            JLabel whitePin;
            JTextField whField;

            Trial() {
            }

            Trial(int num) {
                setLayout(new FlowLayout());
                this.add(trialLabel = new JLabel("Trial " + num));
                this.add(field = new JTextField(14));
                this.add(blackPin = new JLabel("BK"));
                this.add(bkField = new JTextField(3));
                this.add(whitePin = new JLabel("WH"));
                this.add(whField = new JTextField(3));
                field.setEditable(false);
                bkField.setEditable(false);
                whField.setEditable(false);
            }

            void setButtonEnabled(boolean enabled) {
                blackPin.setEnabled(enabled);
                whitePin.setEnabled(enabled);
            }
        }
    }
}
