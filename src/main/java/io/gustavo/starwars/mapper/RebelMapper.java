package io.gustavo.starwars.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import io.gustavo.starwars.entity.InventoryEntity;
import io.gustavo.starwars.entity.Localization;
import io.gustavo.starwars.entity.RebelEntity;
import io.gustavo.starwars.model.InventoryModel;
import io.gustavo.starwars.model.RebelModel;
import io.gustavo.starwars.repository.ItemRepository;

@Component
public class RebelMapper {
	
	private ItemRepository repository;
	
	public RebelMapper(ItemRepository repository) {
		this.repository = repository;
	}

	public RebelEntity convertModelToEntity(RebelModel model) {
		var inventoryList = new ArrayList<InventoryEntity>();
		var entity = new RebelEntity();
		
		entity.setName(model.getName());
		entity.setAge(model.getAge());
		entity.setGender(model.getGender());
		entity.setLocalization(new Localization(model.getLatitude(), model.getLatitude(), model.getBaseName()));
		
		model.getInventory().stream().forEach(item ->{
			var itemFound = repository.findByName(item.getName());
			
			if(itemFound != null) {
				var inventoryEntity = new InventoryEntity(entity, itemFound, item.getAmount());
				inventoryList.add(inventoryEntity);
			}else {
				throw new IllegalArgumentException("Item not found");
			}
		});
		entity.setInventory(inventoryList);
		
		return entity;
	}

	public RebelModel convertEntityToModel(RebelEntity entity) {
		var model = new RebelModel();
		var inventoryList = new ArrayList<InventoryModel>();
		
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setAge(entity.getAge());
		model.setGender(entity.getGender());
		model.setLatitude(entity.getLocalization().getLatitude());
		model.setLongitude(entity.getLocalization().getLongitude());
		model.setBaseName(entity.getLocalization().getBaseName());
		model.setAccusations(entity.getAccusations());

		entity.getInventory().stream().forEach(item ->{
			var inventoryModel = new InventoryModel();
			inventoryModel.setAmount(item.getAmount());
			inventoryModel.setName(item.getItem().getName());
			inventoryList.add(inventoryModel);
		});
		
		model.setInventory(inventoryList);
		
		return model;
	}
}
