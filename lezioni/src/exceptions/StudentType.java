package exceptions;

public enum StudentType {
    ING(7),
    ARCH(5),
    DES(3);

    private final int incremento;

    private StudentType(int incremento) {
        this.incremento = incremento;
    }

    public int getIncremento() {
        return incremento;
    }
}
