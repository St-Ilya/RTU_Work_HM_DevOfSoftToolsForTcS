package Graphic_Form;

import Graphic_Form.Company.Company_App;
import Graphic_Form.Passenger.Passenger_App;
import Log.LogClass;

import javax.swing.*;

//
public class App {
    public static void main(String[] args) {
        LogClass.MyLog();

        Passenger_App passenger_app = new Passenger_App();
        JFrame framePassenger = new JFrame("Passenger_App");
        framePassenger.setContentPane(passenger_app.getPassenger());
        framePassenger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePassenger.pack();
        framePassenger.setVisible(true);

        Company_App company_app = new Company_App();
        JFrame frameCompany = new JFrame("Company_App");
        frameCompany.setContentPane(company_app.getCompany());
        frameCompany.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCompany.pack();
        frameCompany.setVisible(true);
    }
}
