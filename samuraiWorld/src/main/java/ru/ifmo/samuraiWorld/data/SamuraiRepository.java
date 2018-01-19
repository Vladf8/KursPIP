package ru.ifmo.samuraiWorld.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SamuraiRepository extends CrudRepository<Samurai, Integer> {
    Samurai findById(int id);
    List<Samurai> findByClanName(String clanName);
    List<Samurai> findByName(String name);
    Samurai save(Samurai samurai);
}
