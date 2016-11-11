package com.bosch.bsj.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.bsj.entity.QuickParkingStatus;
import com.bosch.bsj.model.ParkingStatusResult;
import com.bosch.bsj.service.ParkingService;

@RestController
public class ParkingController {

	public static final String PATH_GET_PARKING = "park";


	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingController.class);

	
    private final ParkingService parkingService;

    @Autowired
	public ParkingController( ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@RequestMapping(value = PATH_GET_PARKING, method = RequestMethod.GET)
	@ResponseBody
	public ParkingStatusResult fetchAllParkingStatus() {

       return parkingService.fetchAllParkingStatus();
	}
	
	@RequestMapping(value = PATH_GET_PARKING, method = RequestMethod.POST)
	@ResponseBody
	public void saveParkingStatus(@RequestBody QuickParkingStatus quickParkingBean) {

       parkingService.saveParkingStatus(quickParkingBean);
	}

  
}
