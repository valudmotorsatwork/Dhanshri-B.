package world.domain;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CityDao obj=new CityDao();
	Gson gson=new Gson();
	
   public CityServlet() {
        System.out.println("cityservlet");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<world.domain.City> list=obj.listCountry();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(list));
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		world.domain.City parseReuest=parseRequest(request);
		String requestType=request.getQueryString();
		//*********To Select Which Operation You Have To Perform*******************
		switch(requestType)
		{
		  case "update":
		  	{
			  	obj.doUpdate(parseReuest);
			  	break;
		  	}
		  case "destroy":
		 	{
			  	obj.doDelete(parseReuest);
			  	break;
		 	}
		  case "create":
		  {
			  obj.doCreate(parseReuest);
			  response.getWriter().write(gson.toJson(parseReuest));
			  break;
		  }
		}
	}
	
	//************For Server Side Validation************************
	public world.domain.City parseRequest(HttpServletRequest request)
	{
		world.domain.City city=new world.domain.City();
		city.setId(request.getParameter("id"));	
		city.setName(request.getParameter("name"));
		city.setCountryCode(request.getParameter("countryCode"));
		city.setDistrict(request.getParameter("district"));
		city.setPopulation(request.getParameter("population"));
		return city ;
	}
}
