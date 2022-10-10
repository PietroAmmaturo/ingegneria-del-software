package esercitazione3.es1.modules;

public class TeachingAssistant extends Faculty{
    private int personCode;
    public TeachingAssistant(String name, String surname, int personCode) {
        super(name, surname);
        this.personCode = personCode;
    }

    public String toString() {
        return super.toString() + personCode;
    }
}
