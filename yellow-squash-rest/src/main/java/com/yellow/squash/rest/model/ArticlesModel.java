package com.yellow.squash.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yellow.squash.rest.audit.TimeUserAudit;
import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.TagsDTO;
import com.yellow.squash.rest.enums.PostStatusENUM;
import com.yellow.squash.rest.enums.UserRoleENUM;

@Entity
@Table(name="articles")
public class ArticlesModel extends TimeUserAudit<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private Long articleId;
	
	@Column(nullable = false, length = 500)
	private String articleTitle;

	@Column(nullable = false, length = 100)
	private String articleMimeType;

	@Column(length = 200)
	private String excerpts;
	
	@Column(length = 500)
	private String featuredImage;
	
	@Column(length = 10000)
	private String htmlContent;
	
	@Column(precision = 10)
	private Long likesCount;
	
	@Column(nullable = false, length = 255)
	private String permLink;
	
	@Column(precision = 10)
	private Long shareCount;

	@Column(length = 200)
	private String slug;
	
	@Column(nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private PostStatusENUM status;
	
	@Column(precision = 10)
	private Long viewCount;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "article_tags", joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "articleId"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "tagId"))
    private List<TagsModel> tags;
	
	private Long catId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="catId", referencedColumnName="catId",insertable=false, updatable=false)
	private CategoryModel category;
	
	private Long partnerId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="partnerId", referencedColumnName="userId",insertable=false, updatable=false)
	private PartnerModel partner;
	
	private Long customerId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerId", referencedColumnName="userId",insertable=false, updatable=false)
	private CustomerModel customer;
	
	public ArticlesModel() {}

	public ArticlesModel(String articleTitle, String articleMimeType, String excerpts, String featuredImage, String htmlContent, String permLink, String slug, PostStatusENUM status, Long partnerId, Long customerId, Long catId) {
		super();
		this.articleTitle = articleTitle;
		this.articleMimeType = articleMimeType;
		this.excerpts = excerpts;
		this.featuredImage = featuredImage;
		this.htmlContent = htmlContent;
		this.permLink = permLink;
		this.slug = slug;
		this.status = status;
		this.partnerId = partnerId;
		this.customerId = customerId;
		this.catId = catId;
	}
	
	public ArticlesModel(Long articleId, String articleTitle, String articleMimeType, String excerpts, String featuredImage, String htmlContent, String permLink, String slug, PostStatusENUM status, Long partnerId, Long customerId, Long catId) {
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
		this.partnerId = partnerId;
		this.customerId = customerId;
		this.catId = catId;
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

	public List<TagsModel> getTags() {
		return tags;
	}

	public void setTags(List<TagsModel> tags) {
		this.tags = tags;
	}
	
	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public PartnerModel getPartner() {
		return partner;
	}

	public void setPartner(PartnerModel partner) {
		this.partner = partner;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "ArticlesModel [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleMimeType="
				+ articleMimeType + ", excerpts=" + excerpts + ", featuredImage=" + featuredImage + ", htmlContent="
				+ htmlContent + ", likesCount=" + likesCount + ", permLink=" + permLink + ", shareCount=" + shareCount
				+ ", slug=" + slug + ", status=" + status + ", viewCount=" + viewCount + ", tags=" + tags + ", catId="
				+ catId + ", partnerId=" + partnerId + ", customerId=" + customerId + "]";
	}

	public ArticlesDTO toDto(ArticlesModel model, boolean includeContent) {
		System.out.println(model);
		
		ArticlesDTO dto = new ArticlesDTO(model.getArticleId(), model.getArticleTitle(), model.getArticleMimeType(), model.getExcerpts(), model.getFeaturedImage(), model.getLikesCount(), model.getPermLink(), model.getShareCount(), model.getSlug(), model.getViewCount(), model.getCatId(), model.getCategory().getCategoryName());
		if(includeContent)
			dto.setHtmlContent(model.getHtmlContent());
		if(null != model.getPartnerId()) {
			PartnerModel partner = model.getPartner();
			dto.setPartnerId(partner.getUserId());
			dto.setAuthorName(partner.getFullName());
			dto.setAuthorType(UserRoleENUM.Partner);
		}
		
		if(null != model.getCustomerId()) {
			CustomerModel customer = model.getCustomer();
			dto.setPartnerId(partner.getUserId());
			dto.setAuthorName(customer.getFullName());
			dto.setAuthorType(UserRoleENUM.Customer);
		}
		
		List<TagsDTO> tags = new ArrayList<TagsDTO>();
		for(TagsModel tag : model.getTags()) {
			tags.add(new TagsDTO(tag.getTagId(), tag.getTagName()));
		}
		dto.setTags(tags);
		return dto;
	}
}
