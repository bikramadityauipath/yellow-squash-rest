package com.yellow.squash.rest.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yellow.squash.rest.enums.PostStatusENUM;
import com.yellow.squash.rest.enums.UserRoleENUM;
import com.yellow.squash.rest.model.TagsModel;
import com.yellow.squash.rest.model.VideosModel;

public class VideosDTO implements Serializable{
	
	private static final long serialVersionUID = 1037379532030304559L;

	private Long videoId;
	
	private String videoTitle;

	private String videoMimeType;

	private String excerpts;
	
	private String featuredImage;
	
	private String videoLink;
	
	private Long likesCount;
	
	private String permLink;
	
	private Long shareCount;

	private String slug;
	
	private PostStatusENUM status;
	
	private Long viewCount;
	
    private List<TagsDTO> tags;
	
	private Long catId;
	private CategoryDTO category;
	
	private Long partnerId;
	@JsonIgnore private PartnerDTO partner;
	
	private Long customerId;
	@JsonIgnore private CustomerDTO customer;
	
	private Long authorId;
	private String catName, authorName;
	private UserRoleENUM authorType;
	
	public VideosDTO() {}
	
	public VideosDTO(Long videoId, String videoTitle, String videoMimeType, String excerpts, String featuredImage, String videoLink, Long likesCount, String permLink, Long shareCount, String slug, PostStatusENUM status, Long viewCount, Long catId, String catName) {
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
		this.catName = catName;
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

	public VideosModel toModel(VideosDTO dto) {
		VideosModel video = new VideosModel(dto.getVideoTitle(), dto.getVideoMimeType(), dto.getExcerpts(), dto.getFeaturedImage(), dto.getVideoLink(), dto.getLikesCount(), dto.getPermLink(), dto.getShareCount(), dto.getSlug(), dto.getStatus(), dto.getViewCount(), dto.getCatId(), dto.getPartnerId(), dto.getCustomerId());
		video.setTags(dto.getTags().stream().map(tag -> new TagsModel(tag.getTagId(), tag.getTagName())).collect(Collectors.toList()));
		return video;
    }
}
