package Graphic_Form.Company;

public class CompanyColumns {

    private String name;

    public CompanyColumns(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CompanyColumns{" +
                "name='" + name + '\'' +
                '}';
    }
}
