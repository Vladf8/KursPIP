package ru.ifmo.samuraiWorld.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LandRepository extends CrudRepository<Land, String> {
    Land save(Land land);
    List<Land> findAllByNameClan(String clanName);
}
