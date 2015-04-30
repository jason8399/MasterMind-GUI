package jp;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        JFrame a = new JFrame();
        a.add(new PlayerRound());
        a.pack();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }
}
