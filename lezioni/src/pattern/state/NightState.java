package pattern.state;

public class NightState implements PhoneState{
    protected Phone myPhone;

    public NightState(Phone myPhone) {
        this.myPhone = myPhone;
    }
    public void receiveCall() {
        System.out.println("not ring");
    }

    public void receiveMessage() {
        System.out.println("not ring");

    }
}
