package dialog;

import javax.swing.*;

public class MyModalDialog extends JDialog {
    JTextField tf = new JTextField(10);
    JButton okButton = new JButton("OK");

    public MyModalDialog(JFrame frame, String title) {
        super(frame, title, true);
        setLayout(new java.awt.FlowLayout());
        add(tf);
        add(okButton);
        okButton.addActionListener(e -> {
            setVisible(false);
        });
        setSize(200, 100);
    }

    public String getInput() {
        if(tf.getText().length() == 0)
            return null;
        else
            return tf.getText();
    }

    public void run() {
        System.out.println("MyModalDialog is running");
    }
}
