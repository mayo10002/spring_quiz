package com.quiz.Lesson05.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.Lesson05.dao.WeatherHistoryDAO;
import com.quiz.Lesson05.model.WeatherHistory;

@Service
public class WeatherHistoryBO {
	@Autowired
	private WeatherHistoryDAO weatherHistoryDAO;
	
	public WeatherHistory getWeatherHistory() {
		return weatherHistoryDAO.selectWeatherHistory();
	}
}
