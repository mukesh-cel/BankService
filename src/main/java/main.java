import Controllers.BankController;
import Models.Customer;
import Models.Giftcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        BankController bankController= new BankController();

        List<Customer> customers= new ArrayList<>();
        Customer customer1= new Customer(1,"Mukesh","ABC");
        Customer customer2= new Customer(1,"Karthi","DEF");
        customers.add(customer1);
        customers.add(customer2);

        bankController.startbank(customers);

        Scanner scn = new Scanner(System.in);


        while(true) {
            System.out.println("enter  1 to  Login Account");
            System.out.println("enter 2 to purchase");
            System.out.println("enter 3 to exit ");
            int m= scn.nextInt();
            if(m==1) {
                Customer customer = bankController.AccountLogin();
                while (true) {
                    if (customer != null) {
                        System.out.println("enter 1 to create gift card");
                        System.out.println("enter 2 to topup gift card");
                        System.out.println("enter 3 to transacion history");
                        System.out.println("enter 4 to block card");
                        System.out.println("enter 5 to exit to main menu");
                        int n = scn.nextInt();
                        if (n == 1) {
                            Giftcard giftcard = bankController.creategiftcard(customer);
                        }
                        if (n == 2) {
                            bankController.topup(customer);
                        }
                        if (n == 3) {
                            bankController.transactionhistory();
                        }
                        if (n == 4) {
                            bankController.blockcard();
                        }
                        if (n == 5) {
                            break;
                        }
                    }
                }
            }
            if(m==2){
                Giftcard giftcard=bankController.logintogitcard();
                while(true){
                    System.out.println("enter 1 to purchase using this card "+ giftcard.getDigit());
                    System.out.println("enter 2 to check redeem points");
                    System.out.println("enter 3 to exit to main menu");
                    int n = scn.nextInt();
                    if (n == 1) {
                        bankController.purchsse(giftcard);
                    }
                    if (n == 2) {
                        bankController.redeem(giftcard);
                    }
                    if (n == 3) {
                        break;
                    }
                }
            }
            if(m==3){
                break;
            }
        }
    }
}
