package pattern.decorator;

public class DoubleMessagePrinter extends MessagePrinter {
    private final MessagePrinter printer;

    public DoubleMessagePrinter(MessagePrinter printer) {
        this.printer = printer;
    }
    public void print(String message) {
        printer.print(message + message);
    }
}
