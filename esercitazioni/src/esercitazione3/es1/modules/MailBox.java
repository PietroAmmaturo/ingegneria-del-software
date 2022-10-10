package esercitazione3.es1.modules;

public class MailBox {
    private String address;
    private String[] mails;

    
    public String getAddress() {
        return address;
    }


    public String[] getMails() {
        return mails;
    }


    public void reciveMail(String mail) {
        this.mails = new String[mails.length];
        this.mails[mails.length] = mail;
    }
}
