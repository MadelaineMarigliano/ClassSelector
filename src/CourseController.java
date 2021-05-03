import java.util.ArrayList;
import java.util.Scanner;

public class CourseController extends AbstractController {
    private final CourseView view;

    public CourseController(UseCaseBundle bundle) {
        super(bundle);
        this.view = new CourseView();
    }

    public AbstractController run() {
        Scanner scanner = new Scanner(System.in);
        view.displayMenu();
        int option;
        option = selectOption(scanner);
        switch (option) {
            case 1: //add course
                try {
                    add(scanner);
                } catch (Exception e) {
                    view.courseNotCreated();
                }
            case 2: //delete course
                delete(scanner);
            case 3: // modify:
                modify(scanner);
            case 4: // back
        }
        return null;
    }

    private int selectOption(Scanner scanner) {
        String input;
        do {
            view.optionPrompt();
            input = scanner.nextLine();
            switch (input.trim()) {
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
        } while (true);
    }

    //NOT DONE
    private void modify(Scanner scanner) {
        // TODO: if course code doesnt ecist, or section
        view.modifyCourseChoice();
        String choice;
        choice = scanner.nextLine().trim();
        if (choice.equals("Add")) {

        }

        if (choice.equals("Delete")) {
            String courseCode;
            String sectionCode;
            view.enterCourseCode();
            view.enterCourseCode();
            courseCode = scanner.nextLine();
            view.enterSectionCode();
            sectionCode = scanner.nextLine();
            try {
                getBundle().getCourseManager().removeOption(courseCode, sectionCode);
            } catch (Exception e) {
                view.printException(e);
            }

        } else {
            view.InvalidModifyEntry();
        }
    }

    private void delete(Scanner scanner) {
        // TODO: add throw catch if coursecode is not in courses
        String courseCode;
        view.courseCodePrompt();
        courseCode = scanner.nextLine().trim();
        Course c = getBundle().getCourseManager().getCourseByCode(courseCode);
        getBundle().getCourseManager().removeCourse(c);
    }

    private void add(Scanner scanner) throws Exception {
        //TODO: finish by jasmeen and change to using usecase
        String courseCode;
        String description;
        String name;
        boolean tutorial;
        view.courseCodePrompt();
        courseCode = scanner.nextLine().trim();
        view.descriptionPrompt();
        description = scanner.nextLine().trim();
        view.namePrompt();
        name = scanner.nextLine().trim();
        view.tutorialPrompt();
        String s = scanner.nextLine().trim();
        if (s.equals("yes")) {
            tutorial = true;
        } else {
            tutorial = false;
        }
        ArrayList<Option> options = getOptions(courseCode, scanner);
        getBundle().getCourseManager().createCourse(courseCode, tutorial, description, name, options);
    }


    private ArrayList<Option> getOptions(String code, Scanner scanner) throws Exception {
        ArrayList<Option> options = new ArrayList<>();
        String answer = new String("Yes");
        String answer2 = new String("Yes");
        String prof;
        String section;
        do {
            view.ProfPrompt();
            prof = scanner.nextLine().trim();
            view.sectionPrompt();
            section = scanner.nextLine().trim();
            ArrayList<TimeSlot> timeslots = new ArrayList<>();
            do {
                int start;
                int end;
                int duration;
                String day;
                String location;
                view.dayPrompt();
                day = scanner.nextLine().trim();
                view.locationPrompt();
                location = scanner.nextLine().trim();
                view.startTime();
                start = scanner.nextInt();
                view.endTime();
                end = scanner.nextInt();
                view.duration();
                duration = scanner.nextInt();
                view.addTimeSlot();
                answer2 = scanner.nextLine();
                timeslots.add(getBundle().getOptionManager().createTimeSlot(start, end, day, location, duration));
            } while (answer2.equals("Yes"));
            options.add(getBundle().getOptionManager().createOption(code, section, prof, timeslots));
            view.addOption();
            answer = scanner.nextLine();
        } while (answer.equals("Yes"));
        return options;
    }
}

