package pattern.decorator;

public class CapitalMessagePrinter extends MessagePrinter {
    private final MessagePrinter printer;

    public CapitalMessagePrinter(MessagePrinter printer) {
        this.printer = printer;
    }
    public void print(String message) {
        printer.print(message.toUpperCase());
    }
}
