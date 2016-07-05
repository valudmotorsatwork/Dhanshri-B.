package world.domain;

public class City {
 private Integer id;
 private String name;
 private String district;
 private  String countryCode;
 private  int population;
 
 
 public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
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
public int getPopulation() {
	return population;
}
public void setPopulation(int population) {
	this.population = population;
}
public String getCountryCode() {
	return countryCode;
}
public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}



@Override
public String toString() {
	return "City [id=" + id + ", name=" + name + ", district=" + district + ", population=" + population
			+ ", countryCode=" + countryCode + "]";
  }
}
