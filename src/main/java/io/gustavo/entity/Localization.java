package io.gustavo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Localization {

	private String latitude;
	
	private String longitude;
	
	private String baseName;
	
	public Localization(String latitude, String longitude, String baseName) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.baseName = baseName;
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
	
	
}
