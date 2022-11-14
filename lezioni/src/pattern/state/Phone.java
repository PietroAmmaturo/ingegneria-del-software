package pattern.state;

// ReceiveCall and ReceiveMessage should behave differently depending on the state
// Normal -> ring in both cases
// Silent -> ring only for calls
// Night -> never rings
public class Phone {
    private PhoneState state;

    public Phone() {
        state = new NormalState(this);
    }

    public void receiveCall() {
        state.receiveCall();
    }

    public void receiveMessage() {
        state.receiveMessage();
    }

    public void setState(PhoneState newState) {
        state = newState;
    }
}
