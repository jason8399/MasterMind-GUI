package jp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JasonPan on 4/25/15.
 * MASTER MIND Computer to guess what player think.
 */
public class ComputerRound extends JPanel {
    private LabelPuzzle labelPanel;
    private SubmitPanel subPanel;
    private ConfirmPanel conPanel;
    private JTextField finalMessage;
    private int guessTimes;

    public ComputerRound() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        labelPanel = new LabelPuzzle();
        this.add(labelPanel);
        subPanel = new SubmitPanel();
        this.add(subPanel);
        this.add(new JSeparator(JSeparator.HORIZONTAL));
        conPanel = new ConfirmPanel();
        this.add(conPanel);
        finalMessage = new JTextField(30);
        finalMessage.setEditable(false);
        this.add(finalMessage);
        this.guessTimes = 0;
    }

    class LabelPuzzle extends JPanel {
        JLabel puzzleLabel;
        JTextField puzzleField;

        LabelPuzzle() {
            this.setLayout(new FlowLayout());
            this.add(puzzleLabel = new JLabel("Puzzle"));
            this.add(puzzleField = new JTextField(30));
            puzzleField.setEditable(false);
        }
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
            this.RButton.addActionListener(new RButtonActionListener());
            buttonPanel.add(GButton = new JButton("G"));
            this.GButton.addActionListener(new GButtonActionListener());
            buttonPanel.add(BButton = new JButton("B"));
            this.BButton.addActionListener(new BButtonActionListener());
            buttonPanel.add(YButton = new JButton("Y"));
            this.YButton.addActionListener(new YButtonActionListener());
            buttonPanel.add(OButton = new JButton("O"));
            this.OButton.addActionListener(new OButtonActionListener());
            subPanel = new JPanel(new GridLayout(0, 2));
            subPanel.add(SubmitButton = new JButton("Submit"));
            subPanel.add(BackspaceButton = new JButton("Backspace"));
            this.BackspaceButton.addActionListener(new BackspaceActionListener());
            this.add(buttonPanel);
            this.add(subPanel);
        }

        class RButtonActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField temp = labelPanel.puzzleField;
                if(temp.getText().length() < 5)
                    temp.setText(temp.getText() + "R");
            }
        }

        class GButtonActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField temp = labelPanel.puzzleField;
                if(temp.getText().length() < 5)
                    temp.setText(temp.getText() + "G");
            }
        }

        class BButtonActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField temp = labelPanel.puzzleField;
                if(temp.getText().length() < 5)
                    temp.setText(temp.getText() + "B");
            }
        }

        class YButtonActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField temp = labelPanel.puzzleField;
                if(temp.getText().length() < 5)
                    temp.setText(temp.getText() + "Y");
            }
        }

        class OButtonActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField temp = labelPanel.puzzleField;
                if(temp.getText().length() < 5)
                    temp.setText(temp.getText() + "O");
            }
        }

        class BackspaceActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField temp = labelPanel.puzzleField;
                String tmpString = temp.getText();
                if(tmpString.length() > 0)
                    temp.setText(tmpString.substring(0, tmpString.length() - 1));
            }
        }

        class SubmitActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField temp = labelPanel.puzzleField;
            }
        }
    }

    class ConfirmPanel extends JPanel{
        Trial[] trials;

        ConfirmPanel(){
            this.setLayout(new GridLayout(0, 1));
            this.trials = new Trial[10];
            for(int i = 0; i < 10; i++){
                add(this.trials[i] = new Trial(i + 1));
            }
        }

        class Trial extends JPanel{
            JLabel trialLabel;
            JTextField field;
            JButton blackPin;
            JTextField bkField;
            JButton whitePin;
            JTextField whField;

            Trial(){
            }

            Trial(int num){
                setLayout(new GridLayout(1, 0));
                this.add(trialLabel = new JLabel("Trial " + num));
                this.add(field = new JTextField());
                this.add(blackPin = new JButton("BK"));
                this.blackPin.addActionListener(new BlackPinButtonActionListener());
                this.add(bkField = new JTextField("-1"));
                this.add(whitePin = new JButton("WH"));
                this.whitePin.addActionListener(new WhitePinButtonActionListener());
                this.add(whField = new JTextField("-1"));
                field.setEditable(false);
                bkField.setEditable(false);
                whField.setEditable(false);
            }

            void setButtonEnabled(boolean enabled){
                blackPin.setEnabled(enabled);
                whitePin.setEnabled(enabled);
            }

            class BlackPinButtonActionListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField temp = bkField;
                    temp.setText("" + (Integer.parseInt(temp.getText()) + 1));
                }
            }

            class WhitePinButtonActionListener implements ActionListener{
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField temp = whField;
                    temp.setText("" + (Integer.parseInt(temp.getText()) + 1));
                }
            }
        }
    }
}
