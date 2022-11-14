package pattern.adapter;
// vantaggio: non uso ereditarietà e non mi vincolo
// funzionerebbe anche se Printable fosse una classe
public class PDFFileComposition implements Printable {
    private final LibPDFFile libPDFFile;

    public PDFFileComposition() {
        this.libPDFFile = new LibPDFFile();
    }
    public void print (int size) {
        libPDFFile.stampa(size * 2);
    }
}
