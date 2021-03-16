package com.example.Crud.bookdao;

import com.example.Crud.bookdao.entity.Games;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepo extends CrudRepository<Games, Long> {
}
