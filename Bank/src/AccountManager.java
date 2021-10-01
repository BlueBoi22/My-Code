import java.math.BigDecimal;

public class AccountManager{

    public static void main(String[] args){
        Account myAccount = new Account("FirstAccount","10.00");
        System.out.println("Account Created: " + myAccount.name);
        System.out.println("Balance: " + myAccount.amount);
        myAccount.amount = new BigDecimal("-15.00");
        System.out.println("New Balance: " + myAccount.amount);
    }
       
    public String getName(){
        return this.name;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }
    
    public void setName(String newName){
        this.name = newName;
    }

    public void setName(String newName){
        String pattern = "^[a-zA-Z0-9]*$";
        if (newName.matches(pattern)){
            this.name = newName;
        }
    }

    private void setAmount(String newAmount){
        
    }
}