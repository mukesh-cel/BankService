package Service;

import Models.Customer;
import Models.Giftcard;
import Repository.BankRepository;
import Repository.GiftcardRepository;

import java.util.List;
import java.util.Scanner;

public class BankService {

    BankRepository bankRepository= new BankRepository();
    GiftcardRepository giftcardRepository= new GiftcardRepository();
    Giftcard giftcard= new Giftcard();

    public void startbank(List<Customer> customers){
        bankRepository.savecustomerlogininfo(customers);
    }

    public Customer AccountLogin(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter name");
        String name=scn.nextLine();
        System.out.println("Enter password");
        String pswd=scn.nextLine();
        String savedpswd= bankRepository.getcustomerpswd(name);
        if(savedpswd.equals(pswd)){
            System.out.println("Login Successfull");
            return bankRepository.getcustomer(name);

        }
        else{
            System.out.println("Incorrect passowrd");
            return null;
        }
    }

    public Giftcard creategiftcard(Customer customer){
        Giftcard giftcard=  new Giftcard();
        giftcard.setCustomer(customer);
        customer.setGiftcard(giftcard);
        System.out.println("card digit :" + giftcard.getDigit());
        System.out.println("card pin :" + giftcard.getPin());
        System.out.println("card username :" + giftcard.getCustomer().getName());
        giftcardRepository.savegiftcard(giftcard.getDigit(),giftcard);
        return giftcard;
    }

    public void topup(Customer customer){
        Giftcard giftcard= customer.getGiftcard();
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the topup amount");
        int amount = scn.nextInt();
        customer.setMainaccountbalance(customer.getMainaccountbalance() - amount);
        giftcard.setTopup(giftcard.getTopup() + amount);
        System.out.println("Topup amount:" + giftcard.getTopup() + "to" + giftcard.getCustomer().getName());
    }

    public void transactionhistory(){
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the giftcard number");
        int digit = scn.nextInt();
        Giftcard giftcard= giftcardRepository.getgitcard(digit);
        System.out.println(giftcard.getDigit());
        System.out.println(giftcard.getTopup());
        System.out.println(giftcard.getCustomer().getName());
    }

    public void blockcard(){
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the giftcard number");
        int digit = scn.nextInt();
        Giftcard giftcard= giftcardRepository.getgitcard(digit);
        Customer customer= giftcard.getCustomer();
        customer.setMainaccountbalance(customer.getMainaccountbalance()+giftcard.getTopup());
        giftcardRepository.deletecard(digit);
        System.out.println("Card blocked successfully");
    }
    public Giftcard logintogitcard(){
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the giftcard number");
        int digit = scn.nextInt();
        System.out.println("enter the pin");
        int pin=scn.nextInt();
        Giftcard giftcard= giftcardRepository.getgitcard(digit);
        if(giftcard.getPin()==pin){
            return giftcard;
        }
        System.out.println("enter correct giftcard number or pin");
        return null;
    }

    public void purchsse(Giftcard giftcard){
        Scanner scn = new Scanner(System.in);
        System.out.println("enter the purchase money");
        int money = scn.nextInt();
        if(money<=giftcard.getTopup()){
            System.out.println("purchased successfully");
            double rewardpoints=money*(0.01);
            if(rewardpoints==10){
                giftcard.getCustomer().setMainaccountbalance(giftcard.getCustomer().getMainaccountbalance()+10);
            }
            giftcard.setRewardpoints(giftcard.getRewardpoints()+rewardpoints);
            giftcard.setTopup(giftcard.getTopup()-money);
        }
        else{
            System.out.println("topup up to purchase insufficient balance");
        }
    }

    public void redeem(Giftcard giftcard){
        System.out.println(giftcard.getRewardpoints());
    }
}
