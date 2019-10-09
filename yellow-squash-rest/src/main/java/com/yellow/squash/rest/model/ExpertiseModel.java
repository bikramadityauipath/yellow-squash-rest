package com.yellow.squash.rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.yellow.squash.rest.audit.TimeUserAudit;
import com.yellow.squash.rest.dto.ExpertiseDTO;

@Entity
@Table(name="expertise")
public class ExpertiseModel extends TimeUserAudit<String> {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expertiseId;
 
    private String expName;
    
    @ManyToMany(mappedBy = "expertise")
    private List<PartnerModel> partner;
    
    @ManyToMany(mappedBy = "expertise")
    private List<CategoryModel> categories;
    
    public ExpertiseModel() {}
	
	public ExpertiseModel(Long expertiseId, String expName) {
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

	public List<PartnerModel> getPartner() {
		return partner;
	}

	public void setPartner(List<PartnerModel> partner) {
		this.partner = partner;
	}

	public List<CategoryModel> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryModel> categories) {
		this.categories = categories;
	}
	
	public ExpertiseDTO toDto(ExpertiseModel model) {
		return new ExpertiseDTO(model.getExpertiseId(), model.getExpName());
	}
}
