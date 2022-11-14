package pattern.state;

public class NormalState implements PhoneState{
    protected Phone myPhone;

    public NormalState(Phone myPhone) {
        this.myPhone = myPhone;
    }
    public void receiveCall() {
        System.out.println("ring");
    }

    public void receiveMessage() {
        System.out.println("ring");

    }
}
