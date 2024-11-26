package com.hostels.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Map;

@Document(collection = "GuestDetails")
public class Guest {
	
	private int guestId;
	private String firstName;
    private String lasName;
    private String email;
    private String pgName;
    private String roomNo;
    private String roomSharing;
    private Long phonenumber;
    private String permanentAddress;
    private String password;
    private Map<String, Object> keys;
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasName() {
		return lasName;
	}
	public void setLasName(String lasName) {
		this.lasName = lasName;
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
	public Long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", firstName=" + firstName + ", lasName=" + lasName + ", email=" + email
				+ ", pgName=" + pgName + ", roomNo=" + roomNo + ", roomSharing=" + roomSharing + ", phonenumber="
				+ phonenumber + ", permanentAddress=" + permanentAddress + ", password=" + password + "]";
	}
    
    
}
