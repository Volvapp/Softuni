package org.modelmapperex.service.impl;

import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.modelmapperex.data.entities.Game;
import org.modelmapperex.data.repositories.GameRepository;
import org.modelmapperex.service.GameService;
import org.modelmapperex.service.dtos.GameAddDto;
import org.modelmapperex.service.dtos.GamesAllDto;
import org.modelmapperex.util.ValidatorService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ValidatorService validatorService;
    private final ModelMapper mapper;

    public GameServiceImpl(GameRepository gameRepository, ValidatorService validatorService, ModelMapper mapper) {
        this.gameRepository = gameRepository;
        this.validatorService = validatorService;
        this.mapper = mapper;
    }

    @Override
    public String addGame(GameAddDto gameAddDto) {
        if (!this.validatorService.isValid(gameAddDto)) {
            return this.validatorService.validate(gameAddDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
        }
        Game game = this.mapper.map(gameAddDto, Game.class);
        this.gameRepository.saveAndFlush(game);

        return String.format("Added %s", game.getTitle());
    }

    @Override
    public String editGame(long id, Map<String, String> map) {
        Optional<Game> optionalGame = this.gameRepository.findById(id);
        if (optionalGame.isEmpty()) {
            return "No such game exists with given id.";
        }
        Game game = optionalGame.get();
        String output = String.format("Edited %s", game.getTitle());

        for (Map.Entry<String, String> entry : map.entrySet()) {
            switch (entry.getKey()) {
                case "title":
                    game.setTitle(entry.getValue());
                    break;
                case "price":
                    game.setPrice(Double.parseDouble(entry.getValue()));
                    break;
                case "size":
                    game.setSize(Double.parseDouble(entry.getValue()));
                    break;
            }
        }
        this.gameRepository.saveAndFlush(game);
        return output;
    }

    @Override
    public String deleteGame(long id) {

        Optional<Game> optional = this.gameRepository.findById(id);

        if (optional.isEmpty()) {
            return "No such game with given id.";
        }
        String output = String.format("Deleted %s", optional.get().getTitle());
        this.gameRepository.delete(optional.get());
        return output;
    }

    @Override
    public Set<GamesAllDto> getAllGames() {
        return this.gameRepository.findAll()
                .stream()
                .map(game -> this.mapper.map(game, GamesAllDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public String allGamesReadyForPrint() {
        return this.getAllGames().stream().map(GamesAllDto::toString).collect(Collectors.joining("\n"));
    }
}
