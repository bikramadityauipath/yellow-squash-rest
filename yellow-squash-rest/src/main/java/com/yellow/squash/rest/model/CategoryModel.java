package com.yellow.squash.rest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yellow.squash.rest.audit.TimeUserAudit;
import com.yellow.squash.rest.dto.CategoryDTO;

@Entity
@Table(name="category")
public class CategoryModel extends TimeUserAudit<String> {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique=true, nullable=false, precision=10)
    private Long catId;
	
    @Column(length=500)
    private String description;
    
    @Column(length=500)
    private String icon;
    
    @Column(name="category_name", nullable=false, length=100)
    private String categoryName;
    
    @Column(length=100)
    private String slug;
	
    @OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
   	private List<ArticlesModel> articles;
    
    @OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
   	private List<VideosModel> videos;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "category_tags", joinColumns = @JoinColumn(name = "cat_id", referencedColumnName = "catId"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "tagId"))
    private List<TagsModel> tags;
    
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "expertise_category", joinColumns = @JoinColumn(name = "cat_id", referencedColumnName = "catId"), inverseJoinColumns = @JoinColumn(name = "expertise_id", referencedColumnName = "expertiseId"))
    private List<ExpertiseModel> expertise;

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

	public List<TagsModel> getTags() {
		return tags;
	}

	public void setTags(List<TagsModel> tags) {
		this.tags = tags;
	}

	public List<ExpertiseModel> getExpertise() {
		return expertise;
	}

	public void setExpertise(List<ExpertiseModel> expertise) {
		this.expertise = expertise;
	}

	public CategoryDTO toDto(CategoryModel model) {
		return new CategoryDTO(model.getCatId(), model.getDescription(), model.getIcon(), model.getCategoryName(), model.getSlug());
	}
}