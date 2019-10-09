package com.yellow.squash.rest.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.yellow.squash.rest.model.TagsModel;

public interface TagRepository extends PagingAndSortingRepository<TagsModel, Long> {

	List<TagsModel> findAll();
}
