package gta.winbo.cali;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/intro", method = RequestMethod.GET)
	public String intro() {

		return "intro";
	}
	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public String movie() {
		
		return "home.jsp?pagefile=movie";
	}
	
	@RequestMapping(value = "/new_movie", method = RequestMethod.GET)
	public String new_movie() {
		
		return "home.jsp?pagefile=new_movie";
	}		
	@RequestMapping(value = "/movie_ranking", method = RequestMethod.GET)
	public String movie_ranking() {
		
		return "home.jsp?pagefile=movie_ranking";
	}	
	@RequestMapping(value = "/movie_search", method = RequestMethod.GET)
	public String movie_search() {
		
		return "home.jsp?pagefile=movie_search";
	}
	@RequestMapping(value = "/map", method = RequestMethod.GET)
	public String map (){
		
		return "home.jsp?pagefile=map";
	}	
}
