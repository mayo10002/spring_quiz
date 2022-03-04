package com.quiz.Lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.Lesson05.bo.WeatherHistoryBO;
import com.quiz.Lesson05.model.WeatherHistory;

@Controller
public class Lesson05Quiz05Controller {
	
	@Autowired 
		private WeatherHistoryBO weatherHistoryBO;
	
	@RequestMapping("/weather_history")
	public String quiz05(Model model) {
		
		//selectDB
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		
		//add model
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		return "lesson05/quiz05";
	}
	
	
	@RequestMapping("/add_weather_view")
	public String addWeatherView() {
		return "lesson05/add_weather_history";
		
	}
	
	@PostMapping("/add_weather")
	public String addWeather(
			@RequestParam("date")String date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") String temperatures,
			@RequestParam("precipitation") String precipitation,
			@RequestParam("windSpeed") String windSpeed
//			
			) {
		//TODO add data
		//add daat
		
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		//redirect=>날씨 정보 리스트 화면
		return "redirect://lesson05/weather_history";
	}
}
