package com.github.thelawf.syntax;

import javax.swing.*;

public class HiglightLable {
    private JPanel panel1;
    private JLabel label;
    private JSplitPane splitPane;
    private JToolBar bar;

    public static void main(String[] args) {
        JFrame frame = new JFrame("HiglightLable");
        frame.setContentPane(new HiglightLable().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
