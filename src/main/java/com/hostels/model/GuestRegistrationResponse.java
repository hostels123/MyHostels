package com.hostels.model;

public class GuestRegistrationResponse {

	private int guestId;
	private String message;
	private String email;
	private String pgName;
    private String roomNo;
    private String roomSharing;
    private String status;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPgName() {
		return pgName;
	}
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomSharing() {
		return roomSharing;
	}
	public void setRoomSharing(String roomSharing) {
		this.roomSharing = roomSharing;
	}
	@Override
	public String toString() {
		return "GuestRegistrationResponse [guestId=" + guestId + ", message=" + message + ", email=" + email
				+ ", pgName=" + pgName + ", roomNo=" + roomNo + ", roomSharing=" + roomSharing + ", status=" + status
				+ "]";
	}
    
}
