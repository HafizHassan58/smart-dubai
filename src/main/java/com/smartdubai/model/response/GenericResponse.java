package com.smartdubai.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class GenericResponse implements Serializable {

	private static final long serialVersionUID = 2125616121604222247L;
	private String message;
	private boolean status;
	private Object data;

	public GenericResponse() {
		this.message = "Failed";
		this.status = false;
		this.data = null;
	}

	public GenericResponse(String msg, boolean stat, Object obj) {
		this.message = msg;
		this.status = stat;
		this.data = obj;
	}

	public GenericResponse(boolean status, String msg) {
		this.status = status;
		this.message = msg;
	}

}
