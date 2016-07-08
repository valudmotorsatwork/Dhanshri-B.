package world.domain;

public class City {
 private String id;
 private String name;
 private  String countryCode;
 private String district;
 private  String population;
 
 
 public String getId() {
	return id;
}
public void setId(String string) {
	this.id = string;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getPopulation() {
	return population;
}
public void setPopulation(String string) {
	this.population = string;
}
public String getCountryCode() {
	return countryCode;
}
public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}
@Override
public String toString() {
	return "City [id=" + id + ", name=" + name + ", countryCode=" + countryCode + ", district=" + district
			+ ", population=" + population + "]";
}

}
