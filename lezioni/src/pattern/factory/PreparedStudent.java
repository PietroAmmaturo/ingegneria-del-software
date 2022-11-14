package pattern.factory;

public class PreparedStudent extends Student {
    private final Integer matricola;
    private Exam exam;

    
    public PreparedStudent(Integer matricola) {
        this.matricola = matricola;
    }


    protected Exam examFactory() {
        exam = new SufficientExam();
        return exam;
    }

    public Integer getMatricola() {
        return matricola;
    }


    public Exam getExam() {
        return exam;
    }

    
}
