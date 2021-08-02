package io.gustavo.starwars.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.gustavo.starwars.entity.Localization;
import io.gustavo.starwars.entity.RebelEntity;
import io.gustavo.starwars.exceptions.RebelNotFoundException;
import io.gustavo.starwars.mapper.RebelMapper;
import io.gustavo.starwars.model.RebelModel;
import io.gustavo.starwars.repository.InventoryRepository;
import io.gustavo.starwars.repository.RebelRepository;

@Service
public class RebelService {

	private RebelRepository rebelRepository;
	private RebelMapper mapper;
	private InventoryRepository inventoryRepository;
	
	public RebelService(RebelRepository rebelRepository, RebelMapper mapper, InventoryRepository inventoryRepository) {
		this.rebelRepository = rebelRepository;
		this.mapper = mapper;
		this.inventoryRepository = inventoryRepository;
	}
	
	public RebelModel createRebel(RebelModel model) {
		var entity = mapper.convertModelToEntity(model);
		var inventory = entity.getInventory();
		
		RebelEntity rebelEntity = this.rebelRepository.save(entity);
		
		model.setId(rebelEntity.getId());
		
		inventory
			.stream()
			.forEach(item -> item.getInventoryPk().setRebelId(rebelEntity.getId()));
		this.inventoryRepository.saveAll(inventory);
		
		return model;
	}
	
	public RebelModel updateRebelLocalization(Long id, Localization localization) throws RebelNotFoundException {
		Optional<RebelEntity> optionalRebel = rebelRepository.findById(id);
		if(optionalRebel.isPresent()) {
			var rebel = optionalRebel.get();
			rebel.setLocalization(localization);
			rebelRepository.save(rebel);
			return mapper.convertEntityToModel(rebel);
		}else {
			throw new RebelNotFoundException("Rebel not found");
		}
	}
}
