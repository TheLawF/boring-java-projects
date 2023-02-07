package GamblingGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GambleGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("抽卡模拟器");
        frame.setContentPane(new GambleGame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton button1;
    private JPanel panel1;
    private JButton button2;
    private JTextArea textArea1;

    public GambleGame() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double normal = 0.7d;
                double rare = 0.2d;
                double superRare = 0.09d;
                double ssr = 0.01d;

                double[] arr = new double[10];
                ArrayList<Double> list = new ArrayList<>();
                for (int i = 0; i < arr.length; i++) {
                   arr[i] = Math.random();
                    if (arr[i] > normal) {
                        System.out.println("normal");
                    }
                    else if (arr[i] <= normal && arr[i] > rare) {
                        System.out.println("Rare!");
                    }
                    else if (arr[i] <= rare && arr[i] > superRare) {
                        System.out.println("SR!!");
                    }
                    else if (arr[i] <= ssr) {
                        System.out.println("SSR!!!");
                    }
                }
                System.out.println("-------------------------------\n");
            }
        });
    }
}
