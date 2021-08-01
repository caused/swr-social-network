package io.gustavo.starwars.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InventoryPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3953770615339456130L;
	
	@Column(name="rebel_id")
	private Long rebelId;
	
	@Column(name = "item_id")
	private Long itemId;
	
	public InventoryPK() {
	}

	public InventoryPK(Long rebelId, Long itemId) {
		this.rebelId = rebelId;
		this.itemId = itemId;
	}

	public Long getRebelId() {
		return rebelId;
	}

	public void setRebelId(Long rebelId) {
		this.rebelId = rebelId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        InventoryPK that = (InventoryPK) o;
        return Objects.equals(rebelId, that.rebelId) &&
               Objects.equals(itemId, that.itemId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(rebelId, itemId);
    }
}
