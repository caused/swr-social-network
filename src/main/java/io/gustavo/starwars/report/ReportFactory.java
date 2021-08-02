package io.gustavo.starwars.report;

import org.springframework.stereotype.Component;

import io.gustavo.starwars.repository.InventoryRepository;
import io.gustavo.starwars.repository.ItemRepository;
import io.gustavo.starwars.repository.RebelRepository;

@Component
public class ReportFactory {
	
	private RebelRepository rebelRepository;
	private ItemRepository itemRepository;
	private InventoryRepository inventoryRepository;
	
	public ReportFactory(RebelRepository rebelRepository, ItemRepository itemRepository, InventoryRepository inventoryRepository) {
		this.rebelRepository = rebelRepository;
		this.inventoryRepository = inventoryRepository;
		this.itemRepository = itemRepository;
	}

	public Report getReport(ReportType type, String resource) {
		if(type.equals(ReportType.TRAITORS)) {
			return new TraitorReport(rebelRepository);
		}else if(type.equals(ReportType.REBELS)) {
			return new RebelReport(rebelRepository);
		}else if(type.equals(ReportType.RESOURCE_PER_REBEL)) {
			return new ResourceReport(resource, inventoryRepository, itemRepository, rebelRepository);
		}else if(type.equals(ReportType.POINT_LOST)) {
			return new PointLostReport(rebelRepository);
		}else {
			throw new IllegalArgumentException("Invalid report type");
		}
	}
}
