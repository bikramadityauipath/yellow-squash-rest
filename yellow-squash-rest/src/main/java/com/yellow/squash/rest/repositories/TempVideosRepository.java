package com.yellow.squash.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.yellow.squash.rest.model.TempVideosModel;
import com.yellow.squash.rest.model.VideosModel;

public interface TempVideosRepository extends PagingAndSortingRepository<TempVideosModel, Long> {

	List<TempVideosModel> findAll();
	
	List<TempVideosModel> findAllByVideoTitle(String title);
	
	@Query("SELECT MODEL FROM TempVideosModel MODEL WHERE MODEL.videoId = :videoId")
	VideosModel findVideoofPartner(@Param("videoId") Long videoId);
	
}