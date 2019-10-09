package com.yellow.squash.rest.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yellow.squash.rest.model.ExpertiseModel;

public class ExpertiseDTO implements Serializable {

	private static final long serialVersionUID = -233512619259761903L;

	private Long expertiseId;
 
    private String expName;
    
    @JsonIgnore private List<PartnerDTO> partner;
    
    @JsonIgnore private List<CategoryDTO> categories;
    
	public ExpertiseDTO() {}
	
	public ExpertiseDTO(Long expertiseId, String expName) {
		super();
		this.expertiseId = expertiseId;
		this.expName = expName;
	}

	public Long getExpertiseId() {
		return expertiseId;
	}

	public void setExpertiseId(Long expertiseId) {
		this.expertiseId = expertiseId;
	}

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	public List<PartnerDTO> getPartner() {
		return partner;
	}

	public void setPartner(List<PartnerDTO> partner) {
		this.partner = partner;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}
	
	/******************* CONVERT TO ENTITY MAPPER FUNCTIONS  *******************/

	public ExpertiseModel toModel(ExpertiseDTO dto) {
		return new ExpertiseModel(dto.getExpertiseId(), dto.getExpName());
    }
}
