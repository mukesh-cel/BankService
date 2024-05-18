package Controllers;

import Models.Customer;
import Models.Giftcard;
import Service.BankService;

import java.util.List;

public class BankController {
    BankService bankService= new BankService();
    public void startbank(List<Customer> customers){
         bankService.startbank(customers);
    }
    public Customer AccountLogin(){
        return bankService.AccountLogin();
    }
    public Giftcard creategiftcard(Customer customer){
         return bankService.creategiftcard(customer);
    }
    public void topup(Customer customer){
        bankService.topup(customer);
    }
    public void transactionhistory(){
        bankService.transactionhistory();
    }
    public void blockcard(){
        bankService.blockcard();
    }
    public Giftcard logintogitcard(){
        return bankService.logintogitcard();
    }
    public void purchsse(Giftcard giftcard){
        bankService.purchsse(giftcard);
    }
    public void redeem(Giftcard giftcard){
        bankService.redeem(giftcard);
    }
}
