package esercitazione3.es1.modules;

public class Team {
    private Student[] students;

    public void addStudent(Student student) {
        int i;
        for (i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                return;
            }
        }
        this.students = new Student[students.length];
        this.students[students.length] = student;
    }

    public void printStudents() {
        int i;
        for (i = 0; i < students.length; i++) {
            students[i].toString();
        }
    }

    public void sendMail(String mail) {
        int i;
        for (i = 0; i < students.length; i++) {
            students[i].getMailBox().reciveMail(mail);
        }
    }
}
