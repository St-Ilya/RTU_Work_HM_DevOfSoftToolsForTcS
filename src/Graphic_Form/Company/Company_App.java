package Graphic_Form.Company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Company_App extends Container {
    private JPanel Company;
    private JButton addButton;
    private JTextField nameTextField;

    public Company_App() {
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
                    JOptionPane.showMessageDialog(new JFrame(), errMessage,
                            "Input Information ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                CompanyColumns companyColumns = new CompanyColumns(nameText);
                controller.addComCol(companyColumns);
                String message = "Correct";

                JOptionPane.showMessageDialog(new JFrame(), companyColumns.toString(),
                        "Input Information OK", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public JPanel getCompany() {
        return Company;
    }
}
