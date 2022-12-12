package Graphic_Form;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        Travel_Tracking_App travel_tracking_app = new Travel_Tracking_App();
        JFrame frame = new JFrame("Travel_Tracking_App");
        frame.setContentPane(travel_tracking_app.getPassenger());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
