package com.example.Crud.bookmanager;

import com.example.Crud.bookdao.GamesRepo;
import com.example.Crud.bookdao.entity.Games;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class GamesManager {
    private GamesRepo gamesRepo;

    @Autowired
    public GamesManager(GamesRepo gamesRepo) {
        this.gamesRepo = gamesRepo;
    }

    public Optional<Games> findGameById(Long id){
        return gamesRepo.findById(id);
    }

    public Iterable<Games> findGameAll(){
        return gamesRepo.findAll();
    }

    public Games saveGame(Games games){
        return gamesRepo.save(games);
    }

    public void deleteById(Long id){
        gamesRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill2DB() {
        saveGame(new Games(1L, "God of war", "Santa Monica Studio", LocalDate.of(2018, 04, 20)));
        saveGame(new Games(2L, "The Last of Us Part II", "Naughty Dog", LocalDate.of(2020, 6, 19)));
        saveGame(new Games(3L, "Ghost of Tsushima", "Sucker Punch Productions", LocalDate.of(2020, 7, 17)));
    }
}
