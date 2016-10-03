package com.bosch.bsj;
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.bosch.bsj.entity.ParkingStatus;
import com.bosch.bsj.repository.ParkingStatusRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingStatusRepositoryTests {

    @Autowired
    ParkingStatusRepository repository;

    ParkingStatus p1, p2, p3;

    @Before
    public void setUp() {

        repository.deleteAll();

        p1 = repository.save(new ParkingStatus("1", "on"));
        p2 = repository.save(new ParkingStatus("2", "on"));
        p3 = repository.save(new ParkingStatus("3", "off"));
    }

    @Test
    public void setsIdOnSave() {

        ParkingStatus p4 = repository.save(new ParkingStatus("4", "on"));

        assertThat(p4.id).isNotNull();
    }

    @Test
    public void findsByLastName() {

        List<ParkingStatus> result = repository.findByStatus("on");

        assertThat(result).hasSize(2).extracting("uuid").contains("1", "2");
    }

    @Test
    public void findsByExample() {

        ParkingStatus probe = new ParkingStatus(null, "on");

        List<ParkingStatus> result = repository.findAll(Example.of(probe));

        assertThat(result).hasSize(2).extracting("uuid").contains("1", "2");
    }
}