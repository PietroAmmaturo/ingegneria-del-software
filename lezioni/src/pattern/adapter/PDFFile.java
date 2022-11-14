package pattern.adapter;

public class PDFFile extends LibPDFFile implements Printable{
    public void print (int size) {
        stampa(size * 2);
    }
    
}
