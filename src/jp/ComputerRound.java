package jp;

import com.sun.corba.se.impl.copyobject.FallbackObjectCopierImpl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by JasonPan on 4/25/15.
 * MASTER MIND Computer to guess what palyer think.
 */
public class ComputerRound extends JFrame {
    private LabelPuzzle labelPanel = new LabelPuzzle();
    private SubmitPanel subPanel = new SubmitPanel();
    private ConfirmPanel conPanel = new ConfirmPanel();

    public ComputerRound() {
        this.setLayout(new SpringLayout());
        this.add(labelPanel);
        this.add(subPanel);
        this.add(conPanel);
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

    class ConfirmPanel extends JPanel{
        Trial[] trials;

        ConfirmPanel(){
            this.setLayout(new GridLayout(0, 1));
            this.trials = new Trial[10];
            for(Trial putIn: trials){
                add(putIn = new Trial(1));
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
                this.add(bkField = new JTextField("-1"));
                this.add(whitePin = new JButton("WH"));
                this.add(whField = new JTextField("-1"));
                field.setEditable(false);
                bkField.setEditable(false);
                whField.setEditable(false);
            }

            void setButtonEnabled(boolean enabled){
                blackPin.setEnabled(enabled);
                whitePin.setEnabled(enabled);
            }
        }
    }
}
