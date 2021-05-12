import java.util.Scanner;

public class ScheduleController extends AbstractController {
    private ScheduleView view;

    public ScheduleController(UseCaseBundle bundle){
        super(bundle);
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
            case 2: //View options
                viewOptions(scanner);
            case 3: // back
                return new MainEntryController(getBundle()).run();
        }
        return null;
    }

    private void viewOptions(Scanner scanner) {
        view.finalPrompt();
        Schedule schedule = getBundle().getScheduleManager().chosenSchedule;
        for (Course c : schedule.getChosenOptions().keySet()){
            view.printOption(c.getCourseCode(), schedule.getChosenOptions().get(c).getSectionCode());
        }
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
        try {
        view.preferencesPrompt();
        int input = scanner.nextInt();
        while (input != 0){
            if (input == 1){
                view.timePrompt();
                int time = scanner.nextInt();
                getBundle().getCourseManager().startPreference(time);
                view.preferenceSuccess();
            }
            else if (input == 2) {
                view.timePrompt();
                int time = scanner.nextInt();
                getBundle().getCourseManager().breakPreference(time);
                view.preferenceSuccess();
            }
            else if (input == 3) {
                view.timePrompt();
                int time = scanner.nextInt();
                getBundle().getCourseManager().endPreference(time);
                view.preferenceSuccess();
            }
            else if (input == 4) {
                view.dayPrompt();
                String day = scanner.nextLine().trim();
                getBundle().getCourseManager().dayPreference(day);
                view.preferenceSuccess();
            }else {view.optionError();}
            input = scanner.nextInt();
        }
            Schedule s = getBundle().getScheduleManager().bestSchedule(getBundle().getCourseManager().getCourses());
            for (Course c : getBundle().getCourseManager().getCourses()){
                c.setChosenOption(s.getChosenOptions().get(c));
            }
        } catch (Exception e) {view.printException(e);}
    }

    /* Not necessary until after program is finished
    private void viewSchedule(Scanner scanner){
        File file = scheduleManager.printToHTML();
        view.printSchedule(file);
    }
     */
}
