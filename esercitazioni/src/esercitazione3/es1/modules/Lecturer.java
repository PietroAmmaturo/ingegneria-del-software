package esercitazione3.es1.modules;

public class Lecturer extends Faculty {
    private int personCode;

    public Lecturer(String name, String surname, int personCode) {
        super(name, surname);
        this.personCode = personCode;
    }

    public String toString() {
        return "Lecturer: " + getName() + " " + getSurname() + " " + personCode;
    }
}
