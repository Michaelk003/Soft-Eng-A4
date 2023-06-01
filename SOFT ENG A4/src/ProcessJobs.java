import java.util.Arrays;
import java.util.Scanner;

import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
public class ProcessJobs {

    //variables for the job class
    private String jobNumber;
    private String jobTitle;
    private String jobPosterName;
    private String jobPosterAddress;
    private String jobPostedDate;
    private String jobExperienceLevel; // Four job experience level: Junior, Medium, Senior, Executive
    private String jobType; // Four job types: Full-time, Part-time, , Volunteer
    String[] jobRequiredSkills   ; // a list of skills; each word (e.g., C#) or a maximum of two words (e.g., Software Architecture)
    private double jobSalary;
    private String jobDescription;


    // Constructor
    public ProcessJobs(){
        jobNumber = "";
        jobTitle = "";
        jobPosterName = "";
        jobPosterAddress = "";
        jobPostedDate = "";
        jobExperienceLevel = "";
        jobType = "";
        jobRequiredSkills = new String[0];
        jobSalary = 0.0;
        jobDescription = "";

    }

    public ProcessJobs(String number, String title, String postername, String posteraddress, String date,
               String experiencelevel, String type, String[] skills, double salary, String description) {

        this.jobNumber = number;
        this.jobTitle = title;
        this.jobPosterName = postername;
        this.jobPosterAddress = posteraddress;
        this.jobPostedDate = date;
        this.jobExperienceLevel = experiencelevel;
        this.jobType = type;
        this.jobRequiredSkills = skills;
        this.jobSalary = salary;
        this.jobDescription = description;
    }

    // Getters
    //sets the variables for the job class
    //makes sure that these variables are valid to the format if applicable
    public  boolean setJobNumber(String JobNumber){

        if (JobNumber.matches("[1-5][1-5][1-5][1-5][1-5][A-Z][A-Z][A-Z]\\W")) {
            this.jobNumber = JobNumber;
            return true;

        } else {
            System.out.println("Invalid job number");
            return false;
        }

    }

    public boolean setJobTitle(String JobTitle){
        this.jobTitle= JobTitle;
        return true;
    }

    public boolean setJobPosterName(String JobPosterName){
        this.jobPosterName= JobPosterName;
        return true;
    }

    public boolean setJobDescription(String JobDescription) {

        this.jobDescription = JobDescription;
        return true;


    }

        public boolean setJobPostedDate(String JobPostedDate){
        if (JobPostedDate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            this.jobPostedDate = JobPostedDate;
            return true;

        } else {
            System.out.println("Invalid date format");
            return false;
        }
    }

    public boolean setJobPosterAddress(String JobPosterAddress){

            this.jobPosterAddress= JobPosterAddress;
            return true;


    }

    public boolean setJobExperienceLevel(String JobExperienceLevel){
        if (JobExperienceLevel.contains("1")) {
            this.jobExperienceLevel = "Junior";
            return true;

        } else if (JobExperienceLevel.contains("2")) {
            this.jobExperienceLevel = "Medium";
            return true;
        } else if (JobExperienceLevel.contains("3")) {
            this.jobExperienceLevel = "Senior";
            return true;
        } else if (JobExperienceLevel.contains("4")) {
            this.jobExperienceLevel = "Executive";
            return true;
        } else {
            System.out.println("Invalid Address");
            return false;
        }

        }

    public boolean setJobSalary(String JobSalary){
       double salary = Double.parseDouble(JobSalary);
        if (jobExperienceLevel == "Executive" && salary >= 100000) {
            this.jobSalary = salary;
            return true;
        } else if (jobExperienceLevel == "Senior" && salary >= 100000) {
            this.jobSalary = salary;
            return true;
        } else if (jobExperienceLevel == "Junior" && salary >= 40000 && salary <= 70000) {
            this.jobSalary = salary;
            return true;
        } else if (jobExperienceLevel == "Medium" && salary >= 40000) {
            this.jobSalary = salary;
            return true;
        } else {
            System.out.println("Invalid salary");
            return false;
        }

    }

    public boolean setJobType(String JobType){
        if (JobType.contains("1")) {
            this.jobType = "Full Time";
            return true;

        } else if (JobType.contains("2")) {
            if(jobExperienceLevel == "Executive" || jobExperienceLevel == "Senior"){
                System.out.println("Invalid job type");
                return false;
            }
            else {
            this.jobType = "Part Time";
            return true;
            }
        } else if (JobType.contains("3")) {
            this.jobType = "Internship";
            return true;
        } else if (JobType.contains("4")) {
            this.jobType = "Volunteer";
            return true;
        } else {
            System.out.println("Invalid Job Type");
            return false;
        }

    }

    public boolean setJobRequiredSkills(String JobRequiredSkills) {
        Scanner input = new Scanner(System.in);
        int NumSkills; // counter for the number of skills

        if (JobRequiredSkills.contains("1")) {
            NumSkills = 1;
        } else if (JobRequiredSkills.contains("2")) {
            NumSkills = 2;
        } else if (JobRequiredSkills.contains("3")) {
            NumSkills = 3;
        } else {
            System.out.println("Invalid input");
            return false;
        }

        jobRequiredSkills = new String[NumSkills];

        for (int i = 0; i < NumSkills; i++) {
            System.out.println("Enter skill " + (i + 1) + ": ");

            String skill = input.nextLine();
            this.jobRequiredSkills[i] = skill;
        }

        return true;
        }

    public boolean addJob() {
// Add the information of a new job to a TXT file

        //write variables to the file
        try {
            FileWriter myWriter = new FileWriter("Jobs.txt", true); //appends so that it doesn't overwrite
            myWriter.write(this.jobNumber +"|");
            myWriter.write(this.jobTitle +"|");
            myWriter.write(this.jobDescription +"|");
            myWriter.write(this.jobPosterName+"|");
            myWriter.write(this.jobPostedDate+"|");
            myWriter.write(this.jobPosterAddress+"|");
            myWriter.write(this.jobExperienceLevel+"|");
            myWriter.write(this.jobSalary+"|");
            myWriter.write(this.jobType+"|");

            for(int i = 0; i < this.jobRequiredSkills.length; i++) {
                myWriter.write(this.jobRequiredSkills[i]+"|");
            }
            myWriter.write("\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }
        return true;
    }

    public static boolean updateJob() {
// Update the information of a given job in a TXT file

// If the job's new information meets the defined conditions,

// the job information should be updated in the TXT file and the function should return true.

// If the job's new information does not meet the following conditions,

// the job information should not be updated in the TXT file and the function should return false.
        return true;
    }

}
