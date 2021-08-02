package io.gustavo.starwars.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InventoryModel{

	@NotNull
	private String name;
	
	@Min(1)
	private int amount;
	
	public InventoryModel() {}

	public InventoryModel(@NotNull String name, @Min(1) int amount) {
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
