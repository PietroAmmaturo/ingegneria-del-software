package esercitazione3.es1.modules;

public class Student extends Person {
    private final int matricola;
    private MailBox mailBox;

    public Student(String name, String surname, int matricola) {
        super(name, surname);
        this.matricola = matricola;
        this.mailBox = new MailBox();
    }

    public int getMatricola() {
        return this.matricola;
    }

    public MailBox getMailBox() {
        return this.mailBox;
    }

    public String toString() {
        return "Student: " + getName() + " " + getSurname() + " " + matricola;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + matricola;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (matricola != other.matricola)
            return false;
        return true;
    }

}
