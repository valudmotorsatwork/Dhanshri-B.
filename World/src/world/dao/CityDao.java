package world.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;

import world.ConnectionManager;
import world.domain.City;

public class CityDao {
	Connection conn;

	public List<City> findByName(String name) {
		new ConnectionManager();
		conn = (Connection) ConnectionManager.connectivity();
		List<City> results = new ArrayList<City>();
		if (name == null)
			return results;
		try {

			System.out.println("connection");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM City WHERE name=?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
				results.add(resultToCity(rs));
			rs.close();
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}
		return results;
	}

	public List<City> loadCityName() {
		new ConnectionManager();
		conn = (Connection) ConnectionManager.connectivity();
		List<City> results = new ArrayList<City>();
		try {

			System.out.println("connection");
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM City");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next())
				results.add(resultToCity(rs));
			rs.close();
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}
		return results;
	}

	/**
	 * Copy current ResultSet row into a City object.
	 * 
	 * @param rs
	 *            ResultSet with a current row
	 * @return a City object containing resultSet data for one row
	 */
	private City resultToCity(ResultSet rs) {
		City city = new City();
		try {
			city.setName(rs.getString("name"));
			city.setDistrict(rs.getString("district"));
			city.setPopulation(rs.getInt("population"));
			city.setCountryCode(rs.getString("countrycode"));
			city.setId(rs.getInt("id"));
		} catch (SQLException sqle) {
			throw new RuntimeException(sqle);
		}
		return city;
	}

}
