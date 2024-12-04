package dialog;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DialogEx2 extends JFrame {
    MyModalDialog dialog;

    public DialogEx2() {
        super("DialogEx2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btn = new JButton("Show Dialog");

        dialog = new MyModalDialog(this, "Test Dialog");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dialog.setVisible(true);
                String input = dialog.getInput();
                if(input == null)
                    System.out.println("You have canceled the dialog.");
                else
                    System.out.println("You entered: " + input);
            }
        });
        getContentPane().add(btn);
        setSize(250, 200);
        setVisible(true);
    }
    public static void main(String[] args){
        new DialogEx2();
    }
}
