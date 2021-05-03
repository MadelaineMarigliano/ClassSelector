import java.util.Scanner;

public class MainEntryController extends AbstractController{
    private MainEntryView view;

    public MainEntryController(UseCaseBundle bundle) {
        super(bundle);
        view = new MainEntryView();
    }

    @Override
    public AbstractController run() {
        Scanner scanner = new Scanner(System.in);
        view.displayWelcomeMessage();
        view.displayMenu();
        String option = getOption(scanner);
        if (option.equals("1")){
            new CourseController(getBundle()).run();
        }
        else if (option.equals("2")){
            new ScheduleController(getBundle()).run();
        }
        return null;
    }

    private String getOption(Scanner scanner){
        String input;
        input = scanner.nextLine();
        boolean isValid = validInput(input);
        while(!isValid){
            view.displayInputError();
            input = scanner.nextLine();
            isValid = validInput(input);
        }
        return input;
    }
    private boolean validInput(String input){
        return input.equals("1") || input.equals("2");
    }
}
