package com.yellow.squash.rest.dto;

import java.io.Serializable;

import com.yellow.squash.rest.enums.UserRoleENUM;

public class UserBaseDTO implements Serializable{

	private static final long serialVersionUID = -5989354256943903131L;

	private Long userId;
	
	private UserRoleENUM userRole;
	
	private String emailId;
	
	private String mobileNumber;
	
	private String statusFlag;
	
	private String firebaseUid;
	
	private String firstLoginFlag;
	
	private String profileCompleteFlag;
	
	private String facebookAccessFlag;
	
	private String facebookId;
	
	private String googleAccessFlag;
	
	private String googleId;
	
	private String loginIdInUse;
	
	private String twitterAccessFlag;
	
	private String twitterId;

	public UserBaseDTO() {}
	
	public UserBaseDTO(Long userId, UserRoleENUM userRole, String emailId, String mobileNumber) {
		super();
		this.userId = userId;
		this.userRole = userRole;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}
	
	public UserBaseDTO(UserRoleENUM userRole, String emailId, String mobileNumber, String statusFlag, String firebaseUid, String firstLoginFlag, String profileCompleteFlag, String facebookAccessFlag, String facebookId, String googleAccessFlag, String googleId, String loginIdInUse, String twitterAccessFlag,	String twitterId) {
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