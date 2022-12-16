package me.dio.gameawards.controller;

import me.dio.gameawards.controller.dto.GameCreateDTO;
import me.dio.gameawards.controller.mapper.GameMapper;
import me.dio.gameawards.model.Game;
import me.dio.gameawards.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/games")
public class GameController extends BaseRestController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameMapper gameMapper;

    @GetMapping
    public ResponseEntity<List<Game>> findAll() {
        List<Game> gameList = gameService.findAll();
//        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);

        return ResponseEntity.ok(gameList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id) {
        Game game = gameService.findById(id);
//        ParkingDTO result = parkingMapper.toParkingDTO(parking);

        return ResponseEntity.ok(game);
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game game) {
//        var parkingCreate = parkingMapper.toParkingCreate(dto);
        gameService.insert(game);
//        var result = parkingMapper.toParkingDTO(parking);

        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        gameService.delete(id);

//        return ResponseEntity.noContent().build();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody GameCreateDTO game) {
        var gameCreate = gameMapper.gameCreteDtoToGame(game);
        gameService.update(id, gameCreate);

        return ResponseEntity.status(HttpStatus.OK).body(gameCreate);
    }

    @PatchMapping("/{id}/vote")
    public ResponseEntity<Game> vote(@PathVariable Long id) {
        gameService.vote(id);

        return ResponseEntity.ok().build();
    }
}
