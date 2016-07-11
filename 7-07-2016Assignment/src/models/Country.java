package models;

public class Country {
	private String code;
	private String name;
	private String continent;
	private String region;
	private String population;
	private String headOfState;
	private String capital;
	private models.City city;
	private models.CountryLanguage countryLanguage;

	public String getCode() {
		return code;
	}

	public models.City getCity() {
		return city;
	}

	public void setCity(models.City city) {
		this.city = city;
	}

	public models.CountryLanguage getCountryLanguage() {
		return countryLanguage;
	}

	public void setCountryLanguage(models.CountryLanguage countryLanguage) {
		this.countryLanguage = countryLanguage;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Country() {
		super();
	}

	public String getPopulation() {
		return population;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Country(String code, String continent, String region, String population, String capital, City city,
			CountryLanguage countryLanguage, String headOfState) {
		super();
		this.code = code;
		this.continent = continent;
		this.region = region;
		this.population = population;
		this.capital = capital;
		this.city = city;
		this.countryLanguage = countryLanguage;
		this.headOfState = headOfState;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", continent=" + continent + ", region=" + region + ", population="
				+ population + ", headOfState=" + headOfState + ", capital=" + capital + ", city=" + city
				+ ", countryLanguage=" + countryLanguage + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}