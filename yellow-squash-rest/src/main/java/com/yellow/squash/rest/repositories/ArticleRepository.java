package com.yellow.squash.rest.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.yellow.squash.rest.enums.PostStatusENUM;
import com.yellow.squash.rest.model.ArticlesModel;

public interface ArticleRepository extends PagingAndSortingRepository<ArticlesModel, Long> {

	List<ArticlesModel> findAll();

	ArticlesModel findByArticleId(Long articleId);
	
	List<ArticlesModel> findAllByPartnerId(Long partnerId);
	
	List<ArticlesModel> findAllByArticleTitleContaining(String title);
	
	@Query("SELECT MODEL FROM ArticlesModel MODEL WHERE MODEL.partnerId = :partnerId and MODEL.articleId = :articleId")
	ArticlesModel findArticleofPartner(@Param("partnerId") Long partnerId, @Param("articleId") Long articleId);
	
	@Transactional
	@Modifying
	@Query("DELETE ArticlesModel MODEL WHERE MODEL.partnerId = :partnerId and MODEL.articleId = :articleId")
	void deleteMyArticle(@Param("partnerId") Long partnerId, @Param("articleId") Long articleId);
	
	@Transactional
	@Modifying
	@Query("DELETE ArticlesModel MODEL WHERE MODEL.articleId = :articleId")
	void adminDeleteArticle(@Param("articleId") Long articleId);
	
	@Query("UPDATE ArticlesModel MODEL SET MODEL.status=:status WHERE MODEL.partnerId = :partnerId and MODEL.articleId = :articleId")
	void changeStatus(@Param("partnerId") Long partnerId, @Param("articleId") Long articleId, @Param("status") PostStatusENUM status);
	
	@Query("UPDATE ArticlesModel MODEL SET MODEL.status=:status WHERE MODEL.articleId = :articleId")
	void adminChangeStatus(@Param("articleId") Long articleId, @Param("status") PostStatusENUM status);
	
}