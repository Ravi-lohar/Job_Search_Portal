package com.example.Job_Search_Portal.Repository;

import com.example.Job_Search_Portal.Model.Job;
import com.example.Job_Search_Portal.Model.JobType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job, Long> {
    //CustomFinder
    List<Job> findByTitle (String title) ;
   List<Job> findByCompanyName (String companyName);
   List<Job> findByLocation (String location);
   List<Job> findBySalaryGreaterThan (Double salary);

   //Queries
    @Query(value = "select * from job order by salary ",nativeQuery = true)
    List<Job> getAllJobsBySalary();

    @Modifying
    @Query(value = "update job set location = :location where id= :id",nativeQuery = true)
    void updateLocation(Long id, String location);

    @Modifying
    @Query(value = "delete from job where applied_date = :date",nativeQuery = true)
    void deleteJobAsPerDate(LocalDate date);

}
