
package com.yellow.squash.rest.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.yellow.squash.rest.model.EducationModel;

public interface EducationRepository extends PagingAndSortingRepository<EducationModel, Long> {
	
	List<EducationModel> findByUserId(Long userId);
	
	@Query("SELECT MODEL FROM EducationModel MODEL WHERE MODEL.userId = :userId and MODEL.eduId = :eduId")
	EducationModel findEducationOfPartner(@Param("userId") Long userId, @Param("eduId") Long eduId);

	@Transactional
	@Modifying
	@Query("DELETE EducationModel MODEL WHERE MODEL.userId = :userId and MODEL.eduId = :eduId")
	void deleteMyEducation(@Param("userId") Long userId, @Param("eduId") Long eduId);
}