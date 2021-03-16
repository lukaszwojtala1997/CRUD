package com.example.Crud.bookapi;

import com.example.Crud.bookmanager.GamesManager;
import com.example.Crud.bookdao.entity.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GamesApi {

    private GamesManager gamesManager;

    @Autowired
    public GamesApi(GamesManager gamesManager) {
        this.gamesManager = gamesManager;
    }

    @GetMapping("/allgames")
    public Iterable<Games> getAll(){
        return gamesManager.findGameAll();
    }

    @GetMapping
    public Optional<Games> getById(@RequestParam Long index){
        return gamesManager.findGameById(index);
    }

    @PostMapping
    public Games addGame(@RequestBody Games games){
        return gamesManager.saveGame(games);
    }

    @PutMapping
    public Games updateGame(@RequestBody Games games){
        return gamesManager.saveGame(games);
    }

    @DeleteMapping
    public void deleteGame(@RequestParam Long index){
        gamesManager.deleteById(index);
    }

}
