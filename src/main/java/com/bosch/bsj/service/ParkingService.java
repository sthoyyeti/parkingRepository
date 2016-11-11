package com.bosch.bsj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bosch.bsj.entity.ParkingStatus;
import com.bosch.bsj.entity.QuickParkingStatus;
import com.bosch.bsj.model.ParkingStatusResult;
import com.bosch.bsj.repository.ParkingStatusRepository;
import com.bosch.bsj.repository.QuickParkingStatusRepository;

@Service
public class ParkingService {
	@Autowired
	private ParkingStatusRepository parkRepo;

    @Autowired
	private QuickParkingStatusRepository quickParkRepo;
	
	public void saveParkingStatus(QuickParkingStatus quickParkingBean) {
		quickParkRepo.save(quickParkingBean);
		parkRepo.save(new ParkingStatus(quickParkingBean.getUuid(), quickParkingBean.getStatus()));
	}

	public ParkingStatusResult fetchAllParkingStatus() {
		ParkingStatusResult result = new ParkingStatusResult();
		result.setParkingStatusList(quickParkRepo.findAll(new Sort("uuid")));
		return result;
	}

}
