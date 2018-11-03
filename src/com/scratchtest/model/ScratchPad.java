package com.scratchtest.model;

public class ScratchPad {
	private String title;
	private String description;
	private String userId;
	
	public ScratchPad() {
		super();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "scrathPad [title=" + title + ", description=" + description + ", userId=" + userId + "]";
	}
	public boolean isValidData() {
		return this.title != null && this.description !=null && this.userId !=null;
	}
}
