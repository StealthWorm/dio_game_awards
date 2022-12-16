package me.dio.gameawards.service.impl;

import me.dio.gameawards.exception.BusinessException;
import me.dio.gameawards.exception.NoContentException;
import me.dio.gameawards.model.Game;
import me.dio.gameawards.repository.GameRepository;
import me.dio.gameawards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll(Sort.by(Sort.Direction.DESC, "votes"));
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new NoContentException(id));
    }

    @Override
    public void insert(Game game) {
        if (game.getId() != null) {
            throw new BusinessException("O ID é diferente de Null.");
        }
        gameRepository.save(game);
    }

    @Override
    public void update(Long id, Game game) {
        Game gameDb = findById(id);

        gameDb.setName(game.getName());
        gameDb.setCover(game.getCover());
        gameDb.setDescription(game.getDescription());
        gameDb.setVotes(game.getVotes());
//        if (gameDb.getId().equals(game.getId())) {
            gameRepository.save(gameDb);
//        } else {
//            throw new BusinessException("Os IDs para modificação são divergentes");
//        }
    }

    @Override
    public void delete(Long id) {
        findById(id);
        gameRepository.deleteById(id);
    }

    @Override
    public void vote(Long id) {
        Game gabeDb = findById(id);
        gabeDb.setVotes(gabeDb.getVotes() + 1);

        update(id, gabeDb);
    }
}
