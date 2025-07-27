package com.ttisv.springbootwildfly.payload.response;

public class MessageResponse {
	private String message;
	private Long id;
	String code = "";
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MessageResponse(String message) {
		this.message = message;
	}

	public MessageResponse(Long id, String message) {
		this.id = id;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
