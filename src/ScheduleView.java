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
}
