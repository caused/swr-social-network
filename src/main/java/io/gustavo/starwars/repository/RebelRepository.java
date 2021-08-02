package io.gustavo.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.gustavo.starwars.entity.RebelEntity;

public interface RebelRepository extends JpaRepository<RebelEntity, Long>{

}
