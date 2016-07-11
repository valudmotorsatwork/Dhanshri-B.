package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnectionManager;
import models.CountryLanguage;

public class CountryDao {
	// ***********For Getting List Of All Values From
	// Database**********************

	public List<models.Country> listCountry() throws SQLException {

		// ***********For Establishing The Connection We Have Create The
		// Object***************
		Connection con = ConnectionManager.connectivity();
		List<models.Country> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet res = null;
		String sql = "select country1.code,country1.name,country1.continent,country1.region,"
				+ "country1.population,country1.capital,"
				+ "country1.headOfState,city1.id,city1.name,city1.countryCode,city1.district,"
				+ "city1.population,cl.countryCode,cl.language,cl.isOfficial,cl.percentage " + " from country country1 "
				+ " join city city1 ON country1.code=city1.countryCode "
				+ " join countrylanguage cl ON cl.countryCode=country1.code  ";

		try {
			new ConnectionManager();
			con = ConnectionManager.connectivity();
			ps = con.prepareStatement(sql);
			res = ps.executeQuery();

			while (res.next()) {
				models.Country country = new models.Country();
				country.setCode(res.getString("country1.code"));
				country.setName(res.getString("country1.name"));
				country.setContinent(res.getString("country1.continent"));
				country.setRegion(res.getString("country1.region"));
				country.setPopulation(res.getString("country1.population"));
				country.setCapital(res.getString("country1.capital"));
				country.setHeadOfState(res.getString("country1.headOfState"));
				country.setCity(new models.City(res.getString("city1.id"), res.getString("city1.name"),
						res.getString("city1.countryCode"), res.getString("city1.district"),
						res.getString("city1.population")));
				country.setCountryLanguage(new CountryLanguage(res.getString("cl.countryCode"),
						res.getString("cl.language"), res.getString("cl.isOfficial"), res.getString("cl.percentage")));
				list.add(country);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
