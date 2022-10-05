package exceptions;

public class Student {
    private final static int capacity = 50;
    private int size;
    private static int numStudents = 0;

    private final String name;
    private final CourseInfo[] courseInfo;

    private StudentType type;

    public Student(String name, StudentType type) {
        this.size = 0;
        this.name = name;
        this.type = type;
        this.courseInfo = new CourseInfo[capacity];
        numStudents++;
    }

    public String getName() {
        return name;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public void addInfo(CourseInfo info) {
        this.courseInfo[size] = info;
        size++;
    }

    public float getMedia() throws NonHaFattoEsamiException {
        if(size == 0) {
            throw new NonHaFattoEsamiException();
        }
        int sum = 0;
        for (int i=0; i<size; i++) {
            CourseInfo info = courseInfo[i];
            sum += info.getVoto();
        }
        return ((float) sum) / size;
    }

    public int numEsamiSostenuti() {
        return size;
    }

    public int numEsamiSostenuti(int min) {
        int count = 0;
        for (int i=0; i<size; i++) {
            CourseInfo info = courseInfo[i];
            if (info.getVoto() > min) count++;
        }
        return count;
    }














}
