package com.yellow.squash.rest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.yellow.squash.rest.audit.TimeUserAudit;
import com.yellow.squash.rest.dto.TagsDTO;

@Entity
@Table(name="tags")
public class TagsModel extends TimeUserAudit<String> {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique=true, nullable=false, precision=10)
    private Long tagId;
	
    @Column(precision=19)
    private Long countUsed;
    
    @Column(length=200)
    private String description;
    
    @Column(nullable=false, length=100)
    private String tagName;
    
    @Column(length=100)
    private String slug;

    @ManyToMany(mappedBy = "tags")
    private List<VideosModel> videos;
    
    @ManyToMany(mappedBy = "tags")
    private List<ArticlesModel> articles;

    @ManyToMany(mappedBy = "tags")
    private List<CategoryModel> categories;
    
    public TagsModel() {}
	
	public TagsModel(Long tagId, String tagName) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
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

	public List<VideosModel> getVideos() {
		return videos;
	}

	public void setVideos(List<VideosModel> videos) {
		this.videos = videos;
	}

	public List<ArticlesModel> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticlesModel> articles) {
		this.articles = articles;
	}

	public List<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}
	
	public TagsDTO toDTO(TagsModel model) {
		return new TagsDTO(model.getTagId(), model.getCountUsed(), model.getDescription(), model.getTagName(), model.getSlug());
	}
}