import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    private String name;
    private BigDecimal amount;

    public Account(String acctName, String startAmount){
        setName(acctName);
        setAmount(startAmount);
        amount.setScale(2, RoundingMode.HALF_UP);
    }

    public String getName(){
        return this.name;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public void setName(String newName){
        String pattern = "^[a-zA-Z0-9]*$";
        if (newName.matches(pattern)){
            this.name = newName;
        }
    }

    private void setAmount(String newAmount){
        this.amount = new BigDecimal(newAmount);
    }

    public void withdraw(String withdraw) throws IllegalArgumentException{
        BigDecimal desiredAmount = new BigDecimal(withdraw);
        if (desiredAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException();
        }
        if (amount.compareTo(desiredAmount) < 0){
            throw new IllegalArgumentException();
        }
        this.amount = this.amount.subtract(desiredAmount);
    }

    public void deposit(String deposit) throws IllegalArgumentException{
        BigDecimal desiredAmount = new BigDecimal(deposit);
        if(desiredAmount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException();
        }

        this.amount.add(desiredAmount);
    }
}