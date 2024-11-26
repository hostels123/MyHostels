package com.hostels.model;

public class GuestLogInResponse {
	
	private String status;
	private String email;
	private int guestId;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	@Override
	public String toString() {
		return "GuestLogInResponse [status=" + status + ", email=" + email + ", guestId=" + guestId + "]";
	}
}
