package com.quiz.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.model.Webpage;

@Repository
public interface WebpageDAO {
	public List<Webpage> selectWebpageList();
	public int insertNewWebpageAsField(
			@Param("name") String name, 
			@Param("url") String url);
}
