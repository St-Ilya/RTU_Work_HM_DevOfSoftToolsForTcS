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

                Employee employee = new Employee(nameText);
                controller.addEmplyee(employee);
                String message = "Correct";

                JOptionPane.showMessageDialog(new JFrame(), employee.toString(), "Input Information OK",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }



    public JPanel getPassenger() {
        return Passenger;
    }
}
