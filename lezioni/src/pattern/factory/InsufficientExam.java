package pattern.factory;

public class InsufficientExam extends Exam {
    private final String esito = "insufficiente";

    public InsufficientExam() {
    }

    public String getEsito() {
        return esito;
    }

    
}
