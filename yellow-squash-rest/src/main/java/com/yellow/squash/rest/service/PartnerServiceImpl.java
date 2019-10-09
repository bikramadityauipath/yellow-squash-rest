package com.yellow.squash.rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.EducationDTO;
import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.dto.VideosDTO;
import com.yellow.squash.rest.enums.PostStatusENUM;
import com.yellow.squash.rest.model.ArticlesModel;
import com.yellow.squash.rest.model.EducationModel;
import com.yellow.squash.rest.model.PartnerModel;
import com.yellow.squash.rest.model.TempArticlesModel;
import com.yellow.squash.rest.model.TempVideosModel;
import com.yellow.squash.rest.model.VideosModel;
import com.yellow.squash.rest.repositories.ArticleRepository;
import com.yellow.squash.rest.repositories.EducationRepository;
import com.yellow.squash.rest.repositories.PartnerRepository;
import com.yellow.squash.rest.repositories.TempArticleRepository;
import com.yellow.squash.rest.repositories.TempVideosRepository;
import com.yellow.squash.rest.repositories.VideosRepository;

@Repository(value="partnerService")
@Transactional
public class PartnerServiceImpl implements PartnerService{

	@Autowired private PartnerRepository partnerRepo;
	@Autowired private VideosRepository videoRepo;
	@Autowired private ArticleRepository articlesRepo;
	@Autowired private TempArticleRepository tempArticlesRepo;
	@Autowired private TempVideosRepository tempVideoRepo;
	@Autowired private EducationRepository educationRepo;
	
	@Override
	public PartnerDTO myProfile(Long userId) {
		PartnerModel model = partnerRepo.findById(userId).get();
		PartnerDTO dto = model.toDto(model, true /* load Expertise */);
		dto.setLanguages(model.getLanguages().stream().map(language -> language.toDto(language)).collect(Collectors.toList()));
		return dto;
	}

	@Override
	public void updateProfile(PartnerDTO dto) {
		PartnerModel model = partnerRepo.findById(dto.getUserId()).get();
		model.setBadge(dto.getBadge());
		model.setStatus(dto.getStatus());
		model.setFullName(dto.getFullName());
		model.setNewsletterSubFlag(dto.getNewsletterSubFlag());
		model.setCountryLocation(dto.getCountryLocation());
		model.setIntroVideoLink(dto.getIntroVideoLink());
		model.setProfessionalTitle(dto.getProfessionalTitle());
		model.setProfilePicture(dto.getProfilePicture());
		model.setShortBio(dto.getShortBio());
		if(null != dto.getLanguages() && !(dto.getLanguages().isEmpty()))
			model.setLanguages(dto.getLanguages().stream().map(lang -> lang.toModel(lang)).collect(Collectors.toList()));
		if(dto.getExpertise()!=null && !(dto.getExpertise().isEmpty()))
			model.setExpertise(dto.getExpertise().stream().map(exp -> exp.toModel(exp)).collect(Collectors.toList()));
		
		partnerRepo.save(model);
	}
	
	@Override
	public List<EducationDTO> readAllEducation(Long userId){
		return educationRepo.findByUserId(userId).stream().map(model -> model.toDto(model)).collect(Collectors.toList());
	}
	
	@Override
	public void saveEducation(EducationDTO dto) {
		educationRepo.save(dto.toModel(dto));
	}
	
	@Override
	public void updateEducation(EducationDTO dto) {
		educationRepo.save(dto.toModelForUpdate(dto));
	}
	
	@Override
	public EducationDTO readEducation(Long eduId, Long userId) {
		EducationModel model = educationRepo.findEducationOfPartner(userId, eduId);
		return model.toDto(model);
	}
	
	@Override
	public void deleteEducation(Long eduId, Long userId) {
		educationRepo.deleteMyEducation(userId, eduId);
	}
	
	@Override
	public List<ArticlesDTO> myArticles(Long userId) {
		return articlesRepo.findAllByPartnerId(userId).stream().map(model -> model.toDto(model, false)).collect(Collectors.toList());
	}

	@Override
	public void saveArticle(ArticlesDTO dto) {
		articlesRepo.save(dto.toModel(dto));
	}

	@Override
	public ArticlesDTO readArticle(Long articleId, Long userId) {
		ArticlesModel model = articlesRepo.findArticleofPartner(userId, articleId);
		return model.toDto(model, true);
	}

	@Override
	public void updateArticle(ArticlesDTO dto) {
		tempArticlesRepo.save(new TempArticlesModel(dto.getArticleId(), dto.getArticleTitle(), dto.getArticleMimeType(), dto.getExcerpts(), dto.getFeaturedImage(), dto.getHtmlContent(), dto.getPermLink(), dto.getSlug(), dto.getStatus()));
	}

	@Override
	public void deleteArticle(Long articleId, Long userId) {
		articlesRepo.deleteMyArticle(userId, articleId);
	}
	
	@Override
	public void sendArticleForAdminApproval(Long articleId, Long userId) {
		articlesRepo.changeStatus(userId, articleId, PostStatusENUM.Pending);
	}
	
	@Override
	public void publishArticle(Long articleId, Long userId) {
		videoRepo.changeStatus(userId, articleId, PostStatusENUM.Published);
	}

	
	
	@Override
	public List<VideosDTO> myVideos(Long userId) {
		return videoRepo.findAllByPartnerId(userId).stream().map(model -> model.toDto(model)).collect(Collectors.toList());
	}

	@Override
	public void saveVideo(VideosDTO dto) {
		videoRepo.save(dto.toModel(dto));
	}

	@Override
	public VideosDTO readVideo(Long videoId, Long userId) {
		VideosModel model = videoRepo.findVideoofPartner(userId, videoId);
		return model.toDto(model);
	}

	@Override
	public void updateVideo(VideosDTO dto) {
		tempVideoRepo.save(new TempVideosModel(dto.getVideoId(), dto.getVideoTitle(), dto.getVideoMimeType(), dto.getExcerpts(), dto.getFeaturedImage(), dto.getVideoLink(), dto.getPermLink(), dto.getSlug()));
	}

	@Override
	public void deleteVideo(Long videoId, Long userId) {
		System.out.println("Video ID : "+videoId+" - User ID : "+userId);
		videoRepo.deleteMyVideo(userId, videoId);
	}

	@Override
	public void sendVideoForAdminApproval(Long videoId, Long userId) {
		videoRepo.changeStatus(userId, videoId, PostStatusENUM.Pending);
	}

	@Override
	public void publishVideo(Long videoId, Long userId) {
		videoRepo.changeStatus(userId, videoId, PostStatusENUM.Published);
	}
}