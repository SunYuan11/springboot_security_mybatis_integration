package com.sb_ss_myb.frame.domain;

import java.io.Serializable;

public class SysRole implements Serializable {

	private static final long serialVersionUID = -4815791839189480022L;

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
		return "SysRole [id=" + id + ", name=" + name + "]";
	}
}