package com.example.Job_Search_Portal.Controller;

import com.example.Job_Search_Portal.Model.Job;
import com.example.Job_Search_Portal.Model.JobType;
import com.example.Job_Search_Portal.Service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class JobController {
    @Autowired
    JobService jobService ;

    //CrudRepository
    @GetMapping("Jobs")
    public Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
    @PostMapping("Job")
    public String addJob(@Valid @RequestBody Job job){
        return jobService.addJob(job);
    }

    @PostMapping("Jobs")
    public String addJobs(@Valid @RequestBody List<Job> jobs){
        return jobService.addJobs(jobs);
    }


    @PutMapping("Job/{id}/{appliedDate}")
    public String updateJobById(@Valid @PathVariable Long id , @PathVariable LocalDate appliedDate){
        return jobService.updateJobById(id , appliedDate);
    }

    @DeleteMapping("Job/{id}")
    public String deleteJobById(@Valid @PathVariable Long id){
        return jobService.deleteJobById(id);
    }

    //Custom finder
    @GetMapping("Job/title/{title}")
    public List<Job> getAllJobByTitle(@PathVariable String title){
        return jobService.getAllJobsByTitle(title);
    }

    @GetMapping("Job/companyName/{companyName}")
    public List<Job> getAllJobByCompanyName(@PathVariable String companyName){
        return jobService.getAllJobByCompanyName(companyName);
    }

    @GetMapping("Job/location/{location}")
    public List<Job> getAllJobByLocation(@PathVariable String location ){
        return jobService.getAllJobByLocation(location );
    }

    @GetMapping("Job/salary/{salary}")
    public List<Job> getAllJobBySalaryGreaterThan(@PathVariable Double salary){
        return jobService.getAllJobBySalaryGreaterThan(salary);
    }


    //CustomQuery
    @GetMapping("Job/salaryOrder")
    public List<Job> getAllJobBySalaryOrder(){
        return jobService.getAllJobBySalaryOrder();
    }

    @PutMapping("Job/id/{id}/location/{location}")
    public String updateJobLocationById(@Valid @PathVariable Long id ,@Valid @PathVariable String location){
        return jobService.updateJobLocationById(id , location );
    }

    @DeleteMapping("Job/appliedDate/{date}")
    public String deleteJobByAppliedDate(@Valid @PathVariable LocalDate date){
        return jobService.deleteJobByAppliedDate(date);
    }
}
