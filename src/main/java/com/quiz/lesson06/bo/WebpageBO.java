package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.dao.WebpageDAO;
import com.quiz.lesson06.model.Webpage;

@Service
public class WebpageBO {
	@Autowired
	private WebpageDAO webpageDAO;
	public List<Webpage> getWebpageList(){
		return webpageDAO.selectWebpageList();
	}
	public void  addNewWebpageAsField(String name, String url) {
		webpageDAO.insertNewWebpageAsField(name, url);
	}
	public Webpage getWebpageByUrl(String url) {
		return webpageDAO.selectWebpageByUrl(url);
	}
	public int deleteWebpageById(int id) {
		return webpageDAO.deleteWebpageById(id);
	}
}
