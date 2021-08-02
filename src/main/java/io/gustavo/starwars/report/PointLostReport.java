package io.gustavo.starwars.report;

import java.util.List;

import io.gustavo.starwars.entity.InventoryEntity;
import io.gustavo.starwars.repository.RebelRepository;

public class PointLostReport implements Report {

	private RebelRepository rebelRepository;
	
	public PointLostReport(RebelRepository rebelRepository) {
		this.rebelRepository = rebelRepository;
	}
	
	@Override
	public ReportResult build() {
		var result = new ReportResult();
		var traitors = rebelRepository.findTraitors();
		
		if(traitors.isEmpty()) {
			result.setValue(String.valueOf(0));
		}else {
			result.setValue(String.valueOf(traitors.stream().mapToDouble(traitor ->{
				List<InventoryEntity> inventoryList = traitor.getInventory();
				return inventoryList.stream().mapToDouble(inventory ->{
					return inventory.getAmount() * inventory.getItem().getValue();
				}).sum();
			}).sum()));
		}
		
		return result;
	}

}
