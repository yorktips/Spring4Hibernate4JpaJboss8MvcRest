package com.tca.entity;

import java.util.List;

public class Member {
	private boolean newMember;

	private List<String> courses;

	public boolean isNewMember() {

		return newMember;

	}

	public void setNewMember(boolean newMember) {

		this.newMember = newMember;

	}

	public List<String> getCourses() {

		return courses;

	}

	public void setCourses(List<String> courses) {

		this.courses = courses;

	}

}
