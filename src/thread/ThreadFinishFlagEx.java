package thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThreadFinishFlagEx  extends JFrame {
    private RandomThread th;

    public ThreadFinishFlagEx() {
        setTitle("ThreadFinishFlagEx 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        c.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                th.finish();
            }
        });
        setSize(300,200);
        setVisible(true);

        th = new RandomThread(c);
        th.start();
    }

    public static void main(String[] args){
        new ThreadFinishFlagEx();
    }
}
