import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AccountTest {
    private Account account;
    private static final String NOT_EXPECTED_BALANCE_MESSAGE = "Баланс счета не соотвествует ожидаемому";
    private static final String NOT_EXPECTED_NUMBER_ACC_MESSAGE = "Балансе счета не соотвествует ожидаемому";
    private static final String NOT_EXPECTED_BLOCK_ACC_MESSAGE = "Флаг блокировки счета не соотвествует ожидаемому";
    private static final double DELTA = 0.01;

    @BeforeEach
    protected void setUp() {
        String accountNumber = "1";
        long money = 10_000;
        account = new Account(accountNumber, money);
    }

    @Test
    public void setMoney(){
        account.setMoney(5_000);
        assertEquals(5_000, account.getMoney(), DELTA, NOT_EXPECTED_BALANCE_MESSAGE);
    }

    @Test
    public void setAccNumber() {
        account.setAccNumber("10");
        assertEquals("10", account.getAccNumber(), NOT_EXPECTED_NUMBER_ACC_MESSAGE);
    }

    @Test
    public void setWithoutBlockAcc() {
        account.setWithoutBlockAcc(false);
        assertFalse(account.isWithoutBlockAcc(), NOT_EXPECTED_BLOCK_ACC_MESSAGE);
    }

}
