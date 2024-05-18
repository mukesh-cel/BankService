package Models;

public class Customer {
    private int Id;
    private String Name;
    private String passowrd;
    private  Giftcard giftcard;
    private int mainaccountbalance;
    public Customer(int Id, String name, String passowrd){
        this.Id=Id;
        this.Name=name;
        this.passowrd=passowrd;

        this.mainaccountbalance=1000;
    }
    public int getMainaccountbalance() {
        return mainaccountbalance;
    }

    public void setMainaccountbalance(int mainaccountbalance) {
        this.mainaccountbalance = mainaccountbalance;
    }

    public Giftcard getGiftcard() {
        return giftcard;
    }

    public void setGiftcard(Giftcard giftcard) {
        this.giftcard = giftcard;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
}
