package com.yellow.squash.rest.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TagsDTO implements Serializable {

	private static final long serialVersionUID = 2705097676381591714L;

	private Long tagId;
	
    private Long countUsed;
    
    private String description;
    
    private String tagName;
    
    private String slug;

    @JsonIgnore private List<VideosDTO> videos;
    
    @JsonIgnore private List<ArticlesDTO> articles;

    @JsonIgnore private List<CategoryDTO> categories;

	public TagsDTO() {}
	
	public TagsDTO(Long tagId, String tagName) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
	}
	
	public TagsDTO(Long tagId, Long countUsed, String description, String tagName, String slug) {
		super();
		this.tagId = tagId;
		this.countUsed = countUsed;
		this.description = description;
		this.tagName = tagName;
		this.slug = slug;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Long getCountUsed() {
		return countUsed;
	}

	public void setCountUsed(Long countUsed) {
		this.countUsed = countUsed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<VideosDTO> getVideos() {
		return videos;
	}

	public void setVideos(List<VideosDTO> videos) {
		this.videos = videos;
	}

	public List<ArticlesDTO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticlesDTO> articles) {
		this.articles = articles;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
}