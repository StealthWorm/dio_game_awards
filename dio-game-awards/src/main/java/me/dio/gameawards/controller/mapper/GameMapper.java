package me.dio.gameawards.controller.mapper;

import me.dio.gameawards.controller.dto.GameCreateDTO;
import me.dio.gameawards.model.Game;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Game gameCreteDtoToGame(GameCreateDTO gameDTO) {
        return MODEL_MAPPER.map(gameDTO, Game.class);
    }
}
