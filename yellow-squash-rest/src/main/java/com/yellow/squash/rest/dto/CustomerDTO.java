package com.yellow.squash.rest.dto;

import java.util.List;

public class CustomerDTO extends UserBaseDTO{
	
	private static final long serialVersionUID = 3091179744499007752L;
	
	private String fullName;
	
	private String newsletterSubFlag;

	/***** RELATIONSHIPS *****/
    
	private List<ArticlesDTO> articles;
    
	private List<VideosDTO> videos;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNewsletterSubFlag() {
		return newsletterSubFlag;
	}

	public void setNewsletterSubFlag(String newsletterSubFlag) {
		this.newsletterSubFlag = newsletterSubFlag;
	}

	public List<ArticlesDTO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticlesDTO> articles) {
		this.articles = articles;
	}

	public List<VideosDTO> getVideos() {
		return videos;
	}

	public void setVideos(List<VideosDTO> videos) {
		this.videos = videos;
	}
}
