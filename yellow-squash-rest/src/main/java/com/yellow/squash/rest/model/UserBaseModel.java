package com.yellow.squash.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.yellow.squash.rest.audit.TimeUserAudit;
import com.yellow.squash.rest.enums.UserRoleENUM;

@Entity
@Table(name="user_account", uniqueConstraints={@UniqueConstraint(columnNames = {"emailId"})})
@Inheritance(strategy=InheritanceType.JOINED)
public class UserBaseModel extends TimeUserAudit<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private Long userId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 50)
	private UserRoleENUM userRole;
	
	@Column(nullable = false, length = 320)
	private String emailId;
	
	@Column(nullable = false, length = 15)
	private String mobileNumber;
	
	@Column(nullable = true, length = 10)
	private String statusFlag;
	
	@Column(nullable = false, length = 50)
	private String firebaseUid;
	
	@Column(nullable = true, length = 1)
	private String firstLoginFlag;
	
	@Column(nullable = true, length = 1)
	private String profileCompleteFlag;
	
	@Column(nullable = true, length = 1)
	private String facebookAccessFlag;
	
	@Column(length = 100)
	private String facebookId;
	
	@Column(nullable = true, length = 1)
	private String googleAccessFlag;
	
	@Column(length = 100)
	private String googleId;
	
	@Column(nullable = true, length = 15)
	private String loginIdInUse;
	
	@Column(nullable = true, length = 1)
	private String twitterAccessFlag;
	
	@Column(length = 320)
	private String twitterId;
	
	public UserBaseModel() {}
	
	public UserBaseModel(UserRoleENUM userRole, String emailId, String mobileNumber, String statusFlag, String firebaseUid, String firstLoginFlag, String profileCompleteFlag, String facebookAccessFlag, String facebookId, String googleAccessFlag, String googleId, String loginIdInUse, String twitterAccessFlag, String twitterId) {
		super();
		this.userRole = userRole;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.statusFlag = statusFlag;
		this.firebaseUid = firebaseUid;
		this.firstLoginFlag = firstLoginFlag;
		this.profileCompleteFlag = profileCompleteFlag;
		this.facebookAccessFlag = facebookAccessFlag;
		this.facebookId = facebookId;
		this.googleAccessFlag = googleAccessFlag;
		this.googleId = googleId;
		this.loginIdInUse = loginIdInUse;
		this.twitterAccessFlag = twitterAccessFlag;
		this.twitterId = twitterId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserRoleENUM getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleENUM userRole) {
		this.userRole = userRole;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getFirebaseUid() {
		return firebaseUid;
	}

	public void setFirebaseUid(String firebaseUid) {
		this.firebaseUid = firebaseUid;
	}

	public String getFirstLoginFlag() {
		return firstLoginFlag;
	}

	public void setFirstLoginFlag(String firstLoginFlag) {
		this.firstLoginFlag = firstLoginFlag;
	}

	public String getProfileCompleteFlag() {
		return profileCompleteFlag;
	}

	public void setProfileCompleteFlag(String profileCompleteFlag) {
		this.profileCompleteFlag = profileCompleteFlag;
	}

	public String getFacebookAccessFlag() {
		return facebookAccessFlag;
	}

	public void setFacebookAccessFlag(String facebookAccessFlag) {
		this.facebookAccessFlag = facebookAccessFlag;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getGoogleAccessFlag() {
		return googleAccessFlag;
	}

	public void setGoogleAccessFlag(String googleAccessFlag) {
		this.googleAccessFlag = googleAccessFlag;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getLoginIdInUse() {
		return loginIdInUse;
	}

	public void setLoginIdInUse(String loginIdInUse) {
		this.loginIdInUse = loginIdInUse;
	}

	public String getTwitterAccessFlag() {
		return twitterAccessFlag;
	}

	public void setTwitterAccessFlag(String twitterAccessFlag) {
		this.twitterAccessFlag = twitterAccessFlag;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
}