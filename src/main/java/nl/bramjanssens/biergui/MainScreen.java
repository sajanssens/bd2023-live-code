package nl.bramjanssens.biergui;

import nl.bramjanssens.oo.BierDao;
import nl.bramjanssens.oo.records.Bier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen {

    private JPanel rootPane;

    private JTextField naamField;
    private JComboBox<Double> alcCombo;
    private JSpinner volumeSpinner;
    private JButton opslaanButton;

    private BierDao dao = BierDao.getInstance();

    public MainScreen() {
        alcCombo.addItem(5.0);
        alcCombo.addItem(8.0);
        alcCombo.addItem(11.0);

        volumeSpinner.setValue(100);

        opslaanButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                String naam = naamField.getText();
                double alc = (double) alcCombo.getSelectedItem();
                int volume = (int) volumeSpinner.getValue();

                Bier nieuw = dao.nieuw(naam, alc, volume);
                dao.voegToe(nieuw);
                System.out.println("Dit zijn je biertjes: ");
                dao.getAll().forEach(System.out::println);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bier");
        frame.setContentPane(new MainScreen().rootPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
