package com.yellow.squash.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserContractDTO implements Serializable{

	private static final long serialVersionUID = 3191611034896154222L;

	private Long contractId;
	
	private Long userId;
	@JsonIgnore private PartnerDTO partner;

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public PartnerDTO getPartner() {
		return partner;
	}

	public void setPartner(PartnerDTO partner) {
		this.partner = partner;
	}
}
