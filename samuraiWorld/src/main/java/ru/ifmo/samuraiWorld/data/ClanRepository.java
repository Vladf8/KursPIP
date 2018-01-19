package ru.ifmo.samuraiWorld.data;

import org.springframework.data.repository.CrudRepository;

public interface ClanRepository extends CrudRepository<Clan, String> {
    Clan findByName(String name);
    Clan save(Clan clan);
}
