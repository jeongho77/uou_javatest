package jframe;

import javax.swing.*;
import java.awt.*;

public class GamblingGameFrame extends JFrame {
    public GamblingGameFrame() {
        super("Open Challenge 10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new GamePanel());

        setSize(300,200);
        setVisible(true);

        getContentPane().setFocusable(true);
        getContentPane().requestFocus();
    }
    class GamePanel extends JPanel {
        private JLabel[] label = new JLabel[3];
        private JLabel result = new JLabel("시작입니다.");

        public GamePanel() {
            setLayout(null);

            for(int i = 0; i< label.length; i++){
                label[i] =  new JLabel("0");
                label[i].setSize(60,30);
                label[i].setLocation(30+80*i, 50);
                label[i].setHorizontalAlignment(JLabel.CENTER);
                label[i].setOpaque(true);
                label[i].setBackground(Color.MAGENTA);
                label[i].setForeground(Color.YELLOW);
                label[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
                add(label[i]);
            }

            JButton btn = new JButton("Roll the Dice");
            btn.setSize(150, 50);
            btn.setLocation(60, 60);
            add(btn);
        }
    }
}
