package SpringData.services;

import SpringData.models.Account;
import SpringData.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, long id) {
        Account account = accountRepository.findById(id).orElseThrow();
    }

    @Override
    public void transferMoney(BigDecimal amount, long id) {

    }
}
