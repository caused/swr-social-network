package io.gustavo.starwars.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InventoryRequest {

	@NotNull
	private String name;
	
	@Min(1)
	private int amount;
}
