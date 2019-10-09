package com.yellow.squash.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yellow.squash.rest.audit.TimeUserAudit;

@Entity
@Table(name="temp_videos")
public class TempVideosModel extends TimeUserAudit<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private Long randomId;
	
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
	
	@Column(nullable = false, length = 255)
	private String permLink;
	
	@Column(length = 200)
	private String slug;

	public TempVideosModel() {}
	
	public TempVideosModel(Long videoId, String videoTitle, String videoMimeType, String excerpts, String featuredImage, String videoLink, String permLink, String slug) {
		super();
		this.videoId = videoId;
		this.videoTitle = videoTitle;
		this.videoMimeType = videoMimeType;
		this.excerpts = excerpts;
		this.featuredImage = featuredImage;
		this.videoLink = videoLink;
		this.permLink = permLink;
		this.slug = slug;
	}

	public Long getRandomId() {
		return randomId;
	}

	public void setRandomId(Long randomId) {
		this.randomId = randomId;
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
}
