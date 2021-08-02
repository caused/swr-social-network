package io.gustavo.starwars.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RebelModel {
	
	private Long id;

	@NotNull(message = "You must specify the name")
	private String name;
	
	@NotNull(message = "You must specify the age")
	private String age;
	
	@NotNull(message = "You must specify the gender")
	private String gender;

	@NotNull(message = "You must specify the latitude")
	private String latitude;
	
	@NotNull(message = "You must specify the longitude")
	private String longitude;
	
	@NotNull(message = "You must specify the name of the base")
	@JsonProperty("base_name")
	private String baseName;
	
	@NotNull(message = "You must specify the inventory")
	private List<InventoryModel> inventory;
	
	public RebelModel() {
	}

	public RebelModel(@NotNull(message = "You must specify the name") String name,
			@NotNull(message = "You must specify the age") String age,
			@NotNull(message = "You must specify the gender") String gender,
			@NotNull(message = "You must specify the latitude") String latitude,
			@NotNull(message = "You must specify the longitude") String longitude,
			@NotNull(message = "You must specify the name of the base") String baseName,
			@NotNull(message = "You must specify the inventory") List<InventoryModel> inventory) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.latitude = latitude;
		this.longitude = longitude;
		this.baseName = baseName;
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public List<InventoryModel> getInventory() {
		return inventory;
	}

	public void setInventory(List<InventoryModel> inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "CreateRebelRequest [name=" + name + ", age=" + age + ", gender=" + gender + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", baseName=" + baseName + ", inventory=" + inventory + "]";
	}
	
}
