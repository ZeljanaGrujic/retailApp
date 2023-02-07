package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.EmployeeType;
import fon.bg.ac.rs.retailApp.repositories.EmployeeTypeRepository;
import fon.bg.ac.rs.retailApp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    @Override
    public List<EmployeeType> getEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    @Override
    public EmployeeType saveEmployeeType(EmployeeType employeeType) {
        return employeeTypeRepository.save(employeeType);
    }

    @Override
    public Optional<EmployeeType> findById(int id) {
        return employeeTypeRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {

        employeeTypeRepository.deleteById(id);
    }
}
