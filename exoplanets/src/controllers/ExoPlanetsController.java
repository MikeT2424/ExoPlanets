package controllers;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import dao.Planet;
import service.PlanetService;

@Controller
@Validated // added for method level validation
public class ExoPlanetsController {
	
	 @Bean //This allows the individual validation of request parameters, instead of validating
	 public MethodValidationPostProcessor methodValidationPostProcessor() {
	      return new MethodValidationPostProcessor();
	  }
	
	PlanetService planetServiceTest;

	@Autowired
	public void setPlanetServiceTest(PlanetService planetServiceTest) {
		this.planetServiceTest = planetServiceTest;
	}

	@RequestMapping("/")
	public String showIndex(Model model, HttpSession session) {

		System.out.println("Directing to index.jsp from ExoPlanetsController.");

		// The session attribute will persist while the website is active.
		session.setAttribute("sessionName", "SebastionSession");
		// The model attribute will only persist for passage to a single page.
		model.addAttribute("modelName", "MoeModel");

		// A list is created using the selectPlanetList handler, and added to the model
		// for display.
		List<Planet> planetList = null;
		
		session.setAttribute("planetList", planetList);
        int to = 0;
        int from = 0;
		session.setAttribute("to", to);
		session.setAttribute("from", from);

		return "index";
	}

	@RequestMapping(value = "/showPlanets", method = RequestMethod.POST) // accept only post request from /index
	public String showPlanets(
			@RequestParam("from") String from,  //added for validation of 'from'
			@RequestParam("to") String to, 
			@RequestParam("searchType") String searchType,  Model model, HttpSession session)
	        {
		//change the to and from numbers to a string for regex comparison.
		//Confirm the fields are numbers with or without a decimal point.
        System.out.println(to + " " + from);
		
		if(!from.matches( "^[0-9]\\d*(\\.\\d+)?$") || !to.matches("^[0-9]\\d*(\\.\\d+)?$")) {
			System.out.println("The To and From Field parameters must be a positive number.");
			String errorMessage = "The To and From Field parameters must be a positive number.";
			model.addAttribute("errorMessage", errorMessage);
			return "index";
		};
		//Confirm the numbers are above 0.
		if(Double.parseDouble(from) < 0 || Double.parseDouble(to) < 0) {
			System.out.println("The from input must be greater than or equal to 0");
			String errorMessage = "The to and  from input fields must be greater than or equal to 0";
			model.addAttribute("errorMessage", errorMessage);
			return "index";
		}
		//Confirm that From is less than To.
		if(Double.parseDouble(from) > Double.parseDouble(to)) {
			System.out.println("The From field must be less than the To field.");
			String errorMessage = "The From field must be less than the To field.";
			model.addAttribute("errorMessage", errorMessage);
			return "index";
		}
		
		System.out.println("variables from the showPlanets.jsp form: from: " + from + " to: " + to + " search type:  " + searchType);
		
		List<Planet> planetList = planetServiceTest.selectPlanetList(Double.parseDouble(from) , Double.parseDouble(to), searchType);
		//Maintain the planetList in the session, so that it can be passed to JSP pages and handlers for sorting.
        session.setAttribute("planetList", planetList);
		
		return "showPlanets";
	}
	
	@RequestMapping(value = "/sortPlanets")
	public String sortPlanets(@RequestParam("sort")String sort, HttpSession session) {
		//This handler will call the sortPlanets method in PlanetsService to change the order of the the List.
		//This avoids making another SQL query, and uses the existing result set.
		System.out.println("called ExoPlanetsController.sortPlanets sort = " + sort);
		@SuppressWarnings("unchecked")
		List<Planet> planetList = (List<Planet>)session.getAttribute("planetList");
		
		planetServiceTest.sortPlanets(planetList, sort);
		
		return "showPlanets";
	}
}
