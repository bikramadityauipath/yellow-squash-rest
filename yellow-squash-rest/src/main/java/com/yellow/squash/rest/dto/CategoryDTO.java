package com.yellow.squash.rest.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = 4365567280255054824L;

	private Long catId;
	
    private String description;
    
    private String icon;
    
    private String categoryName;
    
    private String slug;
	
    @JsonIgnore private List<ArticlesDTO> articles;
    
    @JsonIgnore private List<VideosDTO> videos;
    
    @JsonIgnore private List<TagsDTO> tags;
    
    @JsonIgnore private List<ExpertiseDTO> expertise;
    
	public CategoryDTO() {}
	
	public CategoryDTO(Long catId, String description, String icon, String categoryName, String slug) {
		super();
		this.catId = catId;
		this.description = description;
		this.icon = icon;
		this.categoryName = categoryName;
		this.slug = slug;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
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

	public List<TagsDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagsDTO> tags) {
		this.tags = tags;
	}

	public List<ExpertiseDTO> getExpertise() {
		return expertise;
	}

	public void setExpertise(List<ExpertiseDTO> expertise) {
		this.expertise = expertise;
	}

	
}