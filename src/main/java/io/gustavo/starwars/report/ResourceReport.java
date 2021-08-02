package io.gustavo.starwars.report;

import java.util.List;

import io.gustavo.starwars.entity.InventoryEntity;
import io.gustavo.starwars.repository.InventoryRepository;
import io.gustavo.starwars.repository.ItemRepository;
import io.gustavo.starwars.repository.RebelRepository;

public class ResourceReport implements Report {

	private ItemRepository itemRepository;
	private InventoryRepository inventoryRepository;
	private RebelRepository rebelRepository;
	private String resource;
	
	public ResourceReport(String resource, InventoryRepository inventoryRepository, ItemRepository itemRepository, RebelRepository rebelRepository) {
		this.inventoryRepository = inventoryRepository;
		this.itemRepository =  itemRepository;
		this.rebelRepository = rebelRepository;
		this.resource = resource;
		
	}

	@Override
	public ReportResult build() {
		var result = new ReportResult();
		
		var itemEntity = itemRepository.findByName(resource);
		if(itemEntity != null) {
			long count = rebelRepository.count();
			List<InventoryEntity> allByItemEntity = inventoryRepository.findAllByItemEntity(itemEntity);
			int sum = allByItemEntity.stream().mapToInt(InventoryEntity::getAmount).sum();
		} else {
			
		}
		
		return result;
	}

}
