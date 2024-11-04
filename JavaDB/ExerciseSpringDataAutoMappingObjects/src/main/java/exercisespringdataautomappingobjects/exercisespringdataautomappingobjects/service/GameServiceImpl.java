package exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.service;

import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.dto.GameAddDto;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.model.entity.Game;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.repository.GameRepository;
import exercisespringdataautomappingobjects.exercisespringdataautomappingobjects.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);

        gameRepository.save(game);
    }
}
