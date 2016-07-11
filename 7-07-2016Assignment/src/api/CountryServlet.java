package api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controllers.CountryDao;

@WebServlet("/CityController")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CountryDao obj;

	public CountryServlet() {
		super();
		obj = new CountryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<models.Country> list;
		try {
			list = obj.listCountry();
			Gson gson = new Gson();
			response.setContentType("application/json");
			response.getWriter().write(gson.toJson(list));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@SuppressWarnings("unused")
	private models.City parseRequest(HttpServletRequest request) throws ServletException, IOException {
		models.City city = new models.City();
		city.setId(request.getParameter("id"));
		city.setName(request.getParameter("name"));
		city.setCountryCode(request.getParameter("countryCode"));
		city.setDistrict(request.getParameter("district"));
		city.setPopulation(request.getParameter("population"));
		return city;
	}

}