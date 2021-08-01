package io.gustavo.starwars.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class InventoryEntity {

	@EmbeddedId
	private InventoryPK inventoryPk;
	
	@ManyToOne
	@MapsId("rebel_id")
	@JoinColumn(name = "rebel_id")
	private RebelEntity rebel;
	
	@ManyToOne
	@MapsId("item_id")
	@JoinColumn(name = "item_id")
	private ItemEntity item;
	
	@Column
	private int amount;
	
	private InventoryEntity() {}
	
	public InventoryEntity(RebelEntity rebel, ItemEntity item) {
		this.rebel = rebel;
		this.item = item;
		this.inventoryPk = new InventoryPK(rebel.getId(), item.getId());
	}
}
