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

@Entity
@Table(name="contract")
public class UserContractModel extends TimeUserAudit<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private Long contractId;
	
	private Long userId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName="userId",insertable=false, updatable=false)
	private PartnerModel partner;

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

	public PartnerModel getPartner() {
		return partner;
	}

	public void setPartner(PartnerModel partner) {
		this.partner = partner;
	}
}
