package org.modelmapperex.service;

import org.modelmapperex.service.dtos.GameAddDto;
import org.modelmapperex.service.dtos.UserLoginDto;
import org.modelmapperex.service.dtos.UserRegisterDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\|");

            String command = "";
            switch (tokens[0]) {
                case "RegisterUser":
                    command = this.userService.registerUser(new UserRegisterDto(tokens[1], tokens[2], tokens[3], tokens[4]));
                    break;
                case "LoginUser":
                    command = this.userService.loginUser(new UserLoginDto(tokens[1], tokens[2]));
                    break;
                case "Logout":
                    command = this.userService.logout();
                    break;
                case "AddGame":
                    command = this.gameService.addGame(new GameAddDto(tokens[1], Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3])
                            , tokens[4], tokens[5], tokens[6], LocalDate.parse(tokens[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                    break;
                case "EditGame":
                    Map<String, String> map = Arrays.stream(tokens).skip(2).map(p -> p.split("="))
                            .collect(Collectors.toMap(p -> p[0], p -> p[1]));
                    command = this.gameService.editGame(Long.parseLong(tokens[1]), map);
                    break;
                case "DeleteGame":
                    command = this.gameService.deleteGame(Long.parseLong(tokens[1]));
                    break;
                case "AllGames":
                    command = this.gameService.allGamesReadyForPrint();
                    break;
            }
            System.out.println(command);
            input = bf.readLine();
        }
    }
}
