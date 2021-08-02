package io.gustavo.starwars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.gustavo.starwars.entity.RebelEntity;

public interface RebelRepository extends JpaRepository<RebelEntity, Long>{

	@Query("select r from RebelEntity r where r.accusations > 2")
	List<RebelEntity> findTraitors();
}
