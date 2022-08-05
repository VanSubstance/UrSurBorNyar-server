package com.my.bookmarker.vo.vanilla;

public class Basic {
	private String name;
	private String id;
	
	public String toString() {
		return "{\n" + "\tid : " + id + "\n" + "\tname : " + name + "\n" + "}";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
