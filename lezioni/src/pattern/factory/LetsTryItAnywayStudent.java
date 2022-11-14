package pattern.factory;

public class LetsTryItAnywayStudent extends Student {
    private final Integer matricola;
    private Exam exam;

    
    public LetsTryItAnywayStudent(Integer matricola) {
        this.matricola = matricola;
    }


    protected Exam examFactory() {
        exam = new InsufficientExam();
        return exam;
    }


    public Integer getMatricola() {
        return matricola;
    }


    public Exam getExam() {
        return exam;
    }

    
}
