package pattern.decorator;

public class Main {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new MessagePrinter();
        messagePrinter.print("Hello");
        // Vorrei costruire
        // 1. Un DoubleMessagePrinter che stampa il messaggio due volte
        MessagePrinter doublePrinter = new DoubleMessagePrinter(new MessagePrinter());
        doublePrinter.print("Hello");
        MessagePrinter capitalPrinter = new CapitalMessagePrinter((new MessagePrinter()));
        capitalPrinter.print("Hello");
        MessagePrinter doubleCapitalPrinter = new DoubleMessagePrinter(new CapitalMessagePrinter((new MessagePrinter())));
        doubleCapitalPrinter.print("Hello");

        // 2. Un CapitalMessagePrinter che stampa il messaggio tutto maiuscolo
        // Vorrei avere tutte le possibili combinazioni
        // (solo doppio, solo maiuscolo, doppio e maiuscolo, ...)

    }
}
