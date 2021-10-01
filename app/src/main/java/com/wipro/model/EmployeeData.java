package com.wipro.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeData {
  @SerializedName("Employees")
  private List<Employee> employeeList;

  public List<Employee> getEmployeeList() {
    return employeeList;
  }

}