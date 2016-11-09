package com.bosch.bsj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.bosch.bsj.entity.ParkingStatus;

@RepositoryRestResource(collectionResourceRel = "park", path = "park")
public interface ParkingStatusRepository extends MongoRepository<ParkingStatus, String> {
	@RestResource(path = "uuid", rel = "uuid")
    public ParkingStatus findFirstByUuidOrderByIdDesc(@Param("uuid") String uuid );
    
    public List<ParkingStatus> findByStatus(@Param("status") String status);
    
    

}
