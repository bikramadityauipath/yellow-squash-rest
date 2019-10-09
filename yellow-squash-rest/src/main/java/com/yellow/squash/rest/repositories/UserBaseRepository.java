package com.yellow.squash.rest.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yellow.squash.rest.model.ArticlesModel;

public interface UserBaseRepository extends PagingAndSortingRepository<ArticlesModel, Long> {

}