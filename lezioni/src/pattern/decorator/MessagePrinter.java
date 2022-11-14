package pattern.decorator;

public class MessagePrinter implements MessagePrinterInterface{
    public void print(String message) {
        System.out.println(message);
    }
}
