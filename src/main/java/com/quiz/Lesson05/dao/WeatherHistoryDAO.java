package com.quiz.Lesson05.dao;

import org.springframework.stereotype.Repository;

import com.quiz.Lesson05.model.WeatherHistory;

@Repository
public interface WeatherHistoryDAO {
	public WeatherHistory selectWeatherHistory();
}
