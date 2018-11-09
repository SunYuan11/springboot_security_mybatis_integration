package com.sb_ss_myb.frame.domain;

import java.io.Serializable;

public class SbssMenu implements Serializable {

	private static final long serialVersionUID = -8271287551983646908L;
	
	private int id;
	
	private String menuname;
	
	private String url;
	
	private int sortorder;
	
	private int menulevel;
	
	private int parentmenuid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getSortorder() {
		return sortorder;
	}

	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}

	public int getMenulevel() {
		return menulevel;
	}

	public void setMenulevel(int menulevel) {
		this.menulevel = menulevel;
	}

	public int getParentmenuid() {
		return parentmenuid;
	}

	public void setParentmenuid(int parentmenuid) {
		this.parentmenuid = parentmenuid;
	}

	@Override
	public String toString() {
		return "SbssMenu [id=" + id + ", menuname=" + menuname + ", url=" + url
				+ ", sortorder=" + sortorder + ", menulevel=" + menulevel
				+ ", parentmenuid=" + parentmenuid + "]";
	}

}
