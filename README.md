Generate Customer Reports
Given an input file containing multiple lines. Each line has Customer information separated by ",".
The project parse the data and generate reports.

## Clone the repository
1. git clone <repository-link>
2. cd <repository-directory>


## Compile the application
Install The Spring tool suite and Import the code and Update the maven project


## Run the application:
Right click on Project -> Run As Java Application

### Libraries and Tools used for Development
* Java 17
* JUnit 5
* Spring Tool Suite

### Complete Revised Project Structure

Model Classes
Factory Pattern: ReportModelFactory
Strategy Pattern: Reporting strategies 
(ex:- UniqueCustomerIdByContractId, UniqueCustomerIdPerGeoZone, AverageBuildDurationPerGeoZone, CustomerIdsPerGeoZone)
Singleton Pattern: ReportsService
Main Application: Application
Unit Tests: ReportServiceTest



### Sample Input

2343225,2345,us_east,RedTeam,ProjectApple,3445s
1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
1233456,2345,us_west,BlueTeam,ProjectDate,2221s
3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s

### Output
The number of unique customerId for each contractId:
Contract ID: 2346, Unique Customer ID Count: 2
Contract ID: 2345, Unique Customer ID Count: 3

The number of unique customerId for each geozone:
Geozone: eu_west, Unique Customer ID Count: 2
Geozone: us_west, Unique Customer ID Count: 2
Geozone: us_east, Unique Customer ID Count: 1

The average build duration for each geozone:
Geozone: eu_west, Average Build Duration: 4222.0s
Geozone: us_west, Average Build Duration: 2216.0s
Geozone: us_east, Average Build Duration: 3445.0s

The list of unique customerId for each geozone:
Geozone: eu_west, Unique Customer IDs: [3244132, 3244332]
Geozone: us_west, Unique Customer IDs: [1233456, 1223456]
Geozone: us_east, Unique Customer IDs: [2343225]
```
