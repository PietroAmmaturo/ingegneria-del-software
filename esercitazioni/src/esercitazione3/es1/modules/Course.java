package esercitazione3.es1.modules;

public class Course {
    private String name;
    private Lecturer lecturer;
    private TeachingAssistant teachingAssistant;
    private Lecture[] lectures;
    private Team team1;
    private Team team2;

    public Course(String name, Lecturer lecturer, TeachingAssistant teachingAssistant, Lecture[] lectures,
            Student[] students, Team team1, Team team2) {
        this.name = name;
        this.lecturer = lecturer;
        this.teachingAssistant = teachingAssistant;
        this.lectures = lectures;
        this.team1 = team1;
        this.team2 = team2;
    }

    public String getName() {
        return name;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public TeachingAssistant getTeachingAssistant() {
        return teachingAssistant;
    }

    public Lecture[] getLecture() {
        return lectures;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void addStudent(Student student) {
        if (student.getMatricola() % 2 == 0) {
            team1.addStudent(student);
        } else {
            team2.addStudent(student);
        }
    }

    public void printStudents() {
        team1.printStudents();
        team2.printStudents();
    }

    public void addLecture(Lecture lecture) {
        this.lectures = new Lecture[lectures.length];
        this.lectures[lectures.length] = lecture;
    }

    public void printLectures() {
        int i;
        for (i = 0; i < lectures.length; i++) {
            lectures[i].toString();
        }
    }

    public void sendMail(String mail) {
        team1.sendMail(mail);
        team2.sendMail(mail);
        int i;
    }

}
