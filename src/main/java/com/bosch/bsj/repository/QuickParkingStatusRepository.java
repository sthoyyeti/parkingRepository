package com.bosch.bsj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.bosch.bsj.entity.ParkingStatus;
import com.bosch.bsj.entity.QuickParkingStatus;

@RepositoryRestResource(collectionResourceRel = "parkQuick", path = "parkQuick")
public interface QuickParkingStatusRepository extends MongoRepository<QuickParkingStatus, String> {
	@RestResource(path = "byuuid", rel = "uuid")
    public ParkingStatus findOneByUuid(@Param("uuid") String uuid );
    
	public List<ParkingStatus> findByStatus(@Param("status") String status);
    
    

}
