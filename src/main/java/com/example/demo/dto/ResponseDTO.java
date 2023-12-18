package com.example.demo.dto;

import org.springframework.stereotype.Component;
@Component
public class ResponseDTO {
	private int statuscode;
	private String status;
	private Data data;
	// Default constructor
	public ResponseDTO() {
	}
	// Constructor with status, status code, and data
	public ResponseDTO(int statuscode, String status, Data data) {
		this.statuscode = statuscode;
		this.status = status;
		this.data = data;
	}
	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public static class Data {
		private int userid;
		private String userName;
		private String email;
		private String password;
		
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}		
	}
}

