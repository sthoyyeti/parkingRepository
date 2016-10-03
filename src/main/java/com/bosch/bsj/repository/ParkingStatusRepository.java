package com.bosch.bsj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bosch.bsj.entity.ParkingStatus;

@RepositoryRestResource(collectionResourceRel = "park", path = "park")
public interface ParkingStatusRepository extends MongoRepository<ParkingStatus, String> {

    public ParkingStatus findByUuid(@Param("uuid") String uuid);
    public List<ParkingStatus> findByStatus(@Param("status") String status);

}
