package Graphic_Form;

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

    public void addEmplyee(Employee employee) {
        db.addEmployeeToDatabase(employee);
    }

    public List<Employee> getEmployes() {
        return db.getEmployees();
    }
}
