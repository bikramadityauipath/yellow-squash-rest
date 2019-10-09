package com.yellow.squash.rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.yellow.squash.rest.enums.PartnerBadgeENUM;
import com.yellow.squash.rest.enums.ProfileStatusENUM;
import com.yellow.squash.rest.model.PartnerModel;

public interface PartnerRepository extends PagingAndSortingRepository<PartnerModel, Long> {

	List<PartnerModel> findAll();
	
	PartnerModel findByFirebaseUid(String firebaseUid);
	
	List<PartnerModel> findAllByBadge(PartnerBadgeENUM badge);
	
	List<PartnerModel> findAllByFullName(String fullName);
	
	List<PartnerModel> findAllByStatus(ProfileStatusENUM status);
	
	@Query("UPDATE PartnerModel MODEL SET MODEL.status=:status WHERE MODEL.userId = :userId")
	void adminChangeStatus(@Param("userId") Long userId, @Param("status") ProfileStatusENUM status);
}