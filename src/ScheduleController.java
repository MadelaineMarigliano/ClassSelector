import java.io.File;
import java.util.Scanner;

public class ScheduleController extends AbstractController {
    private ScheduleView view;

    public ScheduleController(){
        super();
        this.view = new ScheduleView();
    }

    public AbstractController run() {
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
        int input = scanner.nextInt();
        while (input != 0){
            if (input == 1){
                view.timePrompt();
                int time = scanner.nextInt();
                courseManager.startPreference(time);
            }
            else if (input == 2) {
                view.timePrompt();
                int time = scanner.nextInt();
                courseManager.breakPreference(time);
            }
            else if (input == 3) {
                view.timePrompt();
                int time = scanner.nextInt();
                courseManager.endPreference(time);
            }
            else if (input == 4) {
                view.dayPrompt();
                String day = scanner.nextLine().trim();
                courseManager.dayPreference(day);
            }else {view.optionError();}
            input = scanner.nextInt();
        }

        Schedule s = scheduleManager.bestSchedule(courseManager.getCourses());
        for (Course c : courseManager.getCourses()){
            c.setChosenOption(s.getChosenOptions().get(c));
        }
    }

    private void viewSchedule(Scanner scanner){
        File file = scheduleManager.printToHTML();
        view.printSchedule(file);
    }
}
