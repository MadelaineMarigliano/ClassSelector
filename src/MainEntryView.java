public class MainEntryView {
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Class selector system!\n");
    }

    public void displayMenu() {
        System.out.println("Here are your options: ");
        System.out.println("\t 1. Create/Delete/Modify a course");
        System.out.println("\t 2. Create a schedule");
        System.out.println("Enter 1 or 2: ");
    }

    public void displayInputError() {
        System.out.println("Please enter one of the options above.");
    }
}
