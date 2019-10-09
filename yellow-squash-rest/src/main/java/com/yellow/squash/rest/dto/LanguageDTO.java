package com.yellow.squash.rest.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yellow.squash.rest.model.LanguageModel;

public class LanguageDTO implements Serializable{

	private static final long serialVersionUID = 5188143729608168131L;

	private Long languageId;
	
	private String languageName;
	
	@JsonIgnore private List<PartnerDTO> partner;
    
	public LanguageDTO() {}

	public LanguageDTO(Long languageId, String languageName) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public List<PartnerDTO> getPartner() {
		return partner;
	}

	public void setPartner(List<PartnerDTO> partner) {
		this.partner = partner;
	}
	
	/******************* CONVERT TO ENTITY MAPPER FUNCTIONS  *******************/

	public LanguageModel toModel(LanguageDTO dto) {
		return new LanguageModel(dto.getLanguageId(), dto.getLanguageName());
    }
}
