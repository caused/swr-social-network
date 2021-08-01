package io.gustavo.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.gustavo.starwars.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

}
