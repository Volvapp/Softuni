package org.modelmapperex.service;

import org.modelmapperex.service.dtos.GameAddDto;
import org.modelmapperex.service.dtos.GamesAllDto;

import java.util.Map;
import java.util.Set;

public interface GameService {
    String addGame(GameAddDto gameAddDto);

    String editGame(long id, Map<String, String> map);

    String deleteGame(long id);

    Set<GamesAllDto> getAllGames();

    String allGamesReadyForPrint();
}
