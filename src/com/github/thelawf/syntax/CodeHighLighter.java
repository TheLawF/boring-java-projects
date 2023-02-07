package com.github.thelawf.syntax;

import com.github.thelawf.logoslib.codeblocks.BlockCodeRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Objects;

public class CodeHighLighter{
    static JFrame frame = new JFrame("HighLighter");
    private JPanel panel;
    private JScrollPane pane;
    private JSplitPane sPane;
    private JToolBar bar;
    private JTree tree1;
    private JEditorPane editor;
    private JButton fileButton;
    JPopupMenu menu = new JPopupMenu();
    JMenuItem itemOpenRecent = new JMenuItem("最近打开");
    JMenuItem itemSave = new JMenuItem("保存(S)");
    JMenuItem itemSaveAs = new JMenuItem("另存为");

    public CodeHighLighter() {
        BlockCodeRenderer renderer = new BlockCodeRenderer(Color.BLUE);
        JMenuItem itemOpen = new JMenuItem(new AbstractAction("打开(O)") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(".");
                fileChooser.showOpenDialog(frame);
                File file = fileChooser.getSelectedFile();
                //进行显示
                try {
                    if (Objects.equals(file.getName().split("\\.")[1], "txt")) {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        StringBuilder script = new StringBuilder();

                        while((line = reader.readLine()) != null){
                            script.append(line);
                            String prevLine = editor.getText();
                            editor.setText(prevLine + "\n" + line);
                            /*
                            Highlighter hl = editor.getHighlighter();
                            int[] arr = renderer.renderColorByType(editor.getFont(), editor.getText());
                            hl.addHighlight(arr[0],arr[1],renderer);
                            editor.setText("<font color='" + AbstractReservedWord.colorStrHex + "'>" + "ele" + " <font/>");
                            editor.setText("<html><font color='green'>编号：</font><font color='red'>  01  </font> <font color='green'>时间： </font><font color='red'> 12:00  </font><br><font color='green'></font></html>\n");
                             */
                            String textInput = renderer.renderColorByType(editor.getFont(),editor.getText());
                            BufferedWriter txt = new BufferedWriter(new FileWriter("output.txt"));
                            txt.write(textInput);
                            txt.close();
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        fileButton.addActionListener(e -> {
        this.fileButton.setText("文件");

        Font yaHei = (new Font("Microsoft YaHei",Font.PLAIN,16));
        Font segoeUI = new Font("Segoe UI",Font.PLAIN,16);

        this.fileButton.setFont(yaHei);
        itemOpen.setFont(yaHei);
        itemOpenRecent.setFont(yaHei);
        itemSave.setFont(yaHei);
        itemSaveAs.setFont(yaHei);
        /*
        Dimension d = new Dimension(200,600);
        menu.setPreferredSize(d);

        button.setFont(segoeUI);
        itemOpen.setFont(segoeUI);
        itemOpenRecent.setFont(segoeUI);
        itemSave.setFont(segoeUI);
        itemSaveAs.setFont(segoeUI);
         */

        menu.add(itemOpen);
        menu.add(itemOpenRecent);
        menu.add(itemSave);
        menu.add(itemSaveAs);
        menu.show(this.fileButton,this.fileButton.getX(),this.fileButton.getY());

        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new CodeHighLighter().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Deprecated
    public void showPopMenu(Component component,JButton button,int x,int y) {
        button.setText("文件");

        Font yaHei = (new Font("Microsoft YaHei",Font.PLAIN,16));
        Font segoeUI = new Font("Segoe UI",Font.PLAIN,16);

        button.setFont(yaHei);
        //itemOpen.setFont(yaHei);
        itemOpenRecent.setFont(yaHei);
        itemSave.setFont(yaHei);
        itemSaveAs.setFont(yaHei);
        /*
        Dimension d = new Dimension(200,600);
        menu.setPreferredSize(d);

        button.setFont(segoeUI);
        itemOpen.setFont(segoeUI);
        itemOpenRecent.setFont(segoeUI);
        itemSave.setFont(segoeUI);
        itemSaveAs.setFont(segoeUI);
         */

        //menu.add(itemOpen);
        menu.add(itemOpenRecent);
        menu.add(itemSave);
        menu.add(itemSaveAs);
        menu.show(component,x,y);
    }
}
