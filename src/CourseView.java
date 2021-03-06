import javax.crypto.spec.PSource;
import java.util.ArrayList;

public class CourseView {

    public void displayMenu() {
        System.out.println("1. Add a course");
        System.out.println("2. Remove a course");
        System.out.println("3. Modify a course");
        System.out.println("4: Return");
    }

    public void optionError(){
        System.out.println("Please enter a number representing one of the options.");
    }

    public void optionPrompt(){
        System.out.println("Select an option:");
    }

    public void courseCodePrompt() {
        System.out.println("Enter the course code: ");
    }

    public void descriptionPrompt() {
        System.out.println("Enter the description: ");
    }

    public void namePrompt() {
        System.out.println("Enter the name of the course: ");
    }

    public void tutorialPrompt() {
        System.out.println("Is this a tutorial? please enter 'yes' if it is: ");
    }

    public void dayPrompt() {
        System.out.println("Enter the day that this lecture/tutorial occurs");
    }

    public void locationPrompt() {
        System.out.println("Enter the location of this lecture/tutorial");
    }

    public void addTimeSlot() {
        System.out.println("Please enter 'Yes' if you would like to add another time slot, if not press enter");
    }

    public void addOption() {
        System.out.println("Please enter 'Yes' if you would like to add another option, if not press enter");
    }

    public void ProfPrompt() {
        System.out.println("Enter the name of the professor teaching this section");
    }

    public void sectionPrompt() {
        System.out.println("Enter the section code");
    }

    public void startTime() {
        System.out.println("Enter the start time represented by an integer using a 24hr clock (ex: 6 pm = 18");
    }

    public void endTime() {
        System.out.println("Enter the end time representing by an integer using a 24hr clock (ex: 6pm = 18)");
    }

    public void duration() {
        System.out.println("Enter the integer representing the duration of this lecture in minutes");
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public void courseAdded() {
        System.out.println("This course has been successfully added");
    }

    public void courseNotCreated() {
        System.out.println("You entered an invalid start time, end time or duration so this course was not created");
    }

    public void modifyCourseChoice() {
        System.out.println("Please enter 'Add' if you would like to add a lecture section for a course or 'Delete' if you would like to delete a lecture section for a course");
    }


    public void timeSlot1() {
        System.out.println("Please enter information for this Time Slot ");
    }

    public void codeExists() {
        System.out.println("A course with this course code already exists.");
    }

    public void deleted() {
        System.out.println("This course has been deleted");
    }

    public void doesNotExist(){
        System.out.println("This course does not exist");
    }

    public void onlyOption() {
        System.out.println("There is one only remaining option for this course so it cannot be deleted.");
    }
}
