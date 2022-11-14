package pattern.factory;

public abstract class Student {

    public Exam produceExam() {
        return examFactory();
    }
    // protected: solo le sottoclassi possono accedere a questo metodo
    protected abstract Exam examFactory();

}
