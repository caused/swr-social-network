package io.gustavo.starwars.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "inventory")
public class InventoryEntity {

	@EmbeddedId
	private InventoryPK inventoryPk;
	
	@ManyToOne
	@MapsId("rebel_id")
	@JoinColumn(name = "rebel_id")
	@JsonIgnore
	private RebelEntity rebel;
	
	@ManyToOne
	@MapsId("item_id")
	@JoinColumn(name = "item_id")
	private ItemEntity item;
	
	@Column
	private int amount;
	
	private InventoryEntity() {}
	
	public InventoryEntity(RebelEntity rebel, ItemEntity item, int amount) {
		this.rebel = rebel;
		this.item = item;
		this.inventoryPk = new InventoryPK(rebel.getId(), item.getId());
		this.amount = amount;
	}

	public InventoryPK getInventoryPk() {
		return inventoryPk;
	}

	public void setInventoryPk(InventoryPK inventoryPk) {
		this.inventoryPk = inventoryPk;
	}

	public RebelEntity getRebel() {
		return rebel;
	}

	public void setRebel(RebelEntity rebel) {
		this.rebel = rebel;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        InventoryEntity that = (InventoryEntity) o;
        return Objects.equals(rebel, that.rebel) &&
               Objects.equals(item, that.item);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(rebel, item);
    }
	
}
