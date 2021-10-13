package ridi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//view
	@RequestMapping("/")
	public String home() {
		return "index";
	}
}
