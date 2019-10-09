package com.yellow.squash.rest.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yellow.squash.rest.model.LanguageModel;

public interface LanguageRepository extends PagingAndSortingRepository<LanguageModel, Long> {

	List<LanguageModel> findAll();
}