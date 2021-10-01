import java.math.BigDecimal;

private class Account {
    String name;
    BigDecimal amount;

    private Account(String acctName, String startAmount){
        this.name = acctName;
        this.amount = new BigDecimal(startAmount);
        this.amount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}