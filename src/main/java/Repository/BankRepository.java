package Repository;

import Models.Customer;

import java.util.HashMap;
import java.util.List;

public class BankRepository {
    HashMap<String,String> customerdetails=new HashMap<>();
    HashMap<String,Customer> customermap=new HashMap<>();
    public String encryptpassword(String password){
        char[] array= password.toCharArray();
        StringBuilder str= new StringBuilder();
        for(char c:array){
            c+=1;
            str.append(c);
        }
        //System.out.print("encrypt"+ str);
        return str.toString();
    }
    public String decryptpassword(String password){
        char[] array= password.toCharArray();
        StringBuilder str= new StringBuilder();
        for(char c:array){
            c-=1;
            str.append(c);
        }
        //System.out.print("decrypt"+ str);
        return str.toString();
    }
    public void savecustomerlogininfo(List<Customer> customers){
        for(Customer c:customers){
            String username=c.getName();
            String password=c.getPassowrd();
            String newpswd= encryptpassword(password);

            if(!customerdetails.containsKey(username)){
                customerdetails.put(username,newpswd);
                customermap.put(username,c);
            }
            else {
                System.out.println("customer name already exists");
            }
        }
    }

    public String getcustomerpswd(String name){

        String decyptpswd="";
        if(customerdetails.containsKey(name)){
            decyptpswd=decryptpassword(customerdetails.get(name));
        }
        else {
            System.out.println("user does not exist");
        }
        return decyptpswd;
    }
    public Customer getcustomer(String name){
        if(customermap.containsKey(name)){
            return customermap.get(name);
        }
        return null;
    }

}
