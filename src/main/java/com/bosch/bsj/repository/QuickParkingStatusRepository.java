package com.bosch.bsj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.bosch.bsj.entity.QuickParkingStatus;

@RepositoryRestResource(collectionResourceRel = "parkQuick", path = "parkQuick")
public interface QuickParkingStatusRepository extends MongoRepository<QuickParkingStatus, String> {
	@RestResource(path = "uuid", rel = "uuid")
    public QuickParkingStatus findOneByUuid(@Param("uuid") String uuid );
    
	public List<QuickParkingStatus> findByStatus(@Param("status") String status);
}
