package com.yellow.squash.rest.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.yellow.squash.rest.dto.PartnerDTO;
import com.yellow.squash.rest.enums.PartnerBadgeENUM;
import com.yellow.squash.rest.enums.ProfileStatusENUM;
import com.yellow.squash.rest.enums.UserRoleENUM;

@Entity
@Table(name="partner")
@PrimaryKeyJoinColumn(referencedColumnName="userId")
public class PartnerModel extends UserBaseModel{

	@Enumerated(EnumType.STRING)
	private PartnerBadgeENUM badge;
	
	@Enumerated(EnumType.STRING)
	private ProfileStatusENUM status;
	
	@Column(length = 100)
	private String fullName;
	
	@Column(nullable = false, length = 1)
	private Boolean newsletterSubFlag;
	
	@Column(length = 50)
	private String countryLocation;
	
	@Column(length = 500)
	private String introVideoLink;
	
	@Column(length = 100)
	private String professionalTitle;
	
	@Column(length = 500)
	private String profilePicture;
	
	@Column(length = 500)
	private String shortBio;
	
    /***** RELATIONSHIPS *****/
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "partner_expertise", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "expertise_id", referencedColumnName = "expertiseId"))
    private List<ExpertiseModel> expertise;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "partner_languages", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "languageId"))
    private List<LanguageModel> languages;
    
    @OneToMany(mappedBy="partner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ArticlesModel> articles;
    
    @OneToMany(mappedBy="partner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<VideosModel> videos;
    
    @OneToMany(mappedBy="partner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<EducationModel> education;
    
    @OneToMany(mappedBy="partner", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<UserContractModel> contract;

	public PartnerModel() {}
	
	public PartnerModel(UserRoleENUM userRole, String emailId, String mobileNumber, String statusFlag, String firebaseUid, String firstLoginFlag, String profileCompleteFlag, String facebookAccessFlag, String facebookId, String googleAccessFlag, String googleId, String loginIdInUse, String twitterAccessFlag, String twitterId, PartnerBadgeENUM badge, ProfileStatusENUM status, String fullName, Boolean newsletterSubFlag, String countryLocation, String introVideoLink, String professionalTitle, String profilePicture, String shortBio) {
		super(userRole, emailId, mobileNumber, statusFlag, firebaseUid, firstLoginFlag, profileCompleteFlag, facebookAccessFlag, facebookId, googleAccessFlag, googleId, loginIdInUse, twitterAccessFlag, twitterId);
		this.badge = badge;
		this.status = status;
		this.fullName = fullName;
		this.newsletterSubFlag = newsletterSubFlag;
		this.countryLocation = countryLocation;
		this.introVideoLink = introVideoLink;
		this.professionalTitle = professionalTitle;
		this.profilePicture = profilePicture;
		this.shortBio = shortBio;
	}

	public PartnerBadgeENUM getBadge() {
		return badge;
	}

	public void setBadge(PartnerBadgeENUM badge) {
		this.badge = badge;
	}

	public ProfileStatusENUM getStatus() {
		return status;
	}

	public void setStatus(ProfileStatusENUM status) {
		this.status = status;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getNewsletterSubFlag() {
		return newsletterSubFlag;
	}

	public void setNewsletterSubFlag(Boolean newsletterSubFlag) {
		this.newsletterSubFlag = newsletterSubFlag;
	}

	public String getCountryLocation() {
		return countryLocation;
	}

	public void setCountryLocation(String countryLocation) {
		this.countryLocation = countryLocation;
	}

	public String getIntroVideoLink() {
		return introVideoLink;
	}

	public void setIntroVideoLink(String introVideoLink) {
		this.introVideoLink = introVideoLink;
	}

	public String getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getShortBio() {
		return shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

	public List<ExpertiseModel> getExpertise() {
		return expertise;
	}

	public void setExpertise(List<ExpertiseModel> expertise) {
		this.expertise = expertise;
	}

	public List<LanguageModel> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageModel> languages) {
		this.languages = languages;
	}

	public List<ArticlesModel> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticlesModel> articles) {
		this.articles = articles;
	}

	public List<VideosModel> getVideos() {
		return videos;
	}

	public void setVideos(List<VideosModel> videos) {
		this.videos = videos;
	}

	public List<EducationModel> getEducation() {
		return education;
	}

	public void setEducation(List<EducationModel> education) {
		this.education = education;
	}

	public List<UserContractModel> getContract() {
		return contract;
	}

	public void setContract(List<UserContractModel> contract) {
		this.contract = contract;
	}
	
	public PartnerDTO toDto(PartnerModel model, boolean loadExpertise) {
		PartnerDTO dto = new PartnerDTO(model.getUserId(), model.getUserRole(), model.getEmailId(), model.getMobileNumber(), model.getBadge(), model.getStatus(), model.getFullName(), model.getNewsletterSubFlag(), model.getCountryLocation(), model.getIntroVideoLink(), model.getProfessionalTitle(), model.getProfilePicture(), model.getShortBio());
		if(loadExpertise)
		dto.setExpertise(model.getExpertise().stream().map(expertise -> expertise.toDto(expertise)).collect(Collectors.toList()));
		return dto;
	}
}
