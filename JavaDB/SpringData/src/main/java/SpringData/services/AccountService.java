package SpringData.services;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal amount, long id);

    void transferMoney(BigDecimal amount, long id);
}
