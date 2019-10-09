package com.yellow.squash.rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.dto.VideosDTO;
import com.yellow.squash.rest.enums.PostStatusENUM;
import com.yellow.squash.rest.enums.ProfileStatusENUM;
import com.yellow.squash.rest.model.ArticlesModel;
import com.yellow.squash.rest.model.TempVideosModel;
import com.yellow.squash.rest.model.VideosModel;
import com.yellow.squash.rest.repositories.ArticleRepository;
import com.yellow.squash.rest.repositories.PartnerRepository;
import com.yellow.squash.rest.repositories.TempVideosRepository;
import com.yellow.squash.rest.repositories.VideosRepository;

@Repository(value="adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired private PartnerRepository partnerRepo;
	@Autowired private VideosRepository videoRepo;
	@Autowired private ArticleRepository articlesRepo;
	@Autowired private TempVideosRepository tempVideoRepo;

	@Override
	public List<PartnerDTO> allProfilesByStatus(ProfileStatusENUM status){
		return partnerRepo.findAllByStatus(status).stream().map(model -> model.toDto(model, true)).collect(Collectors.toList());
	}
	
	@Override
	public void changeProfileStatus(Long userId, ProfileStatusENUM status) {
		partnerRepo.adminChangeStatus(userId, status);
	}
	
	@Override
	public List<ArticlesDTO> allArticles() {
		return articlesRepo.findAll().stream().map(model -> model.toDto(model, false)).collect(Collectors.toList());
	}

	@Override
	public ArticlesDTO readArticle(Long articleId) {
		ArticlesModel model = articlesRepo.findByArticleId(articleId);
		return model.toDto(model, true);
	}

	@Override
	public void updateArticle(ArticlesDTO dto) {
		articlesRepo.save(new ArticlesModel(dto.getArticleId(), dto.getArticleTitle(), dto.getArticleMimeType(), dto.getExcerpts(), dto.getFeaturedImage(), dto.getHtmlContent(), dto.getPermLink(), dto.getSlug(), dto.getStatus(), dto.getPartnerId(), dto.getCustomerId(), dto.getCatId()));
	}

	@Override
	public void deleteArticle(Long articleId) {
		articlesRepo.adminDeleteArticle(articleId);
	}

	@Override
	public List<VideosDTO> allVideos() {
		return videoRepo.findAll().stream().map(model -> model.toDto(model)).collect(Collectors.toList());
	}

	@Override
	public VideosDTO readVideo(Long videoId) {
		VideosModel model = videoRepo.findByVideoId(videoId);
		return model.toDto(model);
	}

	@Override
	public void updateVideo(VideosDTO dto) {
		tempVideoRepo.save(new TempVideosModel(dto.getVideoId(), dto.getVideoTitle(), dto.getVideoMimeType(), dto.getExcerpts(), dto.getFeaturedImage(), dto.getVideoLink(), dto.getPermLink(), dto.getSlug()));
	}

	@Override
	public void deleteVideo(Long videoId) {
		videoRepo.delete(videoRepo.findByVideoId(videoId));
	}

	@Override
	public void sendArticleForPartnerApproval(Long articleId) {
		articlesRepo.adminChangeStatus(articleId, PostStatusENUM.Approved);
	}

	@Override
	public void sendVideoForPartnerApproval(Long videoId) {
		videoRepo.adminChangeStatus(videoId, PostStatusENUM.Approved);
	}

	@Override
	public void publishArticle(Long articleId) {
		articlesRepo.adminChangeStatus(articleId, PostStatusENUM.Published);
	}

	@Override
	public void publishVideo(Long videoId) {
		videoRepo.adminChangeStatus(videoId, PostStatusENUM.Published);
	}
}