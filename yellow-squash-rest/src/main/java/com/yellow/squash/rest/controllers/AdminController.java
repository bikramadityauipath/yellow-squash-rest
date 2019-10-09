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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.squash.rest.dto.ArticlesDTO;
import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.dto.VideosDTO;
import com.yellow.squash.rest.enums.ProfileStatusENUM;
import com.yellow.squash.rest.response.ListResponse;
import com.yellow.squash.rest.service.AdminService;
import com.yellow.squash.rest.util.RestConstant;

@RestController
@RequestMapping("/admin")
public class AdminController {
		
	@Autowired
	private AdminService service;
	
	@Autowired
	private final Environment environment;
	
	@Autowired
	public AdminController(final AdminService service,final Environment environment){
		this.service = service;
		this.environment = environment;
	}

//	public List<PartnerDTO> allProfilesByStatus(ProfileStatusENUM status);
	
	@GetMapping(value = "/profiles/{status}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allProfilesByStatus(@PathVariable ProfileStatusENUM status) {
		return new ResponseEntity<ListResponse<PartnerDTO>>(new ListResponse<PartnerDTO>(new ArrayList<PartnerDTO>(service.allProfilesByStatus(status))), HttpStatus.OK);
    }
	
//	public void changeProfileStatus(Long userId, ProfileStatusENUM status);
	
	@PutMapping(value = "/profiles/changeStatus/{userId}/{status}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changeProfileStatus(@PathVariable ProfileStatusENUM status, @PathVariable Long userId) {
		service.changeProfileStatus(userId, status);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.ADMIN_PROFILE_STATUS_CHANGE), HttpStatus.OK);
    }
	
//	public List<ArticlesDTO> allArticles();
	
	@GetMapping(value = "/articles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allArticles(Long userId) {
		return new ResponseEntity<ListResponse<ArticlesDTO>>(new ListResponse<ArticlesDTO>(new ArrayList<ArticlesDTO>(service.allArticles())), HttpStatus.OK);
    }
	
//	public ArticlesDTO readArticle(Long articleId);
	
	@GetMapping(value = "/articles/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> readArticle(@PathVariable Long articleId) {
		return new ResponseEntity<ArticlesDTO>(service.readArticle(articleId), HttpStatus.OK);
    }
	
//	public void updateArticle(ArticlesDTO dto);
	
	@PutMapping(value = "/articles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateArticle(@RequestBody ArticlesDTO dto) {
		service.updateArticle(dto);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.ADMIN_ARTICLE_UPDATED), HttpStatus.OK);
    }
	
//	public void deleteArticle(Long articleId);
	
	@DeleteMapping(value = "/articles/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteArticle(@PathVariable Long articleId) {
		service.deleteArticle(articleId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.ADMIN_ARTICLE_DELETED), HttpStatus.OK);
    }
	
//	public List<VideosDTO> allVideos();
	
	@GetMapping(value = "/videos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> allVideos(Long userId) {
		return new ResponseEntity<ListResponse<VideosDTO>>(new ListResponse<VideosDTO>(new ArrayList<VideosDTO>(service.allVideos())), HttpStatus.OK);
    }
	
//	public VideosDTO readVideo(Long videoId);
	
	@GetMapping(value = "/videos/{videoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> readVideo(@PathVariable Long videoId) {
		return new ResponseEntity<VideosDTO>(service.readVideo(videoId), HttpStatus.OK);
    }
	
//	public void updateVideo(VideosDTO dto);
	
	@PutMapping(value = "/videos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateVideo(@RequestBody VideosDTO dto) {
		service.updateVideo(dto);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.ADMIN_VIDEO_UPDATED), HttpStatus.OK);
    }
	
//	public void deleteVideo(Long videoId);
	
	@DeleteMapping(value = "/videos/{videoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteVideo(@PathVariable Long videoId) {
		service.deleteArticle(videoId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.ADMIN_VIDEO_DELETED), HttpStatus.OK);
    }
	
//	public void sendArticleForPartnerApproval(Long articleId);
	
	@PutMapping(value = "/sendArticleForPartnerApproval/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendArticleForPartnerApproval(@PathVariable Long articleId) {
		service.sendArticleForPartnerApproval(articleId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.ADMIN_ARTICLE_SUBMITTED_FOR_PARTNER_APPROVAL), HttpStatus.OK);
    }

//	public void sendVideoForPartnerApproval(Long videoId);
	
	@PutMapping(value = "/sendVideoForPartnerApproval/{videoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendVideoForPartnerApproval(@PathVariable Long videoId) {
		service.sendVideoForPartnerApproval(videoId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.ADMIN_VIDEO_SUBMITTED_FOR_PARTNER_APPROVAL), HttpStatus.OK);
    }
	
//	public void publishArticle(Long articleId);
	
	@PutMapping(value = "/publishArticle/{articleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> publishArticle(@PathVariable Long articleId) {
		service.publishArticle(articleId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.ADMIN_ARTICLE_PUBLISH), HttpStatus.OK);
    }
	
//	public void publishVideo(Long videoId);
	
	@PutMapping(value = "/publishVideo/{videoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> publishVideo(@PathVariable Long videoId) {
		service.publishVideo(videoId);
		return new ResponseEntity<String>(environment.getProperty(RestConstant.ADMIN_VIDEO_PUBLISH), HttpStatus.OK);
    }
}
