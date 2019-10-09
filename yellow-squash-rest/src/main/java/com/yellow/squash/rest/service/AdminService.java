package com.yellow.squash.rest.service;

import java.util.List;

import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.dto.VideosDTO;
import com.yellow.squash.rest.enums.ProfileStatusENUM;

public interface AdminService {

	public List<PartnerDTO> allProfilesByStatus(ProfileStatusENUM status);
	
	public void changeProfileStatus(Long userId, ProfileStatusENUM status);
	
	public List<ArticlesDTO> allArticles();
	
	public ArticlesDTO readArticle(Long articleId);
	
	public void updateArticle(ArticlesDTO dto);
	
	public void deleteArticle(Long articleId);
	
	public List<VideosDTO> allVideos();
	
	public VideosDTO readVideo(Long videoId);
	
	public void updateVideo(VideosDTO dto);
	
	public void deleteVideo(Long videoId);
	
	public void sendArticleForPartnerApproval(Long articleId);

	public void sendVideoForPartnerApproval(Long videoId);
	
	public void publishArticle(Long articleId);
	
	public void publishVideo(Long videoId);
}