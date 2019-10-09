package com.yellow.squash.rest.audit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.yellow.squash.rest.util.AppUtil;


@SuppressWarnings("hiding")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class TimeUserAudit<String> {

	@CreatedBy
	@Column(insertable = true, updatable = false, nullable=true)
    protected String createdBy;
	
    @CreatedDate
    @Column(insertable = true, updatable = false, nullable=false)
    protected Date creationDate;

    @LastModifiedBy
    @Column(insertable = true, updatable = false, nullable=true)
    protected String lastModifiedBy;
    
    @LastModifiedDate
    @Column(insertable = true, updatable = true, nullable=false)
    protected Date lastModifiedDate;

    @PrePersist
    protected void onCreate() {
    	creationDate = lastModifiedDate = AppUtil.getDateAndTime(0);
    }
    
    @PreUpdate
    protected void onUpdate() {
    	lastModifiedDate = AppUtil.getDateAndTime(0);
    }

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}