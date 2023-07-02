package com.example.Job_Search_Portal.Service;

import com.example.Job_Search_Portal.Model.Job;
import com.example.Job_Search_Portal.Model.JobType;
import com.example.Job_Search_Portal.Repository.IJobRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    IJobRepo iJobRepo ;

    //CrudRepository
    public Iterable<Job> getAllJobs() {
        return  iJobRepo.findAll();
    }

    public String addJob(Job job) {
        iJobRepo.save(job);
        return "Job added";
    }

    public String addJobs(List<Job> jobs) {
        iJobRepo.saveAll(jobs);
        return "Jobs added successfully";
    }

    public String updateJobById(Long id, LocalDate appliedDate) {
        Optional<Job> currentJob = iJobRepo.findById(id);
        Job job = null ;
        if(currentJob.isPresent()){
            job = currentJob.get();
        }
        else {
            return "Id not found";
        }
        job.setAppliedDate(appliedDate);
        iJobRepo.save(job);
        return "Applied date updated Successfully";
    }

    public String deleteJobById(Long id) {
        iJobRepo.deleteById(id);
        return "Job Deleted Successfully of id " + ":" + id;
    }

    //Custom finder
    public List<Job> getAllJobsByTitle(String title) {
        return iJobRepo.findByTitle(title);
    }

    public List<Job> getAllJobByCompanyName(String companyName) {
        return iJobRepo.findByCompanyName(companyName);
    }

    public List<Job> getAllJobByLocation(String location) {
        return iJobRepo.findByLocation(location );
    }

    public List<Job> getAllJobBySalaryGreaterThan(Double salary) {
        return iJobRepo.findBySalaryGreaterThan(salary);
    }


    //CustomQuery
    public List<Job> getAllJobBySalaryOrder() {
        return iJobRepo.getAllJobsBySalary();
    }

    @Transactional
    public String updateJobLocationById(Long id, String location) {
        iJobRepo.updateLocation(id, location);
        return "Job Update Successfully As per location" ;
    }
    @Transactional
    public String deleteJobByAppliedDate(LocalDate date) {
        iJobRepo.deleteJobAsPerDate(date);
        return "Job Deleted Successfully As Per Date" ;
    }
}
