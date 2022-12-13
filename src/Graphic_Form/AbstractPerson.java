package Graphic_Form;

public abstract class AbstractPerson implements HumanInterface{
    private String name;

    AbstractPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AbstractPerson{" +
                "name='" + name + '\'' +
                '}';
    }
}
