package com.example.cutomadapter;

import java.io.Serializable;

public class Cartoon implements Serializable{
	String title;
	boolean selected;
	int imageId;

	public Cartoon() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public Cartoon(String title, boolean selected, int imageId) {
		super();
		this.title = title;
		this.selected = selected;
		this.imageId = imageId;
	}
}
