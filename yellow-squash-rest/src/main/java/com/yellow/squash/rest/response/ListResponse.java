package com.yellow.squash.rest.response;

import java.io.Serializable;
import java.util.List;

public class ListResponse<T> implements Serializable {
	
	private static final long serialVersionUID = 1505887321530681143L;
	
	private Integer listSize;
	
	private List<T> dtoList;
	
	public ListResponse() {}

	public ListResponse(List<T> dtoList) {
		super();
		this.dtoList = dtoList;
		this.listSize = dtoList.size();
	}

	public List<T> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<T> dtoList) {
		this.dtoList = dtoList;
	}

	public Integer getListSize() {
		return listSize;
	}

	public void setListSize(Integer listSize) {
		this.listSize = listSize;
	}
}
