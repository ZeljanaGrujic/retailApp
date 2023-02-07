package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.JobTitle;
import fon.bg.ac.rs.retailApp.repositories.JobTitleRepository;
import fon.bg.ac.rs.retailApp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleServiceImpl implements JobTitleService {

    @Autowired
    private JobTitleRepository jobTitleRepository;

    @Override
    public List<JobTitle> getJobTitles() {
        return jobTitleRepository.findAll();
    }

    @Override
    public JobTitle saveJobTitle(JobTitle jobTitle) {
        return jobTitleRepository.save(jobTitle);
    }

    @Override
    public Optional<JobTitle> findById(int id) {
        return jobTitleRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        jobTitleRepository.deleteById(id);
    }
}
