package ru.ifmo.samuraiWorld.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
    List<Inventory> findByIdOwner(int idOwner);
    Inventory findById(int id);
    void deleteById(Inventory inv);
    Inventory save(Inventory item);
}
