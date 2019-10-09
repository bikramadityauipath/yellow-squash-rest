package com.yellow.squash.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yellow.squash.rest.audit.TimeUserAudit;
import com.yellow.squash.rest.dto.EducationDTO;

@Entity
@Table(name="education")
public class EducationModel extends TimeUserAudit<String> {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="edu_id", unique=true, nullable=false, precision=10)
    private Long eduId;
	
    @Column(nullable=false, length=200)
    private String certificationTitle;
    
    @Column(length=200)
    private String collegeName;
    
    @Column(length=200)
    private String educationDesc;
    
    @Column(length=200)
    private String docOne, docTwo, docThree, docFour, docFive;
    
    @Column(nullable=false, precision=10)
    private Integer passingYear;
	
    private Boolean isApprovedByAdmin;
    
    private Long userId;
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName="userId",insertable=false, updatable=false)
	private PartnerModel partner;
    
	public EducationModel() {}
	
	public EducationModel(String certificationTitle, String collegeName, String educationDesc, 	String docOne, String docTwo, String docThree, String docFour, String docFive, Integer passingYear, Boolean isApprovedByAdmin, Long userId) {
		super();
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
	
	public EducationModel(Long eduId, String certificationTitle, String collegeName, String educationDesc, 	String docOne, String docTwo, String docThree, String docFour, String docFive, Integer passingYear, Boolean isApprovedByAdmin, Long userId) {
		super();
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

	public PartnerModel getPartner() {
		return partner;
	}

	public void setPartner(PartnerModel partner) {
		this.partner = partner;
	}
	
	public EducationDTO toDto(EducationModel model) {
		return new EducationDTO(model.getEduId(), model.getCertificationTitle(), model.getCollegeName(), model.getEducationDesc(), model.getDocOne(), model.getDocTwo(), model.getDocThree(), model.getDocFour(), model.getDocFive(), model.getPassingYear(), model.getIsApprovedByAdmin(), model.getUserId());
	}
}