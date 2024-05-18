package Models;

import Service.BankService;

import java.util.List;

public class Bank {

    private BankService bankService= new BankService();
    private List<Customer> customerList;

    public Bank(List<Customer> customerList) {
        this.customerList = customerList;
        bankService.startbank(customerList);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
