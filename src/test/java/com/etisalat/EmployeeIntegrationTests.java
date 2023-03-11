package com.etisalat;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class EmployeeIntegrationTests extends EtisalatProgrammingExerciseTestApplication {

  @Test
  @DisplayName("get employee by id")
  @Order(1)
  public void getEmployeeTest() throws Exception {
    this.mockMvc
        .perform(get("/employees/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("1"))
        .andExpect(jsonPath("$.first_name").value("Juan"))
        .andExpect(jsonPath("$.last_name").value("Lebron"));
  }

  @Test
  @DisplayName("get paginated employees")
  @Order(2)
  public void getPaginatedEmployeesTest() throws Exception {
    this.mockMvc
        .perform(get("/employees").param("page", "0").param("size", "2"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  @DisplayName("create employee")
  @Order(3)
  public void createEmployeeTest() throws Exception {
    this.mockMvc
        .perform(
            post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{ \"first_name\": \"Arturo\", \"last_name\": \"Coello\", \"email\": \"Coello@Wpt.com\","
                        + "\"phone_number\": \"010000000\", \"hire_date\": \"2023-01-01\" , \"salary\": \"1000\" ,"
                        + "\"manager_id\": \"1\" , \"department_id\": \"1\" }")
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  @DisplayName("update employee")
  @Order(4)
  public void updateEmployeeTest() throws Exception {
    this.mockMvc
        .perform(
            patch("/employees/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{ \"email\": \"Coello@Wpt.com\","
                        + "\"phone_number\": \"010000000\", \"salary\": \"1000\" ,"
                        + "\"manager_id\": \"2\" , \"department_id\": \"2\" }")
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  @DisplayName("delete employee")
  @Order(5)
  public void deleteEmployeeTest() throws Exception {
    this.mockMvc
        .perform(delete("/employees/3").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }
}
