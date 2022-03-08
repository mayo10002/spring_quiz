package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson06Quiz02Controller {
	
	@RequestMapping("/lesson06/quiz02/add_webpage_view")
	public String addWebpageView() {
		
		return "lesson06/add_new_webpage";
	}
}
