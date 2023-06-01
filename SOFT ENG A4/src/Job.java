
import java.util.Scanner; // Import the Scanner class to read text files
public class Job {


//process to add a job to the text file

    public static void addJob(ProcessJobs createJob) {

        //asks for the job information and sets it into the processjobs class
        //if the input is invalid, it will keep asking until it is valid

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Job Number: ");
        if(createJob.setJobNumber(input.nextLine()) == false ){
            while (createJob.setJobNumber(input.nextLine()) == false){
            }
        }

        System.out.println("Enter the Job Title: ");
        if(createJob.setJobTitle(input.nextLine()) == false){
            while (createJob.setJobTitle(input.nextLine()) == false){

            }
        }

        System.out.println("Enter the Job Description: ");
        if(createJob.setJobDescription(input.nextLine()) == false){
            while (createJob.setJobDescription(input.nextLine()) == false){

            }
        }

        System.out.println("Enter the Job Poster Name: ");
        if(createJob.setJobPosterName(input.nextLine()) == false){
            while (createJob.setJobPosterName(input.nextLine()) == false){

            }
        }

        System.out.println("Enter the Job Date: YYYY-MM-DD ");
        if(createJob.setJobPostedDate(input.nextLine()) == false){
            while (createJob.setJobPostedDate(input.nextLine()) == false){

            }
        }

        System.out.println("Enter the Job Address: ");
        if(createJob.setJobPosterAddress(input.nextLine()) == false){
            while (createJob.setJobPosterAddress(input.nextLine()) == false){

            }
        }

        System.out.println("Enter the Job Experience Level: Junior (1)  Medium (2) Senior (3) Executive (4)");
        if(createJob.setJobExperienceLevel(input.nextLine()) == false){
            while (createJob.setJobExperienceLevel(input.nextLine()) == false){

            }
        }
        System.out.println("Enter the Job Pay: ");
        if(createJob.setJobSalary(input.nextLine()) == false){
            while (createJob.setJobSalary(input.nextLine()) == false){
                            }
        }
        System.out.println("Enter the Job Type: Full Time (1)  Part Time (2) Internship (3) Volunteer (4)");
        if(createJob.setJobType(input.nextLine()) == false){
            while (createJob.setJobType(input.nextLine()) == false){
            }
        }

        System.out.println("Enter the Job Skills: 1,2,3 ");
        if(createJob.setJobRequiredSkills(input.nextLine()) == false){
            while (createJob.setJobRequiredSkills(input.nextLine()) == false){

            }
        }

        //once complete, add the job to the text file

        createJob.addJob();

    }

    //process to modify job
    public static void modifyJob(ProcessJobs changeJob) {


    }
    //main method, will keep asking the user to create a job / modify a job until they quit
    public static void main(String[] args) {

        boolean newJob = true;


        while (newJob){
            System.out.println("Create Job (1), Modify Job (2), Quit (~): ");
            ProcessJobs createJob = new ProcessJobs();
            ProcessJobs changeJob = new ProcessJobs();
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            if (choice.contains("1")){

                addJob(createJob);


            } else if (choice.contains("2") ){

                modifyJob(changeJob);

            } else if (choice.contains("~")) {
                newJob = false;
            }
            else {
                System.out.println("Invalid input");
            }
        }



    }



}

