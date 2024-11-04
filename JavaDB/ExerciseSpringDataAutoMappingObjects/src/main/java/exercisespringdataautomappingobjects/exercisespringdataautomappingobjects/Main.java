package exercisespringdataautomappingobjects.exercisespringdataautomappingobjects;

import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.dto.GameAddDto;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.dto.UserLoginDto;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.dto.UserRegisterDto;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.service.GameService;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final Scanner scan;
    private final UserService userService;
    private final GameService gameService;

    public Main(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.scan = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            System.out.println("Enter command: ");
            String[] input = scan.nextLine().split("\\|");

            switch (input[0]) {
                case "RegisterUser": userService.register(new UserRegisterDto(input[1], input[2], input[3], input[4]));
                break;

                case "LoginUser": userService.login(new UserLoginDto(input[1], input[2]));
                break;

                case "Logout" : userService.logout();
                break;

                case "AddGame": gameService.addGame(new GameAddDto(input[1], new BigDecimal(input[2]), Double.parseDouble(input[3]),
                        input[4], input[5], input[6], input[7]));
                break;
            }
        }
    }
}
