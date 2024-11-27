package thread;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class DigitalClockFrame extends JFrame {
    public DigitalClockFrame() {
        setTitle("디지털 시계");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.add(new MyLabel());
        setSize(300,200);
        setVisible(true);
    }

    class MyLabel extends JLabel implements Runnable {
        private Thread timerThread = null;
        public MyLabel() {
            setText(makeClockText());
            setFont(new Font("timersRoman", Font.ITALIC, 60));
            setHorizontalAlignment(JLabel.CENTER);
            timerThread = new Thread(MyLabel.this);
            timerThread.start();
        }

        private String makeClockText() {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int min = c.get(Calendar.MINUTE);
            int second = c.get(Calendar.SECOND);

            String clockText = Integer.toString(hour);
            clockText = clockText.concat(":");
            clockText = clockText.concat(Integer.toString(min));
            clockText = clockText.concat(":");
            clockText = clockText.concat(Integer.toString(second));
            return clockText;
        }

        @Override
        public void run() {
            while(true) {
                setText(makeClockText());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

    }
    public static void main(String[] args){
        new DigitalClockFrame();
    }
}
