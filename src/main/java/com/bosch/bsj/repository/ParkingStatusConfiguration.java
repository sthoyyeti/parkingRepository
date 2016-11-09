package com.bosch.bsj.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.bosch.bsj.entity.ParkingStatus;

@Configuration
public class ParkingStatusConfiguration extends RepositoryRestMvcConfiguration {
 
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
       config.exposeIdsFor(ParkingStatus.class);
    }
}