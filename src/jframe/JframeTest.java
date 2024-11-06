package jframe;

import javax.swing.*;
import java.awt.*;

public class JframeTest extends JFrame {
    public JframeTest() {
        setTitle("300x300 스윙 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
        c.add(new JButton("add"));
        c.add(new JButton("sub"));
        c.add(new JButton("mul"));
        c.add(new JButton("div"));
        c.add(new JButton("Calculate"));

        setSize(300,200); // 프레임 크기 300x200
        setVisible(true); // 프레임 출력
    }

    public static void main(String[] args) {
        JframeTest frame = new JframeTest();
    }
}
