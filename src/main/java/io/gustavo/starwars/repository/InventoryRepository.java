package io.gustavo.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.gustavo.starwars.entity.InventoryEntity;
import io.gustavo.starwars.entity.InventoryPK;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, InventoryPK>{

}
