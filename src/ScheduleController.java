import java.util.Scanner;

public class ScheduleController {
    private ScheduleView view;

    private AbstractController run() {
        Scanner scanner = new Scanner(System.in);
        view.displayMenu();
        int option;
        option = selectOption(scanner);
        switch(option) {
            case 1: //Create schedule
                createSchedule(scanner);
            case 2: //View schedule
                viewSchedule(scanner);
            case 3: // back
        }
        return null;
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
            }
            view.optionError();
        } while(true);
    }


    private void createSchedule(Scanner scanner){
        view.preferencesPrompt();
        String input = scanner.nextLine().trim();
        while (input != "0"){
            if (input == "1"){
                view.timePrompt();
                int time = scanner.nextInt();


            }
            if (input == "2") {
                view.timePrompt();
                int time = scanner.nextInt();

            }
            if (input == "3") {
                view.timePrompt();
                int time = scanner.nextInt();

            }
            if (input == "4") {
                view.dayPrompt();
                String day = scanner.nextLine().trim();

            }
            input = scanner.nextLine().trim();
        }

    }

    //TODO
    private void viewSchedule(Scanner scanner){}
}
