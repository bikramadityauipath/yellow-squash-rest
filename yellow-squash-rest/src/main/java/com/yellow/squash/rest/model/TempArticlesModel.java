package com.yellow.squash.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yellow.squash.rest.audit.TimeUserAudit;
import com.yellow.squash.rest.enums.PostStatusENUM;

@Entity
@Table(name="temp_article")
public class TempArticlesModel extends TimeUserAudit<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private Long randomId; // we need a random id to be generated here, but we will fetch the articles from articleId only
	
	@Column(unique = true, nullable = false, precision = 10)
	private Long articleId;
	
	@Column(nullable = false, length = 20)
	private String articleTitle;

	@Column(nullable = false, length = 100)
	private String articleMimeType;

	@Column(length = 200)
	private String excerpts;
	
	@Column(length = 500)
	private String featuredImage;
	
	@Column(length = 10000)
	private String htmlContent;
	
	@Column(nullable = false, length = 255)
	private String permLink;
	
	@Column(length = 200)
	private String slug;
	
	@Column(nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private PostStatusENUM status;

	public TempArticlesModel() {}

	public TempArticlesModel(Long articleId, String articleTitle, String articleMimeType, String excerpts, String featuredImage, String htmlContent, String permLink, String slug, PostStatusENUM status) {
		super();
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleMimeType = articleMimeType;
		this.excerpts = excerpts;
		this.featuredImage = featuredImage;
		this.htmlContent = htmlContent;
		this.permLink = permLink;
		this.slug = slug;
		this.status = status;
	}

	public Long getRandomId() {
		return randomId;
	}

	public void setRandomId(Long randomId) {
		this.randomId = randomId;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleMimeType() {
		return articleMimeType;
	}

	public void setArticleMimeType(String articleMimeType) {
		this.articleMimeType = articleMimeType;
	}

	public String getExcerpts() {
		return excerpts;
	}

	public void setExcerpts(String excerpts) {
		this.excerpts = excerpts;
	}

	public String getFeaturedImage() {
		return featuredImage;
	}

	public void setFeaturedImage(String featuredImage) {
		this.featuredImage = featuredImage;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getPermLink() {
		return permLink;
	}

	public void setPermLink(String permLink) {
		this.permLink = permLink;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public PostStatusENUM getStatus() {
		return status;
	}

	public void setStatus(PostStatusENUM status) {
		this.status = status;
	}
}
