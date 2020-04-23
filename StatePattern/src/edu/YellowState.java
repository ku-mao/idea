package edu;

public class YellowState extends AccountState {
    @Override
    public void stateCheck(Account accout) {
        if (accout.getBalance() >= 0) {
            accout.setState(new GreenState());
        } else if (accout.getBalance() < -1000) {
            accout.setState(new RedState());
        }
    }
    @Override
    public String toString() {
        return "YellowState";
    }
}
