package Graphic_Form.Passenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Passenger_App extends Container {
    private JPanel Passenger;
    private JTextField nameTextField;
    private JButton addButton;

    public Passenger_App() {
        Controller controller = new Controller();
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean validInput = true;
                String errMessage = "Incorrect values in input fields: \n";

                String nameText = nameTextField.getText();
                if (nameText.isEmpty()) {
                    errMessage = errMessage + "\"Name\" field if empty";
                    validInput = false;
                }

                if (!validInput) {
                    JOptionPane.showMessageDialog(new JFrame(), errMessage, "Input Information ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                PassengerColumns passengerColumns = new PassengerColumns(nameText);
                controller.addPassenger(passengerColumns);
                String message = "Correct";

                JOptionPane.showMessageDialog(new JFrame(), passengerColumns.toString(), "Input Information OK",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }



    public JPanel getPassenger() {
        return Passenger;
    }
}
