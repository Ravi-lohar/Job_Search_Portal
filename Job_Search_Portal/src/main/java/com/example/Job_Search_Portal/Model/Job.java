package com.example.Job_Search_Portal.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Job {
    @Id
    private Long id;
    @NotBlank(message = "Title Required")
    private String title;
    @NotBlank(message = "Description can not be empty")
    private String description;
    @NotBlank(message = "Location can not be empty")
    private String location;
    @Min(value = 20000)
    private Double salary;
    @Email(message = "Invalid Email")
    private String companyEmail;
    @NotBlank(message = "CompanyName Required")
    private String companyName;
    @NotBlank(message = "Employer Name Required")
    private String employerName;

    @Enumerated(EnumType.STRING)
    private JobType jobType ;

    private LocalDate appliedDate;
}
