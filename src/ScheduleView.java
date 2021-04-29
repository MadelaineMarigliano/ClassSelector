import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScheduleView {
    public void displayMenu() {
        System.out.println("1. Create a new schedule");
        System.out.println("2. View the existing schedule");
        System.out.println("3: Return");
    }

    public void optionPrompt(){
        System.out.println("Select an option:");
    }

    public void optionError(){
        System.out.println("Please enter a number representing one of the options.");
    }

    public void preferencesPrompt() {System.out.println("Please enter the number representing one of the preferences, " +
            "or press 0 to stop applying preferences");
        System.out.println("1. No classes before a certain time");
        System.out.println("2. No classes at a certain time");
        System.out.println("3. No classes after a certain time");
        System.out.println("4. No classes on a specific day");
    }

    public void timePrompt(){System.out.println("Please enter the desired time in 24 hour format (e.g. 13)");}
    public void dayPrompt(){System.out.println("Please enter the desired day in lowercase (e.g. monday)");}

    public void printSchedule(File file) {
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
