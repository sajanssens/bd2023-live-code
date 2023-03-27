package nl.bramjanssens.pacman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen {
    private JButton button1;
    private JTextField textField1;
    private JCheckBox checkBox1;

    public MainScreen() {
        button1.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.out.println("KLIK!!");
            }
        });
    }
}
