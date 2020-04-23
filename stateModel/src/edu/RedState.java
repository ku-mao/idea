package edu;

public class RedState extends AccountState {
    @Override
    public void stateCheck(Account account) {
        if (account.getBalance() >= 0) {
            account.setState(new GreenState());
        } else if (account.getBalance() < 0 && account.getBalance() >= -1000) {
            account.setState(new YellowState());
        }
    }
    @Override
    public String toString() {
        return "RedState";
    }
}
