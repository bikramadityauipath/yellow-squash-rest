package com.yellow.squash.rest.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.EducationDTO;
import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.dto.VideosDTO;
import com.yellow.squash.rest.response.ListResponse;
import com.yellow.squash.rest.service.PartnerService;
import com.yellow.squash.rest.util.RestConstant;

@RestController
@RequestMapping("/partner")
public class PartnerController {
		
	@Autowired
	private PartnerService service;
	
	@Autowired
	private final Environment environment;
	
	@Autowired
	public PartnerController(final PartnerService service,final Environment environment){
		this.service = service;
		this.environment = environment;
	}
	
//	public PartnerDTO myProfile(Long userId);
	
	@GetMapping(value = "/profile", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> myProfile(Long userId) {
		return new ResponseEntity<PartnerDTO>(service.myProfile(userId), HttpStatus.OK);
    }
	
//	public void updateProfile(PartnerDTO dto);
	
	@PutMapping(value = "/profile", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProfile(@RequestBody PartnerDTO dto) {
		service.updateProfile(dto);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_PROFILE_UPDATE), HttpStatus.OK);
    }
	
//	public List<EducationDTO> readAllEducation(Long userId);
	
	@GetMapping(value = "/educationOfPartner/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> myAllEducation(@PathVariable Long userId) {
		return new ResponseEntity<ListResponse<EducationDTO>>(new ListResponse<EducationDTO>(new ArrayList<EducationDTO>(service.readAllEducation(userId))), HttpStatus.OK);
    }
	
//	public void saveEducation(EducationDTO dto);
	
	@PostMapping(value = "/education", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveEducation(@RequestBody EducationDTO dto) {
		service.saveEducation(dto);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_NEW_EDUCATION_ADDITION), HttpStatus.OK);
    }
	
//	public void updateEducation(EducationDTO dto);
	
	@PutMapping(value = "/education", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEducation(@RequestBody EducationDTO dto) {
		service.updateEducation(dto);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_EDUCATION_UPDATED), HttpStatus.OK);
    }
	
//	public EducationDTO readEducation(Long eduId);
	
	@GetMapping(value = "/education/{eduId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> readEducation(@PathVariable Long eduId, Long userId) {
		return new ResponseEntity<EducationDTO>(service.readEducation(eduId, userId), HttpStatus.OK);
    }
	
//	public void deleteEducation(Long eduId, Long userId);
	
	@DeleteMapping(value = "/education/{eduId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteEducation(@PathVariable Long eduId, Long userId) {
		service.deleteEducation(eduId, userId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_EDUCATION_DELETED), HttpStatus.OK);
    }
	
//	public List<ArticlesDTO> myArticles(Long userId);
	
	@GetMapping(value = "/articles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> myArticles(Long userId) {
		return new ResponseEntity<ListResponse<ArticlesDTO>>(new ListResponse<ArticlesDTO>(new ArrayList<ArticlesDTO>(service.myArticles(userId))), HttpStatus.OK);
    }
	
//	public void saveArticle(ArticlesDTO dto);
	
	@PostMapping(value = "/articles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveArticle(@RequestBody ArticlesDTO dto) {
		service.saveArticle(dto);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_ARTICLE_SAVE), HttpStatus.CREATED);
    }
	
//	public ArticlesDTO readArticle(Long articleId, Long userId);
	
	@GetMapping(value = "/articles/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> readArticle(@PathVariable Long articleId, Long userId) {
		return new ResponseEntity<ArticlesDTO>(service.readArticle(articleId, userId), HttpStatus.OK);
    }
	
//	public void updateArticle(ArticlesDTO dto);
	
	@PutMapping(value = "/articles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateArticle(@RequestBody ArticlesDTO dto) {
		service.updateArticle(dto);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_ARTICLE_UPDATED), HttpStatus.OK);
    }
	
//	public void deleteArticle(Long articleId, Long userId);
	
	@DeleteMapping(value = "/articles/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteArticle(@PathVariable Long articleId, Long userId) {
		service.deleteArticle(articleId, userId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_ARTICLE_DELETED), HttpStatus.OK);
    }
	
//	public List<VideosDTO> myVideos(Long userId);
	
	@GetMapping(value = "/videos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> myVideos(Long userId) {
		return new ResponseEntity<ListResponse<VideosDTO>>(new ListResponse<VideosDTO>(new ArrayList<VideosDTO>(service.myVideos(userId))), HttpStatus.OK);
    }
	
//	public void saveVideo(VideosDTO dto);
	
	@PostMapping(value = "/videos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveVideo(@RequestBody VideosDTO dto) {
		service.saveVideo(dto);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_VIDEO_SAVE), HttpStatus.CREATED);
    }
	
//	public VideosDTO readVideo(Long articleId, Long userId);
	
	@GetMapping(value = "/videos/{videoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> readVideo(@PathVariable Long videoId, Long userId) {
		return new ResponseEntity<VideosDTO>(service.readVideo(videoId, userId), HttpStatus.OK);
    }
	
//	public void updateVideo(VideosDTO dto);
	
	@PutMapping(value = "/videos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateVideo(@RequestBody VideosDTO dto) {
		service.updateVideo(dto);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_VIDEO_UPDATED), HttpStatus.OK);
    }
	
//	public void deleteVideo(Long videoId, Long userId);
	
	@DeleteMapping(value = "/videos/{videoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteVideo(@PathVariable Long videoId, Long userId) {
		service.deleteVideo(videoId, userId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_VIDEO_DELETED), HttpStatus.OK);
    }

//	public void sendArticleForAdminApproval(Long articleId, Long userId);
	
	@PutMapping(value = "/sendArticleForApproval/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendArticleForApproval(Long userId, @PathVariable Long articleId) {
		service.sendArticleForAdminApproval(articleId, userId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_ARTICLE_SUBMITTED_FOR_APPROVAL), HttpStatus.OK);
    }
	
//	public void sendVideoForAdminApproval(Long videoId, Long userId);
	
	@PutMapping(value = "/sendVideoForApproval/{videoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendVideoForApproval(Long userId, @PathVariable Long videoId) {
		service.sendVideoForAdminApproval(videoId, userId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_VIDEO_SUBMITTED_FOR_APPROVAL), HttpStatus.OK);
    }
	
//	public void publishArticle(Long articleId, Long userId);
	
	@PutMapping(value = "/publishArticle/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> publishArticle(Long userId, @PathVariable Long articleId) {
		service.publishArticle(articleId, userId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_ARTICLE_PUBLISH), HttpStatus.OK);
    }
	
//	public void publishVideo(Long videoId, Long userId);

	@PutMapping(value = "/publishVideo/{videoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> publishVideo(Long userId, @PathVariable Long videoId) {
		service.publishVideo(videoId, userId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.PARTNER_VIDEO_PUBLISH), HttpStatus.OK);
    }
}
