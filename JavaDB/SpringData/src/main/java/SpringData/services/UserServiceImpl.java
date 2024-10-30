package SpringData.services;

import SpringData.models.Account;
import SpringData.models.User;
import SpringData.repositories.AccountRepository;
import SpringData.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AccountRepository accountRepository;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void register(String username, int age, BigDecimal initialAmount) {
        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        userRepository.save(user);

        Account account = new Account();
        account.setBalance(initialAmount);
        account.setUser(user);
        accountRepository.save(account);
    }

    @Override
    public void addAccount(BigDecimal amount, long id) {
        User user = this.userRepository.findById(id).orElseThrow();

        Account account = new Account();
        account.setBalance(amount);
        account.setUser(user);

        this.accountRepository.save(account);

    }
}
