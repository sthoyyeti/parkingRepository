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

package com.bosch.bsj;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.bosch.bsj.repository.ParkingStatusRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingStatusRESTTests {

	private static final String PARK_QUICK_URL = "/parkQuick";
	private static final String PARKQUICK_FIND_BY_UUID = PARK_QUICK_URL + "/search/uuid?uuid=";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ParkingStatusRepository repository;

	@Before
	public void deleteAllBeforeTests() throws Exception {

		repository.deleteAll();

	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$._links.parkQuick").exists());
	}

	@Test
	public void shouldCreateEntity() throws Exception {

		mockMvc.perform(post(PARK_QUICK_URL).content("{\"uuid\": \"100\", \"status\":\"on\"}"))
				.andExpect(status().isCreated()).andExpect(header().string("Location", containsString("parkQuick/")));
	}

	@Test
	public void shouldRetrieveEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post(PARK_QUICK_URL).content("{\"uuid\": \"200\", \"status\":\"off\"}"))
				.andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(jsonPath("$.uuid").value("200"))
				.andExpect(jsonPath("$.status").value("off"));
	}

	@Test
	public void shouldQueryEntity() throws Exception {

		mockMvc.perform(post(PARK_QUICK_URL).content("{ \"uuid\": \"300\", \"status\":\"on\"}"))
				.andExpect(status().isCreated());

		mockMvc.perform(get(PARKQUICK_FIND_BY_UUID + "300")).andExpect(status().isOk())
				.andExpect(jsonPath("$.uuid").value("300"));
	}

	@Test
	public void shouldUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post(PARK_QUICK_URL).content("{\"uuid\": \"404\", \"status\":\"on\"}"))
				.andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		//uuid which _id in mongo can not be updated.
		mockMvc.perform(put(location).content("{\"uuid\": \"404\", \"status\":\"off\"}"))
				.andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(jsonPath("$.uuid").value("404"))
				.andExpect(jsonPath("$.status").value("off"));
	}

	@Test
	public void shouldPartiallyUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post(PARK_QUICK_URL).content("{\"uuid\": \"600\", \"status\":\"on\"}"))
				.andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(patch(location).content("{\"status\": \"off\"}")).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(jsonPath("$.uuid").value("600"))
				.andExpect(jsonPath("$.status").value("off"));
	}

	@Test
	public void shouldDeleteEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post(PARK_QUICK_URL).content("{ \"uuid\": \"500\", \"status\":\"on\"}"))
				.andExpect(status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
}