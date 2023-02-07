package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.EmployeeType;

import java.util.List;
import java.util.Optional;

public interface EmployeeTypeService {
    List<EmployeeType> getEmployeeTypes();

    EmployeeType saveEmployeeType(EmployeeType employeeType);

    Optional<EmployeeType> findById(int id);

    void deleteById(int id);
}
