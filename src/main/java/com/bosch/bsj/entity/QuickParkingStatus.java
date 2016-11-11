package com.bosch.bsj.entity;

import org.springframework.data.annotation.Id;

public class QuickParkingStatus {
	@Id
	public String uuid;

	public String status;

	public QuickParkingStatus() {

	}

	public QuickParkingStatus(String uuid, String status) {
		super();
		this.uuid = uuid;
		this.status = status;
	}

	public String toString() {
		return String.format("[id = %s, uuid= %s, status = %s", uuid, status);
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
