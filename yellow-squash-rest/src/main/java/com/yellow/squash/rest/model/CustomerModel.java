package com.yellow.squash.rest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="customer")
@PrimaryKeyJoinColumn(referencedColumnName="userId")
public class CustomerModel extends UserBaseModel{
	
	@Column(length = 100)
	private String fullName;
	
	@Column(nullable = false, length = 1)
	private String newsletterSubFlag;
	
	/***** RELATIONSHIPS *****/
    
    @OneToMany(mappedBy="partner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ArticlesModel> articles;
    
    @OneToMany(mappedBy="partner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<VideosModel> videos;
    
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

	public List<ArticlesModel> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticlesModel> articles) {
		this.articles = articles;
	}

	public List<VideosModel> getVideos() {
		return videos;
	}

	public void setVideos(List<VideosModel> videos) {
		this.videos = videos;
	}
}
