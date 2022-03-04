package com.quiz.Lesson05.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.Lesson05.model.WeatherHistory;

@Repository
public interface WeatherHistoryDAO {
	public List<WeatherHistory>	 selectWeatherHistoryList();
	
	public void insertWeatherHistory(
			
			@Param("date") String date,
			@Param("weather") String weather,
			@Param("microDust") String microDust,
			@Param("temperatures") String temperatures,
			@Param("precipitation") String precipitation,
			@Param("windSpeed") String windSpeed
			);
	
}
