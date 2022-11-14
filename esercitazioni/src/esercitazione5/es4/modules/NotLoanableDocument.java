package esercitazione5.es4.modules;
public abstract class NotLoanableDocument extends Document {
    public NotLoanableDocument(String title, String summary, String author, int code) {
        super(title, summary, author, code);
    }

    public final void loanDocument() {
        System.out.println("DOCUMENT WITH CODE "+getCode()+" IS NOT LOANABLE!");
    }

    public final void returnDocument() {
        System.out.println("DOCUMENT WITH CODE "+getCode()+" IS NOT LOANABLE!");
    }

    public final boolean isLoanable () {return false;}

}
