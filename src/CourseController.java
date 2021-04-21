import java.util.Scanner;

public class CourseController {
    private CourseView view;

    private void Run() {
        Scanner scanner = new Scanner(System.in);
        view.displayMenu();
        int option;
        option = selectOption(scanner);
    }

    private int selectOption(Scanner scanner) {
        String input;
        do {
            view.optionPrompt();
            input = scanner.nextLine();
            switch(input.trim()) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                case "4":
                    return 4;
            }
            view.optionError();
            } while(true);
        }
    }
}
