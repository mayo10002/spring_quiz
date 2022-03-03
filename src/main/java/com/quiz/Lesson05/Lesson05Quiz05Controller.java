package com.quiz.Lesson05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.Lesson05.bo.WeatherHistoryBO;

@Controller
public class Lesson05Quiz05Controller {
	
	@Autowired 
		private WeatherHistoryBO weatherHistoryBO;
	
	@RequestMapping("/lesson05/quiz05")
	public String quiz05() {
		weatherHistoryBO.getWeatherHistory();
		return "lesson05/quiz05";
	}
}
