import lombok.Data;

@Data
public class Account {

    private long money;
    private String accNumber;
    private boolean withoutBlockAcc;

    public Account(String accNumber, long money) {
        this.money = money;
        this.accNumber = accNumber;
        this.withoutBlockAcc = true;
    }

    public  boolean isWithoutBlockAcc() {
        return withoutBlockAcc;
    }

    public void setWithoutBlockAcc(boolean withoutBlockAcc) {
        this.withoutBlockAcc = withoutBlockAcc;

    }
}