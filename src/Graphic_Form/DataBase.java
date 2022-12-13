package Graphic_Form;

import org.postgresql.core.SqlCommand;

import javax.naming.Name;
import java.sql.*;
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
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost:5432/Graphic_Avia";
        con = DriverManager.getConnection(url, "postgres", "3421www5");
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

    public void count() throws SQLException {
        String sql = "SELECT count(*) from passenger";
        PreparedStatement sqlStmt = con.prepareStatement(sql);
        ResultSet checkResult = sqlStmt.executeQuery();

        checkResult.next();
        int count = checkResult.getInt(1);

        System.out.println("Count for person is " + count + ".");

        sqlStmt.close();
    }

    public void addEmployeeToDatabase(Employee employee) {
        String name = employee.getName();
        String sql = "INSERT INTO passenger (name) VALUES ('"+name+"')";
        System.out.println("SQL = " + sql);

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getFromDatabase();
    }

    public void getFromDatabase() {
        employees.clear();

        String sql = "SELECT * FROM passenger";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                Employee temp = new Employee(set.getString("name"));
                addEmplyee(temp);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
