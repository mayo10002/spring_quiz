package com.quiz.Lesson05.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.Lesson05.dao.WeatherHistoryDAO;
import com.quiz.Lesson05.model.WeatherHistory;

@Service
public class WeatherHistoryBO {
	@Autowired
	private WeatherHistoryDAO weatherHistoryDAO;
	
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryDAO.selectWeatherHistoryList();
	}
	
//	@RequestParam("date")String date,
//	@RequestParam("weather") String weather,
//	@RequestParam("microDust") String microDust,
//	@RequestParam("temperatures") String temperatures,
//	@RequestParam("precipitation") String precipitation,
//	@RequestParam("windSpeed") String windSpeed
	
	public void addWeatherHistory(String date, String weather,String microDust,String temperatures,String precipitation,String windSpeed) {
		weatherHistoryDAO.insertWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
	}
}
