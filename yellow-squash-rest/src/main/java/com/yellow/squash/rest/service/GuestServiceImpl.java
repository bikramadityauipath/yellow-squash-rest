package com.yellow.squash.rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.CategoryDTO;
import com.yellow.squash.rest.dto.ExpertiseDTO;
import com.yellow.squash.rest.dto.LanguageDTO;
import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.dto.TagsDTO;
import com.yellow.squash.rest.dto.VideosDTO;
import com.yellow.squash.rest.enums.PartnerBadgeENUM;
import com.yellow.squash.rest.model.PartnerModel;
import com.yellow.squash.rest.repositories.ArticleRepository;
import com.yellow.squash.rest.repositories.CategoryRepository;
import com.yellow.squash.rest.repositories.ExpertiseRepository;
import com.yellow.squash.rest.repositories.LanguageRepository;
import com.yellow.squash.rest.repositories.PartnerRepository;
import com.yellow.squash.rest.repositories.TagRepository;
import com.yellow.squash.rest.repositories.VideosRepository;

@Repository(value="guestService")
@Transactional
public class GuestServiceImpl implements GuestService{
	
	@Autowired private TagRepository tagsRepo;
	@Autowired private CategoryRepository categoryRepo;
	@Autowired private ExpertiseRepository expertiseRepo;
	@Autowired private LanguageRepository languageRepo;
	@Autowired private PartnerRepository partnerRepo;
	@Autowired private VideosRepository videoRepo;
	@Autowired private ArticleRepository articlesRepo;
	
	@Override
	public List<TagsDTO> getAllTags() {
        return tagsRepo.findAll().stream().map(model -> model.toDTO(model)).collect(Collectors.toList());
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		return categoryRepo.findAll().stream().map(model -> model.toDto(model)).collect(Collectors.toList());
	}
	
	@Override
	public List<ExpertiseDTO> getAllExpertise() {
		return expertiseRepo.findAll().stream().map(model -> model.toDto(model)).collect(Collectors.toList());
	}
	
	@Override
	public List<LanguageDTO> getAllLanguages(){
		return languageRepo.findAll().stream().map(model -> model.toDto(model)).collect(Collectors.toList());
	}

	@Override
	public PartnerDTO savePartner(PartnerDTO partner) {
		PartnerModel model = partnerRepo.save(partner.toModel(partner));
		return model.toDto(model, false);
//		partnerRepo.save(partner.toModel(partner));
	}

	@Override
	public List<PartnerDTO> getAllPartners(){
		return partnerRepo.findAll().stream().map(model -> model.toDto(model, true)).collect(Collectors.toList());
	}
	
	@Override
	public List<PartnerDTO> getAllPartnersByBadge(PartnerBadgeENUM badge) {
		return partnerRepo.findAllByBadge(badge).stream().map(model -> model.toDto(model, true)).collect(Collectors.toList());
	}

	@Override
	public List<PartnerDTO> getAllPartnersByName(String partnerName) {
		return partnerRepo.findAllByFullName(partnerName).stream().map(model -> model.toDto(model, true)).collect(Collectors.toList());
	}

	@Override
	public PartnerDTO fetchPartnerDetails(Long userId) {
		PartnerModel model = partnerRepo.findById(userId).get();
		return model.toDto(model, true);
	}

	@Override
	public List<VideosDTO> getAllVideos() {
		return videoRepo.findAll().stream().map(model -> model.toDto(model)).collect(Collectors.toList());
	}

	@Override
	public List<VideosDTO> getAllVideosByTitle(String title) {
		return videoRepo.findAllByVideoTitleContaining(title).stream().map(model -> model.toDto(model)).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesDTO> getAllArticles() {
		return articlesRepo.findAll().stream().map(model -> model.toDto(model, false)).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesDTO> getAllArticlesByTitle(String title) {
		return articlesRepo.findAllByArticleTitleContaining(title).stream().map(model -> model.toDto(model, false)).collect(Collectors.toList());
	}
	
	@Override
	public Long appointmentsCount() {
		return new Long(12);
	}
	
	@Override
	public Long eventsCount() {
		return new Long(15);
	}
}