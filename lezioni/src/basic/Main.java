package basic;

public class Main {
    public static void main(String[] args) {
        int a = 12;
        a = 24;
        Data x = null;
        x = new Data(23, 12, 1986);
        x = new Data(1999);
        x.capodanno();
        int w = x.getAnno();

        String name = new String("ingSoft");
        CourseInfo ingSoft = new CourseInfo(name, 30);

        StudentType t1 = StudentType.ARCH;
        StudentType t2 = StudentType.ARCH;
        Student s1 = new Student("Pluto", t1);
        s1.addInfo(ingSoft);

        int result = Student.getNumStudents();

        int r1 = s1.numEsamiSostenuti();
        int r2 = s1.numEsamiSostenuti(24);

    }

}