package world.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import world.ConnectionManager;

public class CityDao {

	//***********For Establishing The Connection We Have Create The Object***************
	ConnectionManager obj=new ConnectionManager();
	Connection conn=ConnectionManager.connectivity();
	//***********For Getting List Of All Values From Database********************
	public List<world.domain.City> listCountry()
	{
		List<world.domain.City> list=new ArrayList<>();
		PreparedStatement ps=null;
		ResultSet res=null;
		String sql="select id,name,countryCode,district,population from City";
		try {
			ps=conn.prepareStatement(sql);
			res=ps.executeQuery();
			while(res.next())
			{
				world.domain.City country=new world.domain.City();
				country.setId(res.getString("id"));
				country.setName(res.getString("name"));
				country.setCountryCode(res.getString("countryCode"));
				country.setDistrict(res.getString("district"));
				country.setPopulation(res.getString("population"));
				
				list.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;	
	}
	
	//***************To Update Values Of Database******************
	public void doUpdate(world.domain.City city)
	{
		PreparedStatement ps=null;
		try{
			String sql="update City set name=?,countryCode=?,district=?,population=? where id=?";
			Connection conn=ConnectionManager.connectivity();
			ps=conn.prepareStatement(sql);
			ps.setString(1,city.getName());
			ps.setString(2,city.getCountryCode());
			ps.setString(3,city.getDistrict());
			ps.setString(4,city.getPopulation());
			ps.setString(5,city.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//***************To Delete Values From Database******************
	public void doDelete(world.domain.City city)
	{
		PreparedStatement ps=null;
		try{
			String sql="delete from City  where id=?";
			Connection conn=ConnectionManager.connectivity();
			ps=conn.prepareStatement(sql);
			ps.setString(1,city.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//***************To Insert Values In Database******************
	@SuppressWarnings("unused")
	public int doCreate(world.domain.City city)
	{
		PreparedStatement ps=null;
		ResultSet res=null;
		int id=0;
		try{
			String sql="insert into City (name,countryCode,district,population) values(?,?,?,?)";
			Connection conn=ConnectionManager.connectivity();
			ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,city.getName());
			ps.setString(2,city.getCountryCode());
			ps.setString(3,city.getDistrict());
			ps.setString(4,city.getPopulation());
			
			int rows=ps.executeUpdate();
			if(rows==0)
			{
				throw new SQLException("Unable To Create city");
			}
			res=ps.getGeneratedKeys();
			if(res.next())
				id=res.getInt(1);
			else
				throw new SQLException("Unable ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				ps.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		return 0;
	}
}