package Graphic_Form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DataBase {
    private List<Employee> employees;
    private Connection con;

    public DataBase() {
        employees = new LinkedList<Employee>();
    }

    private void addEmplyee(Employee person) {
        employees.add(person);
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void connect() throws SQLException{
        if(con != null)
            return;
        try {
            Class.forName(" ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost:5432/Graphic_Avia";
        con = DriverManager.getConnection(url);
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void count() throws SQLException {}

    public void addEmployeeToDatabase(Employee employee) {}

    public void getFromDatabase() {}

}
