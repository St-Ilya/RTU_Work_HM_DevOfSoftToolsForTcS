package Graphic_Form.Passenger;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    DataBase db = new DataBase();

    public Controller() {
        try {
            db.connect();
            db.getFromDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPassenger(PassengerColumns passengerColumns) { //addEmplyee = addPassenger
        db.addPassengerToDatabase(passengerColumns);
    }

    public List<PassengerColumns> getPass() {
        return db.getPass();
    }
}
