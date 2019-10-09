package com.yellow.squash.rest.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.yellow.squash.rest.audit.TimeUserAudit;
import com.yellow.squash.rest.dto.LanguageDTO;

@Entity
@Table(name="language")
public class LanguageModel extends TimeUserAudit<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long languageId;
	
	@Column(unique = true, nullable = false, length = 100)
	private String languageName;
	
	@ManyToMany(mappedBy = "languages")
    private List<PartnerModel> partner;
	
	public LanguageModel() {}
	
	public LanguageModel(Long languageId, String languageName) {
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

	public List<PartnerModel> getPartner() {
		return partner;
	}

	public void setPartner(List<PartnerModel> partner) {
		this.partner = partner;
	}

	public LanguageDTO toDto(LanguageModel model) {
		return new LanguageDTO(model.getLanguageId(), model.getLanguageName());
	}
}
