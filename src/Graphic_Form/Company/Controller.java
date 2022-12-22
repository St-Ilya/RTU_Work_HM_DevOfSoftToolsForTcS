package Graphic_Form.Company;

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

    public void addComCol(CompanyColumns companyColumns) {
        db.addCompanyToDatabase(companyColumns);
    }

    public List<CompanyColumns> getComCol() {
        return db.getCompanyColumns();
    }
}
