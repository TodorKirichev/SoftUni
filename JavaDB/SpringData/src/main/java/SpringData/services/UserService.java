package SpringData.services;

import java.math.BigDecimal;

public interface UserService {

    void register(String username,int age, BigDecimal initialAmount);

    void addAccount(BigDecimal amount, long id);
}
