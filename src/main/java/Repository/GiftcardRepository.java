package Repository;

import Models.Giftcard;

import java.util.HashMap;

public class GiftcardRepository {
    public HashMap<Integer, Giftcard> giftcardrepo= new HashMap<>();
    //public HashMap<Integer, Integer> giftcardloginmap= new HashMap<>();

    public void savegiftcard(int digit,Giftcard giftcard){
        //Integer digit=giftcard.getDigit();
        System.out.println(digit);
        if(!giftcardrepo.containsKey(digit)){
            System.out.println("save card");
            giftcardrepo.put(digit,giftcard);
            //Giftcard giftcard1=giftcardrepo.get(11114);
           // giftcard1.getCustomer().getName();
        }

    }

    public Giftcard getgitcard(int digit){
        if(giftcardrepo.containsKey(digit)){
            return giftcardrepo.get(digit);
        }
        else{
            System.out.print("Enter correct giftcard digits");
            return null;
        }
    }
    public void deletecard(int digit){
        giftcardrepo.remove(digit);
    }

}
