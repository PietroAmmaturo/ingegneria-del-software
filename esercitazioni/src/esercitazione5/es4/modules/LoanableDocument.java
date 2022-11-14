package esercitazione5.es4.modules;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public abstract class LoanableDocument extends Document {
    // classe astratta, non vogliamo istanziarla
    private boolean onLoan = false;
    private String loanDate;
    private static final String DATE_FORMAT_NOW = "yyyy-MM-dd";

    public LoanableDocument (String title, String summary, String author, int code){
        super(title, summary, author, code);
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public final void loanDocument() {
        if (!onLoan) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
            this.loanDate = sdf.format(cal.getTime());
            this.onLoan = true;
            System.out.println("DOCUMENT LOANED:\n" + this);
        }
        else {
            System.out.println("DOCUMENT WITH CODE " + this.getCode() + " IS ALREADY ON LOAN!");
        }
        // durante la prossima esercitazione vedremo le eccezioni
    }

    public final void returnDocument() {
        if (!onLoan) System.out.println("DOCUMENT WITH CODE " + this.getCode() + " IS NOT ON LOAN!");
        else {
            this.onLoan=false;
            this.loanDate=null;
        }
    }

    public final boolean isLoanable() {
        return true;
    }

    public String getLoanDate() {
        return loanDate;
    }

}
