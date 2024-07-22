/**
 * 
 * I declare that this code was written by me, slenc. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Slency
 * Student ID: 22009748
 * Class: E63C
 * Date created: 2024-Jul-21 3:39:15 pm 
 * 
 */

package e66d.slency.fyp;

/**
 * @author slenc
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {
	
	@GetMapping("/") 
	public String general() {
		return "index";
	}
	
	@GetMapping("/403")
	public String error403() {
		return "403";
	}
}


