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
import com.yellow.squash.rest.dto.TagsDTO;
import com.yellow.squash.rest.dto.VideosDTO;
import com.yellow.squash.rest.enums.PostStatusENUM;
import com.yellow.squash.rest.enums.UserRoleENUM;

@Entity
@Table(name="videos")
public class VideosModel extends TimeUserAudit<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private Long videoId;
	
	@Column(nullable = false, length = 20)
	private String videoTitle;

	@Column(nullable = false, length = 100)
	private String videoMimeType;

	@Column(length = 200)
	private String excerpts;
	
	@Column(length = 500)
	private String featuredImage;
	
	@Column(length = 500)
	private String videoLink;
	
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
    @JoinTable(name = "video_tags", joinColumns = @JoinColumn(name = "video_id", referencedColumnName = "videoId"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "tagId"))
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

	public VideosModel() {}

	public VideosModel(String videoTitle, String videoMimeType, String excerpts, String featuredImage, String videoLink, Long likesCount, String permLink, Long shareCount, String slug, PostStatusENUM status, Long viewCount, Long catId, Long partnerId, Long customerId) {
		super();
		this.videoTitle = videoTitle;
		this.videoMimeType = videoMimeType;
		this.excerpts = excerpts;
		this.featuredImage = featuredImage;
		this.videoLink = videoLink;
		this.likesCount = likesCount;
		this.permLink = permLink;
		this.shareCount = shareCount;
		this.slug = slug;
		this.status = status;
		this.viewCount = viewCount;
		this.catId = catId;
		this.partnerId = partnerId;
		this.customerId = customerId;
	}
	
	public VideosModel(Long videoId, String videoTitle, String videoMimeType, String excerpts, String featuredImage, String videoLink, Long likesCount, String permLink, Long shareCount, String slug, PostStatusENUM status, Long viewCount, Long catId, Long partnerId, Long customerId) {
		super();
		this.videoId = videoId;
		this.videoTitle = videoTitle;
		this.videoMimeType = videoMimeType;
		this.excerpts = excerpts;
		this.featuredImage = featuredImage;
		this.videoLink = videoLink;
		this.likesCount = likesCount;
		this.permLink = permLink;
		this.shareCount = shareCount;
		this.slug = slug;
		this.status = status;
		this.viewCount = viewCount;
		this.catId = catId;
		this.partnerId = partnerId;
		this.customerId = customerId;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoMimeType() {
		return videoMimeType;
	}

	public void setVideoMimeType(String videoMimeType) {
		this.videoMimeType = videoMimeType;
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

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
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
	
	public VideosDTO toDto(VideosModel model) {
		VideosDTO dto = new VideosDTO(model.getVideoId(), model.getVideoTitle(), model.getVideoMimeType(), model.getExcerpts(), model.getFeaturedImage(), model.getVideoLink(), model.getLikesCount(), model.getPermLink(), model.getShareCount(), model.getSlug(), model.getStatus(), model.getViewCount(), model.getCatId(), model.getCategory().getCategoryName());
		if(null != model.getPartnerId()) {
			PartnerModel partner = model.getPartner();
			dto.setAuthorId(partner.getUserId());
			dto.setAuthorName(partner.getFullName());
			dto.setAuthorType(UserRoleENUM.Partner);
		}
		else if(null != model.getCustomerId()) {
			CustomerModel customer = model.getCustomer();
			dto.setAuthorId(customer.getUserId());
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

	@Override
	public String toString() {
		return "VideosModel [videoId=" + videoId + ", videoTitle=" + videoTitle + ", videoMimeType=" + videoMimeType
				+ ", excerpts=" + excerpts + ", featuredImage=" + featuredImage + ", videoLink=" + videoLink
				+ ", likesCount=" + likesCount + ", permLink=" + permLink + ", shareCount=" + shareCount + ", slug="
				+ slug + ", status=" + status + ", viewCount=" + viewCount + ", tags=" + tags + ", catId=" + catId
				+ ", partnerId=" + partnerId + ", customerId=" + customerId + "]";
	}
}
