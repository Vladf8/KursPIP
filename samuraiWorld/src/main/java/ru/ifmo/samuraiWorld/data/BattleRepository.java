package ru.ifmo.samuraiWorld.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

public interface BattleRepository extends CrudRepository<Battle, Integer> {
    List<Battle> findAllById();
    List<Battle> findAll();
    Battle save(Battle battle);
    List<Battle> findByDate(Date date);
}
