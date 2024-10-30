package SpringData.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConsoleRunner implements CommandLineRunner {

    private UserService userService;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        try {

            userService.register("ivan", 23, new BigDecimal(1000));
        } catch (Exception e) {
            System.out.println("asd");
        }

        userService.addAccount(new BigDecimal(100), 1);
    }
}
