package count_score;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class CountDoublings {
    public static void main(String[] args) {
        double unitScore = 0d;
        double scoreBanker = 0d;

        // JFrame jf = new JFrame("日麻算番");
        // Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // int w = screen.width;
        // int h = screen.height;

        // jf.setSize(w-400,h-400);
        // jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // jf.setVisible(true);

        // int frameWid = jf.getWidth();
        // int frameHei = jf.getHeight();
        // jf.setLocation((w-frameWid)/2,(h-frameHei)/2);

        // Box box = Box.createVerticalBox();
        // JPanel haiPanel = new JPanel();
        // JPanel idPanel = new JPanel();
        // JPanel zimoPanel = new JPanel();
        // JPanel doubPanel = new JPanel();
        // JPanel fuPanel = new JPanel();

        System.out.print("请输入番数：");
        Scanner sc = new Scanner(System.in);
        double doubling = sc.nextDouble();

        System.out.print("请输入符数：");
        Scanner scan = new Scanner(System.in);
        int fu = scan.nextInt();

        System.out.print("亲家输入true，子家输入false：");
        Scanner scanner = new Scanner(System.in);
        boolean isBanker = scanner.nextBoolean();

        System.out.print("自摸输入true，荣和输入false：");
        Scanner s = new Scanner(System.in);
        boolean isZimo = s.nextBoolean();

        if (doubling <= 4) {
            unitScore = fu * Math.pow(2d, 2d + doubling);
            int score = (int) unitScore;

            if (isBanker) {
                if (isZimo) {
                    score *= 2;
                    int score1 = score;
                    if (score % 100 != 0) {
                        score = score - (score % 100) + 100;
                    }
                    if (doubling >= 3 && score*3 >= 12000) {
                        System.out.print("亲家" + 12000 + "点，");
                        System.out.println("每人支付："+4000);

                    }
                    else {
                        score1 *= 3;
                        if (score1 % 100 != 0) {
                            score1 = score1 - (score1 % 100) + 100;
                        }
                        System.out.print("亲家" + score1 + "点，");
                        System.out.println("每人支付：" + score);
                    }
                }
                else {
                    score *= 6;
                    if (score % 100 != 0) {
                        score = score - (score % 100) + 100;
                    }
                    if (doubling >= 3 && score >= 12000) {
                        System.out.print("亲家" + 12000 + "点，");
                        System.out.println("放铳者支付：" + 12000);

                    }
                    else {
                        System.out.println("放铳者支付：" + score);
                    }
                }
            }
            else {
                if (isZimo) {
                    scoreBanker = 2 * unitScore;
                    int scoreB = (int) scoreBanker;

                    int score1 = score;
                    int score2 = scoreB;
                    int score3 = 0;
                    score3 += score1;
                    score3 *= 2;
                    score3 += score2;

                    if (score % 100 != 0) {
                        score = score - (score % 100) + 100;
                        scoreB = scoreB - (scoreB % 100) + 100;
                    }

                    if (doubling >= 3 && score1 + score2 >= 8000) {
                        System.out.println("\n自摸子家满贯" + 8000 + "点");
                        System.out.println("亲家支付："+4000);
                        System.out.println("子家支付："+2000);
                    }
                    else {
                        if (score1 % 100 != 0) {
                            score1 = score1 - (score1 % 100) + 100;
                            score2 = score2 - (score2 % 100) + 100;
                            score3 = score3 - (score3 % 100) + 100;
                        }
                        System.out.println("\n自摸子家" + score3 + "点");
                        System.out.println("亲家支付："+score2);
                        System.out.println("子家支付："+score1);
                    }

                }
                else {
                    score *= 4;
                    score = score - (score % 100) + 100;
                    if (doubling >= 3 && score >= 8000) {
                        System.out.println("\n自摸子家满贯" + 8000 + "点");
                        System.out.println("放铳者支付："+8000);
                    }
                    else {
                        System.out.println("放铳者支付："+score);
                    }

                }
            }
        }
        else if (doubling == 5) {
            unitScore = 2000;
            scoreBanker = 2 * unitScore;
            int score = (int) unitScore;

            if (isBanker) {
                if (isZimo) {
                    score *= 2;
                    System.out.print("亲家" + score*3 + "点，");
                    System.out.println("每人支付："+score);

                }
                else {
                    score *= 6;
                    System.out.println("放铳者支付："+score);
                }
            }
            else {
                if (isZimo) {
                    scoreBanker = 2 * unitScore;
                    int scoreB = (int) scoreBanker;

                    scoreB = scoreB - (scoreB % 100) + 100;
                    System.out.println("\n自摸子家" + unitScore*4 + "点");
                    System.out.println("亲家支付："+scoreB);
                    System.out.println("子家支付："+score);

                }
                else {
                    score *= 4;
                    System.out.println("放铳者支付："+score);
                }
            }
        }
        else if (doubling == 6 || doubling == 7) {
            unitScore = 3000;
            scoreBanker = 2 * unitScore;
            int score = (int) unitScore;

            if (isBanker) {
                if (isZimo) {
                    score *= 2;
                    System.out.print("亲家" + score*3 + "点，");
                    System.out.println("每人支付："+score);

                }
                else {
                    score *= 6;
                    System.out.println("放铳者支付："+score);
                }
            }
            else {
                if (isZimo) {
                    scoreBanker = 2 * unitScore;
                    int scoreB = (int) scoreBanker;

                    scoreB = scoreB - (scoreB % 100) + 100;
                    System.out.println("\n自摸子家" + unitScore*4 + "点");
                    System.out.println("亲家支付："+scoreB);
                    System.out.println("子家支付："+score);

                }
                else {
                    score *= 4;
                    System.out.println("放铳者支付："+score);
                }
            }
        }
        else if (doubling > 7 && doubling < 11) {
            unitScore = 4000;
            scoreBanker = 2 * unitScore;
            int score = (int) unitScore;

            if (isBanker) {
                if (isZimo) {
                    score *= 2;
                    System.out.print("亲家" + score*3 + "点，");
                    System.out.println("每人支付："+score);

                }
                else {
                    score *= 6;
                    System.out.println("放铳者支付："+score);
                }
            }
            else {
                if (isZimo) {
                    scoreBanker = 2 * unitScore;
                    int scoreB = (int) scoreBanker;

                    scoreB = scoreB - (scoreB % 100) + 100;
                    System.out.println("\n自摸子家" + unitScore*4 + "点");
                    System.out.println("亲家支付："+scoreB);
                    System.out.println("子家支付："+score);

                }
                else {
                    score *= 4;
                    System.out.println("放铳者支付："+score);
                }
            }
        }
        else if (doubling == 11 || doubling == 12) {
            unitScore = 6000;
            scoreBanker = 2 * unitScore;
            int score = (int) unitScore;

            if (isBanker) {
                if (isZimo) {
                    score *= 2;
                    System.out.print("亲家" + score*3 + "点，");
                    System.out.println("每人支付："+score);

                }
                else {
                    score *= 6;
                    System.out.println("放铳者支付："+score);
                }
            }
            else {
                if (isZimo) {
                    scoreBanker = 2 * unitScore;
                    int scoreB = (int) scoreBanker;

                    scoreB = scoreB - (scoreB % 100) + 100;
                    System.out.println("\n自摸子家" + unitScore*4 + "点");
                    System.out.println("亲家支付："+scoreB);
                    System.out.println("子家支付："+score);

                }
                else {
                    score *= 4;
                    System.out.println("放铳者支付："+score);
                }
            }
        }
        else {
            unitScore = 8000;
            scoreBanker = 2 * unitScore;
            int score = (int) unitScore;

            if (isBanker) {
                if (isZimo) {
                    score *= 2;
                    System.out.print("亲家" + score*3 + "点，");
                    System.out.println("每人支付："+score);

                }
                else {
                    score *= 6;
                    System.out.println("放铳者支付："+score);
                }
            }
            else {
                if (isZimo) {
                    scoreBanker = 2 * unitScore;
                    int scoreB = (int) scoreBanker;

                    scoreB = scoreB - (scoreB % 100) + 100;
                    System.out.println("\n自摸子家" + unitScore*4 + "点");
                    System.out.println("亲家支付："+scoreB);
                    System.out.println("子家支付："+score);

                }
                else {
                    score *= 4;
                    System.out.println("放铳者支付："+score);
                }
            }
        }

    }
}
