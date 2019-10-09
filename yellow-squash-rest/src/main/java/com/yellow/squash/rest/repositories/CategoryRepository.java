package com.yellow.squash.rest.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yellow.squash.rest.model.CategoryModel;

public interface CategoryRepository extends PagingAndSortingRepository<CategoryModel, Long> {

	List<CategoryModel> findAll();
}
