package com.bosch.bsj.model;

import java.util.List;

import com.bosch.bsj.entity.QuickParkingStatus;

public class ParkingStatusResult {
	 List<QuickParkingStatus> parkingStatusList;

	public List<QuickParkingStatus> getParkingStatusList() {
		return parkingStatusList;
	}

	public void setParkingStatusList(List<QuickParkingStatus> parkingStatusList) {
		this.parkingStatusList = parkingStatusList;
	}

}
