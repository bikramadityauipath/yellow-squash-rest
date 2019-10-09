package com.yellow.squash.rest.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(referencedColumnName="userId")
public class AdminModel extends UserBaseModel{

	
}
