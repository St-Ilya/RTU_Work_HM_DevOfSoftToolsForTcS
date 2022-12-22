package Graphic_Form.Passenger;

import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DataBase {
    //Employee = PassengerColumns
    //employees = passengerColumnsList
    private List<PassengerColumns> passengerColumnsList;
    private Connection con;

    public DataBase() {
        passengerColumnsList = new LinkedList<PassengerColumns>();
    }

    private void addPassengerPerson(PassengerColumns person) { //addEmplyee = addPassengerPerson
        passengerColumnsList.add(person);
    }

    public List<PassengerColumns> getPass() { //getEmployees
        return Collections.unmodifiableList(passengerColumnsList);
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

    public void addPassengerToDatabase(PassengerColumns passengerColumns) {
        String name = passengerColumns.getName();
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
        passengerColumnsList.clear();

        String sql = "SELECT * FROM passenger";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                PassengerColumns temp = new PassengerColumns(set.getString("name"));
                addPassengerPerson(temp);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
