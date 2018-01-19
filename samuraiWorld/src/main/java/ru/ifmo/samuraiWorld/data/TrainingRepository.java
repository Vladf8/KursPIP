package ru.ifmo.samuraiWorld.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainingRepository extends CrudRepository<Training, Integer> {
    List<Training> findAll();
}
