package com.yellow.squash.rest.service;

import java.util.List;

import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.CategoryDTO;
import com.yellow.squash.rest.dto.ExpertiseDTO;
import com.yellow.squash.rest.dto.LanguageDTO;
import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.dto.TagsDTO;
import com.yellow.squash.rest.dto.VideosDTO;
import com.yellow.squash.rest.enums.PartnerBadgeENUM;

public interface GuestService {

	public List<TagsDTO> getAllTags();
	
	public List<CategoryDTO> getAllCategories();
	
	public List<ExpertiseDTO> getAllExpertise();
	
	public List<LanguageDTO> getAllLanguages();
	
	public PartnerDTO savePartner(PartnerDTO partner);
	
	public List<PartnerDTO> getAllPartners();
	
	public List<PartnerDTO> getAllPartnersByBadge(PartnerBadgeENUM badge);
	
	public List<PartnerDTO> getAllPartnersByName(String partnerName);
	
	public PartnerDTO fetchPartnerDetails(Long userId);
	
	public List<VideosDTO> getAllVideos();
	
	public List<VideosDTO> getAllVideosByTitle(String title);
	
	public List<ArticlesDTO> getAllArticles();
	
	public List<ArticlesDTO> getAllArticlesByTitle(String title);
	
	public Long appointmentsCount();
	
	public Long eventsCount();
}