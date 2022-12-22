package Graphic_Form.Company;

import java.sql.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DataBase {
    private List<CompanyColumns> companyColumns;

    private Connection con;

    public DataBase() {
        companyColumns = new LinkedList<CompanyColumns>();
    }

    private void addCompany(CompanyColumns company) {
        companyColumns.add(company);
    }

    public List<CompanyColumns> getCompanyColumns() {
        return Collections.unmodifiableList(companyColumns);
    }

    public void connect() throws SQLException {
        if(con != null) {
            return;
        }
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
        String sql = "SELECT count(*) from company";
        PreparedStatement sqlStmt = con.prepareStatement(sql);
        ResultSet checkResult = sqlStmt.executeQuery();

        checkResult.next();
        int count = checkResult.getInt(1);

        System.out.println("Count for person is " + count + ".");

        sqlStmt.close();
    }

    public void addCompanyToDatabase(CompanyColumns companyColumns) {
        String name = companyColumns.getName();
        String sql = "INSERT INTO company (name) VALUES ('"+name+"')";
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
        companyColumns.clear();

        String sql = "SELECT * FROM company";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            while (set.next()) {
                CompanyColumns temp = new CompanyColumns(set.getString("name"));
                addCompany(temp);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
