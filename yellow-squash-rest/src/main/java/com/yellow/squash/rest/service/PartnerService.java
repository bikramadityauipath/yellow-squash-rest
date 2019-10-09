package com.yellow.squash.rest.service;

import java.util.List;

import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.EducationDTO;
import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.dto.VideosDTO;

public interface PartnerService {
	
	public PartnerDTO myProfile(Long userId);
	
	public void updateProfile(PartnerDTO dto);
	
	public List<EducationDTO> readAllEducation(Long userId);
	
	public void saveEducation(EducationDTO dto);
	
	public void updateEducation(EducationDTO dto);
	
	public EducationDTO readEducation(Long eduId, Long userId);
	
	public void deleteEducation(Long eduId, Long userId);
	
	
	
	public List<ArticlesDTO> myArticles(Long userId);
	
	public void saveArticle(ArticlesDTO dto);
	
	public ArticlesDTO readArticle(Long articleId, Long userId);
	
	public void updateArticle(ArticlesDTO dto);
	
	public void deleteArticle(Long articleId, Long userId);
	
	public void sendArticleForAdminApproval(Long articleId, Long userId);
	
	public void publishArticle(Long articleId, Long userId);
	
	
	
	public List<VideosDTO> myVideos(Long userId);
	
	public void saveVideo(VideosDTO dto);
	
	public VideosDTO readVideo(Long articleId, Long userId);
	
	public void updateVideo(VideosDTO dto);
	
	public void deleteVideo(Long videoId, Long userId);
	
	public void sendVideoForAdminApproval(Long videoId, Long userId);
	
	public void publishVideo(Long videoId, Long userId);
}