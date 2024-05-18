package Models;

import java.util.List;

public class Giftcard {
    private Customer customer;
    public int topup;
    static int digit=11111;
    static int pin=1999;
    private double rewardpoints;
    public Giftcard(){
        this.digit++;
        this.pin++;
    }

    public double getRewardpoints() {
        return rewardpoints;
    }

    public void setRewardpoints(double rewardpoints) {
        this.rewardpoints = rewardpoints;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getTopup() {
        return topup;
    }

    public void setTopup(int topup) {
        this.topup = topup;
    }
}
