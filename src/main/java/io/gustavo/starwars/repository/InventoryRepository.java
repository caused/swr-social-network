package io.gustavo.starwars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.gustavo.starwars.entity.InventoryEntity;
import io.gustavo.starwars.entity.InventoryPK;
import io.gustavo.starwars.entity.ItemEntity;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, InventoryPK>{

	List<InventoryEntity> findAllByItemEntity (ItemEntity item);
}
