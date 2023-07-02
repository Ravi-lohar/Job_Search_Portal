<div align = "center">
  <h1> Job Search Portal</h1>
 </div>



## Framework and Language
* Java 
* SpringBoot

## Dependencies
  * SpringWeb
  * Lombok
  * Validation
  * JPA
  * h2 database
    
## Database Used 
  * h2 Database
## Data flow
  **The project has four main packages which are following** 
  
* Controller - Controller package has all the api and Crud operations.
* Services - Service class has all the business logic and it will return the result of that method which is called by controller class . 
* Repository - Respository has all the datasource in it i uses h2 database
* Model - Model class has one Job class which data member like id , title , description of job , location , salary , companyEmail , companyName , employer name , JobType as HR , IT , Sales and Marketting and applied date .
  
> The flow of data is from controller has all the api and logics of that api has in service class and
service class is using the repository class which has all the data it keeps data source.The api called by user call the controller method
return the logic which is written in service class so service class object is called and service class use data source of repo class.

## Data Structure
    ArrayList
## Project Summary 
  This is a Job Search Portal we can do many more operations in this project like
  * Adding a list of Jobs
  * Adding a Job
  * Updating Jobs applied date and location
  * Searching job by location , salary , title and many more
  * Deleting job by id and appliedDate
  * Updating Job location
 
