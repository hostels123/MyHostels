package com.hostels.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Images")
public class ImageEntity {

	private String guestId;
	private String name; // Image name or metadata
	private byte[] data; // Binary data for the image
	private String contentType; // To store MIME type (e.g., image/png)
	
	
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}	
}
