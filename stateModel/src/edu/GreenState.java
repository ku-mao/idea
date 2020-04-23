package edu;

public class GreenState extends AccountState {
    @Override
    public void stateCheck(Account account) {
        if (account.getBalance() < 0 && account.getBalance() >= -1000) {
            account.setState(new YellowState());
        }else if (account.getBalance() < -1000){
            account.setState(new RedState());
        }
    }
    @Override
    public String toString() {
        return "GreenState";
    }
}
