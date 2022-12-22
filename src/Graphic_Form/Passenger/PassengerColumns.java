package Graphic_Form.Passenger;

public class PassengerColumns {
    private String name;

    public PassengerColumns(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PassengerColumns{" +
                "name='" + name + '\'' +
                '}';
    }
}
