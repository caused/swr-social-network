package io.gustavo.starwars.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rebel")
public class RebelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String age;
	
	private String gender;
	
	@Embedded
	@AttributeOverride( name = "baseName", column = @Column(name = "base_name"))
	private Localization localization;
	
	@OneToMany(mappedBy = "rebel", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<InventoryEntity> inventory;
	
	public RebelEntity() {}

	public RebelEntity(Long id, String name, String age, String gender, Localization localization, List<InventoryEntity> inventory) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.localization = localization;
		this.inventory = inventory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Localization getLocalization() {
		return localization;
	}

	public void setLocalization(Localization localization) {
		this.localization = localization;
	}

	public List<InventoryEntity> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryEntity> inventory) {
		this.inventory = inventory;
	}
	
	
}
