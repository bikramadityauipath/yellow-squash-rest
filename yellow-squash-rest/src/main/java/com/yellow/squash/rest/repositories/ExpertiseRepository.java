package com.yellow.squash.rest.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yellow.squash.rest.model.ExpertiseModel;

public interface ExpertiseRepository extends PagingAndSortingRepository<ExpertiseModel, Long> {

	List<ExpertiseModel> findAll();
}