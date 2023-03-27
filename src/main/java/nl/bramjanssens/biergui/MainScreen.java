package nl.bramjanssens.biergui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen {

    private JPanel rootPane;

    private JTextField naamField;
    private JComboBox<Double> alcCombo;
    private JSpinner volumeSpinner;
    private JButton opslaanButton;

    public MainScreen() {
        alcCombo.addItem(5.0);
        alcCombo.addItem(8.0);
        alcCombo.addItem(11.0);

        volumeSpinner.setValue(100);
        opslaanButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BierApp");
        frame.setContentPane(new MainScreen().rootPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
