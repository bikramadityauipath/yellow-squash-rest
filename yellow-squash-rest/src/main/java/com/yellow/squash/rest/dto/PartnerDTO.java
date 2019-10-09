package com.yellow.squash.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yellow.squash.rest.enums.PartnerBadgeENUM;
import com.yellow.squash.rest.enums.ProfileStatusENUM;
import com.yellow.squash.rest.enums.UserRoleENUM;
import com.yellow.squash.rest.model.PartnerModel;

public class PartnerDTO extends UserBaseDTO{

	private static final long serialVersionUID = -8950908209555309346L;
	
	private PartnerBadgeENUM badge;

	private ProfileStatusENUM status;
	
	private String fullName;
	
	private Boolean newsletterSubFlag;
	
	private String countryLocation;
	
	private String introVideoLink;
	
	private String professionalTitle;
	
	private String profilePicture;
	
	private String shortBio;
	
    /***** RELATIONSHIPS *****/
    
    private List<ExpertiseDTO> expertise;
    
    private List<LanguageDTO> languages;
    
    @JsonIgnore private List<ArticlesDTO> articles;
    
    @JsonIgnore private List<VideosDTO> videos;
    
	private List<EducationDTO> education;
    
	@JsonIgnore private List<UserContractDTO> contract;
	
	/***** CONSTRUCTORS *****/
	
	public PartnerDTO() {}

	public PartnerDTO(Long userId, UserRoleENUM userRole, String emailId, String mobileNumber, PartnerBadgeENUM badge, ProfileStatusENUM status, String fullName, Boolean newsletterSubFlag, String countryLocation, String introVideoLink, String professionalTitle, String profilePicture,	String shortBio) {
		super(userId, userRole, emailId, mobileNumber);
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

	/***** GETTERS & SETTERS *****/

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

	public List<ExpertiseDTO> getExpertise() {
		return expertise;
	}

	public void setExpertise(List<ExpertiseDTO> expertise) {
		this.expertise = expertise;
	}

	public List<LanguageDTO> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageDTO> languages) {
		this.languages = languages;
	}

	public List<ArticlesDTO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticlesDTO> articles) {
		this.articles = articles;
	}

	public List<VideosDTO> getVideos() {
		return videos;
	}

	public void setVideos(List<VideosDTO> videos) {
		this.videos = videos;
	}

	public List<EducationDTO> getEducation() {
		return education;
	}

	public void setEducation(List<EducationDTO> education) {
		this.education = education;
	}

	public List<UserContractDTO> getContract() {
		return contract;
	}

	public void setContract(List<UserContractDTO> contract) {
		this.contract = contract;
	}
	
	@Override
	public String toString() {
		return "PartnerDTO [badge=" + badge + ", status=" + status + ", fullName=" + fullName
				+ ", newsletterSubFlag=" + newsletterSubFlag + ", countryLocation=" + countryLocation
				+ ", introVideoLink=" + introVideoLink + ", professionalTitle=" + professionalTitle
				+ ", profilePicture=" + profilePicture + ", shortBio=" + shortBio + ", expertise=" + expertise
				+ ", languages=" + languages + ", articles=" + articles + ", videos=" + videos + ", education="
				+ education + ", contract=" + contract + "]";
	}

	/******************* CONVERT TO ENTITY MAPPER FUNCTIONS  *******************/

	public PartnerModel toModel(PartnerDTO dto) {
		return new PartnerModel(dto.getUserRole(), dto.getEmailId(), dto.getMobileNumber(), dto.getStatusFlag(), dto.getFirebaseUid(), dto.getFirstLoginFlag(), dto.getProfileCompleteFlag(), dto.getFacebookAccessFlag(), dto.getFacebookId(), dto.getGoogleAccessFlag(), dto.getGoogleId(), dto.getLoginIdInUse(), dto.getTwitterAccessFlag(), dto.getTwitterId(), dto.getBadge(), dto.getStatus(), dto.getFullName(), dto.getNewsletterSubFlag(), dto.getCountryLocation(), dto.getIntroVideoLink(), dto.getProfessionalTitle(), dto.getProfilePicture(), dto.getShortBio());
    }
}
