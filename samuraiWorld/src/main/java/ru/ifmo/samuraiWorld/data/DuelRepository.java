package ru.ifmo.samuraiWorld.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DuelRepository extends CrudRepository<Duel, Integer> {
    Duel save (Duel duel);
    List<Duel> findAll();
    @Query("select count (d.idWinning) from Duel d where d.idWinning=?1")
    int queryByIdWinning(int id);


}
