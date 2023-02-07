package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.JobTitle;

import java.util.List;
import java.util.Optional;

public interface JobTitleService {
    List<JobTitle> getJobTitles();

    JobTitle saveJobTitle(JobTitle jobTitle);

    Optional<JobTitle> findById(int id);

    void deleteById(int id);
}
