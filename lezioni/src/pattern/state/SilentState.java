package pattern.state;

public class SilentState implements PhoneState {
    protected Phone myPhone;

    public SilentState(Phone myPhone) {
        this.myPhone = myPhone;
    }
    public void receiveCall() {
        System.out.println("ring");
    }

    public void receiveMessage() {
        System.out.println("not ring");

    }
}
