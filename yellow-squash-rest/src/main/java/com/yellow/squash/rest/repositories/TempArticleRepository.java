package com.yellow.squash.rest.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yellow.squash.rest.model.TempArticlesModel;

public interface TempArticleRepository extends PagingAndSortingRepository<TempArticlesModel, Long> {

	List<TempArticlesModel> findAll();

	List<TempArticlesModel> findAllByArticleTitle(String title);
	
}