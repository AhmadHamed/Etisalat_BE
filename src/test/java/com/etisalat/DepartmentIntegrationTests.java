package com.etisalat;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class DepartmentIntegrationTests extends EtisalatProgrammingExerciseTestApplication {

  @Test
  @DisplayName("get department by id")
  @Order(1)
  public void getDepartmentTest() throws Exception {
    this.mockMvc
        .perform(get("/departments/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("1"))
        .andExpect(jsonPath("$.department_name").value("HR"))
        .andExpect(jsonPath("$.manager_id").value("1"));
  }

  @Test
  @DisplayName("get paginated department")
  @Order(2)
  public void getPaginatedDepartmentTest() throws Exception {
    this.mockMvc
        .perform(get("/departments").param("page", "0").param("size", "2"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  @DisplayName("create department")
  @Order(3)
  public void createDepartmentTest() throws Exception {
    this.mockMvc
        .perform(
            post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"manager_id\": \"1\" , \"department_name\": \"Logistics\" }")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  @Test
  @DisplayName("update department")
  @Order(4)
  public void updateDepartmentTest() throws Exception {
    this.mockMvc
        .perform(
            patch("/departments/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"manager_id\": \"2\" , \"department_name\": \"Logistics\" }")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @DisplayName("delete department")
  @Order(5)
  public void deleteDepartmentTest() throws Exception {
    this.mockMvc
        .perform(delete("/departments/3").contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isNoContent());
  }
}
