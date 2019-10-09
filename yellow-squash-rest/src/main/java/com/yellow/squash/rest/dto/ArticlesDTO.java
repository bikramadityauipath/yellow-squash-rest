package com.yellow.squash.rest.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yellow.squash.rest.enums.PostStatusENUM;
import com.yellow.squash.rest.enums.UserRoleENUM;
import com.yellow.squash.rest.model.ArticlesModel;
import com.yellow.squash.rest.model.TagsModel;

public class ArticlesDTO implements Serializable {

	private static final long serialVersionUID = -8252158937503809072L;
	
	private Long articleId;
	
	private String articleTitle;

	private String articleMimeType;

	private String excerpts;
	
	private String featuredImage;
	
	private String htmlContent;
	
	private Long likesCount;
	
	private String permLink;
	
	private Long shareCount;

	private String slug;
	
	private PostStatusENUM status;
	
	private Long viewCount;
	
	private List<TagsDTO> tags;
	
	private Long catId;
	@JsonIgnore private CategoryDTO category;
	
	private Long partnerId;
	@JsonIgnore private PartnerDTO partner;
	
	private Long customerId;
	@JsonIgnore private CustomerDTO customer;
	
	private Long authorId;
	private String catName, authorName;
	private UserRoleENUM authorType;
	
	public ArticlesDTO() {}
	
	public ArticlesDTO(Long articleId, String articleTitle, String articleMimeType, String excerpts, String featuredImage, Long likesCount, String permLink, Long shareCount, String slug, Long viewCount, Long catId, String catName) {
		super();
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleMimeType = articleMimeType;
		this.excerpts = excerpts;
		this.featuredImage = featuredImage;
		this.likesCount = likesCount;
		this.permLink = permLink;
		this.shareCount = shareCount;
		this.slug = slug;
		this.viewCount = viewCount;
		this.catId = catId;
		this.catName = catName;
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

	public Long getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Long likesCount) {
		this.likesCount = likesCount;
	}

	public String getPermLink() {
		return permLink;
	}

	public void setPermLink(String permLink) {
		this.permLink = permLink;
	}

	public Long getShareCount() {
		return shareCount;
	}

	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
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

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public List<TagsDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagsDTO> tags) {
		this.tags = tags;
	}
	
	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public PartnerDTO getPartner() {
		return partner;
	}

	public void setPartner(PartnerDTO partner) {
		this.partner = partner;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public UserRoleENUM getAuthorType() {
		return authorType;
	}

	public void setAuthorType(UserRoleENUM authorType) {
		this.authorType = authorType;
	}
	
	/******************* CONVERT TO ENTITY MAPPER FUNCTIONS  *******************/

	public ArticlesModel toModel(ArticlesDTO dto) {
		ArticlesModel article = new ArticlesModel(dto.getArticleTitle(), dto.getArticleMimeType(), dto.getExcerpts(), dto.getFeaturedImage(), dto.getHtmlContent(), dto.getPermLink(), dto.getSlug(), dto.getStatus(), dto.getPartnerId(), dto.getCustomerId(), dto.getCatId());
		article.setTags(dto.getTags().stream().map(tag -> new TagsModel(tag.getTagId(), tag.getTagName())).collect(Collectors.toList()));
		return article;
    }
}
