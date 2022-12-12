package Graphic_Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Travel_Tracking_App extends Container {
    private JPanel Passenger;
    private JTextField nameTextField;
    private JButton addButton;

    public Travel_Tracking_App() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Message text";
                JOptionPane.showMessageDialog(new JFrame(), message, "Windows title",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public JPanel getPassenger() {
        return Passenger;
    }
}
