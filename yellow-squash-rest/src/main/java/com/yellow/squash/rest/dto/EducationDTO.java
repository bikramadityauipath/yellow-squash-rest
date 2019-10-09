package com.yellow.squash.rest.dto;

import java.io.Serializable;

import com.yellow.squash.rest.model.EducationModel;

public class EducationDTO implements Serializable {

	private static final long serialVersionUID = 8601405214927195328L;

    private Long eduId;
	
    private String certificationTitle;
    
    private String collegeName;
    
    private String educationDesc;
    
    private String docOne, docTwo, docThree, docFour, docFive;
    
    private Integer passingYear;
	
    private Boolean isApprovedByAdmin;
    
    private Long userId;

	public EducationDTO() {}
	
	public EducationDTO(Long eduId, String certificationTitle, String collegeName, String educationDesc, String docOne, String docTwo, String docThree, String docFour, String docFive, Integer passingYear, Boolean isApprovedByAdmin, Long userId) {
		this.eduId = eduId;
		this.certificationTitle = certificationTitle;
		this.collegeName = collegeName;
		this.educationDesc = educationDesc;
		this.docOne = docOne;
		this.docTwo = docTwo;
		this.docThree = docThree;
		this.docFour = docFour;
		this.docFive = docFive;
		this.passingYear = passingYear;
		this.isApprovedByAdmin = isApprovedByAdmin;
		this.userId = userId;
	}

	public Long getEduId() {
		return eduId;
	}

	public void setEduId(Long eduId) {
		this.eduId = eduId;
	}

	public String getCertificationTitle() {
		return certificationTitle;
	}

	public void setCertificationTitle(String certificationTitle) {
		this.certificationTitle = certificationTitle;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getEducationDesc() {
		return educationDesc;
	}

	public void setEducationDesc(String educationDesc) {
		this.educationDesc = educationDesc;
	}

	public String getDocOne() {
		return docOne;
	}

	public void setDocOne(String docOne) {
		this.docOne = docOne;
	}

	public String getDocTwo() {
		return docTwo;
	}

	public void setDocTwo(String docTwo) {
		this.docTwo = docTwo;
	}

	public String getDocThree() {
		return docThree;
	}

	public void setDocThree(String docThree) {
		this.docThree = docThree;
	}

	public String getDocFour() {
		return docFour;
	}

	public void setDocFour(String docFour) {
		this.docFour = docFour;
	}

	public String getDocFive() {
		return docFive;
	}

	public void setDocFive(String docFive) {
		this.docFive = docFive;
	}

	public Integer getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(Integer passingYear) {
		this.passingYear = passingYear;
	}
	
	public Boolean getIsApprovedByAdmin() {
		return isApprovedByAdmin;
	}

	public void setIsApprovedByAdmin(Boolean isApprovedByAdmin) {
		this.isApprovedByAdmin = isApprovedByAdmin;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/******************* CONVERT TO ENTITY MAPPER FUNCTIONS  *******************/

	public EducationModel toModel(EducationDTO dto) {
		return new EducationModel(dto.getCertificationTitle(), dto.getCollegeName(), dto.getEducationDesc(), dto.getDocOne(), dto.getDocTwo(), dto.getDocThree(), dto.getDocFour(), dto.getDocFive(), dto.getPassingYear(), dto.getIsApprovedByAdmin(), dto.getUserId()); 
	}
	
	public EducationModel toModelForUpdate(EducationDTO dto) {
		return new EducationModel(dto.getEduId(), dto.getCertificationTitle(), dto.getCollegeName(), dto.getEducationDesc(), dto.getDocOne(), dto.getDocTwo(), dto.getDocThree(), dto.getDocFour(), dto.getDocFive(), dto.getPassingYear(), dto.getIsApprovedByAdmin(), dto.getUserId()); 
	}
}