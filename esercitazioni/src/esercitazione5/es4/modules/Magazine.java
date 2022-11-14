package esercitazione5.es4.modules;
public class Magazine extends LoanableDocument{
    final private int edition;

    public Magazine (String title, String summary, String author, int code, int edition){
        super(title, summary, author, code);
        this.edition = edition;
    }

    public int getEdition() {
        return edition;
    }

    public String toString () {
        return super.toString() + "\nEdition: " + edition;
    }

}
