package com.bosch.bsj.entity;

import org.springframework.data.annotation.Id;

public class ParkingStatus {
	@Id
	public String id;

	public String uuid;

	public String status;

	public ParkingStatus() {

	}

	public ParkingStatus(String uuid, String status) {
		super();
		this.uuid = uuid;
		this.status = status;
	}

	public String toString() {
		return String.format("[id = %s, uuid= %s, status = %s", uuid, status);
	}

	public String getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setId(String id) {
		this.id = id;
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
