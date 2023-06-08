package com.gufran.shadi.model;

public class Interest {

	private int id;
	private String like;
	private String dislike;
	private String hobbies;
	private String profileUrl;
	private String about;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getDislike() {
		return dislike;
	}
	public void setDislike(String dislike) {
		this.dislike = dislike;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	public Interest(int id, String like, String dislike, String hobbies, String profileUrl, String about) {
		super();
		this.id = id;
		this.like = like;
		this.dislike = dislike;
		this.hobbies = hobbies;
		this.profileUrl = profileUrl;
		this.about = about;
	}
	
	public Interest() {
		super();
	}
	@Override
	public String toString() {
		return "Interest [id=" + id + ", like=" + like + ", dislike=" + dislike + ", hobbies=" + hobbies
				+ ", profileUrl=" + profileUrl + ", about=" + about + "]";
	}
	
}
