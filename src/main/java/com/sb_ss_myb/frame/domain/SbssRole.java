package com.sb_ss_myb.frame.domain;

import java.io.Serializable;

public class SbssRole implements Serializable {

	private static final long serialVersionUID = 8804566121041610462L;

	private Integer id;
	
    private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SbssRole [id=" + id + ", name=" + name + "]";
	}
    
}
