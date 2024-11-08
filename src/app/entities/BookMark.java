package app.entities;

import bg.constants.KidFriendlyStatus;

public abstract class BookMark {

	private long id;
	private String title;
	private String profileUrl;
	private String kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;
	private User sharedBy;
	public abstract boolean  iskidFriendlyEligible();
	
	
	public BookMark() {
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setKidFriendlyStatus(String kidFriendlyStatus){
		this.kidFriendlyStatus = kidFriendlyStatus;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}


	
	
	public String getKidFriendlyStatus () {
		return kidFriendlyStatus;
	}
	
	public User getKidFriendlyMarkedBy () {
		return kidFriendlyMarkedBy;
	}
	
	public void setKidFriendlyMarkedBy ( User kidFriendlyMarkedBy ) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}
	
	public void setSharedBy ( User sharedBy ) {
		this.sharedBy = sharedBy;
	}
	
	public User getSharedBy () {
		return sharedBy;
	}
}
