package models;




public class CountryLanguage {
	private String countryCode;
	private String language;
	private String isOfficial;
	private String percentage;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getIsOfficial() {
		return isOfficial;
	}
	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}
	@Override
	public String toString() {
		return "CountryLanguage [countryCode=" + countryCode + ", language=" + language + ", isOfficial=" + isOfficial
				+ ", percentage=" + percentage + "]";
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	
	public CountryLanguage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CountryLanguage(String countryCode, String language, String isOfficial, String percentage) {
		super();
		this.countryCode = countryCode;
		this.language = language;
		this.isOfficial = isOfficial;
		this.percentage = percentage;
	}
	
	
}