package thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ThreadInterruptEx extends JFrame {
    private Thread th;

    public ThreadInterruptEx() {
        setTitle("ThreadInterruptEx 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));

        TimerRunnable runnable = new TimerRunnable(timerLabel);
        th = new Thread(runnable);
        c.add(timerLabel);

        JButton btn = new JButton("kill Timer");
        btn.addActionListener(new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {
                th.interrupt();
                JButton btn = (JButton)e.getSource();
                btn.setEnabled(false);
            }
        });
        c.add(btn);

        setSize(300,170);
        setVisible(true);;
        th.start();
    }

    public static void main(String[] args){
        new ThreadInterruptEx();
    }
}
