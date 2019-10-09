package com.yellow.squash.rest.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.yellow.squash.rest.enums.PostStatusENUM;
import com.yellow.squash.rest.model.VideosModel;

public interface VideosRepository extends PagingAndSortingRepository<VideosModel, Long> {

	List<VideosModel> findAll();
	
	List<VideosModel> findAllByPartnerId(Long partnerId);

	VideosModel findByVideoId(Long videoId);
	
	List<VideosModel> findAllByVideoTitleContaining(String title);
	
	@Query("SELECT MODEL FROM VideosModel MODEL WHERE MODEL.partnerId = :partnerId and MODEL.videoId = :videoId")
	VideosModel findVideoofPartner(@Param("partnerId") Long partnerId, @Param("videoId") Long videoId);

	@Transactional
	@Modifying
	@Query("DELETE VideosModel MODEL WHERE MODEL.partnerId = :partnerId and MODEL.videoId = :videoId")
	void deleteMyVideo(@Param("partnerId") Long partnerId, @Param("videoId") Long videoId);
	
	@Query("UPDATE VideosModel MODEL SET MODEL.status=:status WHERE MODEL.partnerId = :partnerId and MODEL.videoId = :videoId")
	void changeStatus(@Param("partnerId") Long partnerId, @Param("videoId") Long videoId, @Param("status") PostStatusENUM status);
	
	@Query("UPDATE VideosModel MODEL SET MODEL.status=:status WHERE MODEL.videoId = :videoId")
	void adminChangeStatus(@Param("videoId") Long videoId, @Param("status") PostStatusENUM status);
}