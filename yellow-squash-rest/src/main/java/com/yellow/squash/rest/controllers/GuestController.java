package com.yellow.squash.rest.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.CategoryDTO;
import com.yellow.squash.rest.dto.ExpertiseDTO;
import com.yellow.squash.rest.dto.LanguageDTO;
import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.dto.TagsDTO;
import com.yellow.squash.rest.dto.VideosDTO;
import com.yellow.squash.rest.enums.PartnerBadgeENUM;
import com.yellow.squash.rest.response.ListResponse;
import com.yellow.squash.rest.service.GuestService;

@RestController
@RequestMapping("/")
public class GuestController {
		
	@Autowired
	private GuestService service;
	
	@GetMapping(value = "/tags", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allTags() {
		return new ResponseEntity<ListResponse<TagsDTO>>(new ListResponse<TagsDTO>(new ArrayList<TagsDTO>(service.getAllTags())), HttpStatus.OK);
    }
	
	@GetMapping(value = "/categories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allCategories() {
		return new ResponseEntity<ListResponse<CategoryDTO>>(new ListResponse<CategoryDTO>(new ArrayList<CategoryDTO>(service.getAllCategories())), HttpStatus.OK);
    }
	
	@GetMapping(value = "/expertise", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allExpertise() {
		return new ResponseEntity<ListResponse<ExpertiseDTO>>(new ListResponse<ExpertiseDTO>(new ArrayList<ExpertiseDTO>(service.getAllExpertise())), HttpStatus.OK);
    }
	
	@GetMapping(value = "/languages", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allLanguages() {
		return new ResponseEntity<ListResponse<LanguageDTO>>(new ListResponse<LanguageDTO>(new ArrayList<LanguageDTO>(service.getAllLanguages())), HttpStatus.OK);
    }
	
	@PostMapping(value = "/partners", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePartner(@RequestBody PartnerDTO dto) {
		return new ResponseEntity<PartnerDTO>(service.savePartner(dto), HttpStatus.CREATED);
    }
	
	@GetMapping(value = "/partners", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allPartners() {
		return new ResponseEntity<ListResponse<PartnerDTO>>(new ListResponse<PartnerDTO>(new ArrayList<PartnerDTO>(service.getAllPartners())), HttpStatus.OK);
    }
	
	@GetMapping(value = "/partnersByBadge/{badge}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allPartnersByBadge(@PathVariable PartnerBadgeENUM badge) {
		return new ResponseEntity<ListResponse<PartnerDTO>>(new ListResponse<PartnerDTO>(new ArrayList<PartnerDTO>(service.getAllPartnersByBadge(badge))), HttpStatus.OK);
    }
	
	@GetMapping(value = "/partnersByName/{partnerName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allPartnersByPartnerName(@PathVariable String partnerName) {
		return new ResponseEntity<ListResponse<PartnerDTO>>(new ListResponse<PartnerDTO>(new ArrayList<PartnerDTO>(service.getAllPartnersByName(partnerName))), HttpStatus.OK);
    }
	
	@GetMapping(value = "/partners/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allPartnersById(@PathVariable Long userId) {
		return new ResponseEntity<PartnerDTO>(service.fetchPartnerDetails(userId), HttpStatus.OK);
    }
	
	@GetMapping(value = "/videos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allVideos() {
		return new ResponseEntity<ListResponse<VideosDTO>>(new ListResponse<VideosDTO>(new ArrayList<VideosDTO>(service.getAllVideos())), HttpStatus.OK);
    }
	
	@GetMapping(value = "/videos/{title}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allVideosByTitle(@PathVariable String title) {
		return new ResponseEntity<ListResponse<VideosDTO>>(new ListResponse<VideosDTO>(new ArrayList<VideosDTO>(service.getAllVideosByTitle(title))), HttpStatus.OK);
    }
	
	@GetMapping(value = "/articles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allarticles() {
		return new ResponseEntity<ListResponse<ArticlesDTO>>(new ListResponse<ArticlesDTO>(new ArrayList<ArticlesDTO>(service.getAllArticles())), HttpStatus.OK);
    }
	
	@GetMapping(value = "/articles/{title}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allArticlesByTitle(@PathVariable String title) {
		return new ResponseEntity<ListResponse<ArticlesDTO>>(new ListResponse<ArticlesDTO>(new ArrayList<ArticlesDTO>(service.getAllArticlesByTitle(title))), HttpStatus.OK);
    }
}
