import java.util.ArrayList;
import java.util.HashMap;
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
                    view.courseAdded();
                } catch (Exception e) {
                    view.printException(e);
                    view.courseNotCreated();
                }
                return new CourseController(getBundle()).run();
            case 2: //delete course
                delete(scanner);
                return new CourseController(getBundle()).run();
            case 3: // modify:
                modify(scanner);
                return new CourseController(getBundle()).run();
            case 4: // back
                return new MainEntryController(getBundle()).run();
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


    private void modify(Scanner scanner) {
        //TODO: always says course does not exist, do not let it delete section if it the only one remaining
        view.modifyCourseChoice();
        String choice;
        choice = scanner.nextLine().trim();
        String courseCode;
        if (choice.equals("Add")) {
            try {
                view.courseCodePrompt();
                courseCode = scanner.nextLine().trim();
                Course c = getBundle().getCourseManager().getCourseByCode(courseCode);
                getBundle().getCourseManager().addOption(createOption(courseCode, scanner), courseCode);
            } catch (Exception e) {
                view.printException(e);
            }
        }

        if (choice.equals("Delete")) {
            try {
                view.courseCodePrompt();
                courseCode = scanner.nextLine().trim();
                if(getBundle().getCourseManager().courseExists(courseCode)){
                    String sectionCode;
                    view.sectionPrompt();
                    sectionCode = scanner.nextLine();
                    if(getBundle().getCourseManager().onlyOption(courseCode)){
                        view.onlyOption();
                    } else {
                        getBundle().getCourseManager().removeOption(courseCode, sectionCode);
                    }
                } else {
                    view.doesNotExist();
                }
            } catch (Exception e) {
                view.printException(e);
            }

        }
    }

    private void delete(Scanner scanner) {
        // TODO: always returns this course does not exist
        String courseCode;
        view.courseCodePrompt();
        courseCode = scanner.nextLine().trim();
        try {
            if (getBundle().getCourseManager().courseExists(courseCode)){
                getBundle().getCourseManager().removeCourse(courseCode);
                view.deleted();
            } else {
                view.doesNotExist();
            }
        } catch (Exception e) {
            view.printException(e);
        }
    }

    private void add(Scanner scanner) throws Exception {
        String courseCode;
        String description;
        String name;
        boolean tutorial;
        view.courseCodePrompt();
        courseCode = scanner.nextLine().trim();
        while (getBundle().getCourseManager().courseExists(courseCode)){
            view.codeExists();
            view.courseCodePrompt();
            courseCode = scanner.nextLine();
        }
        view.descriptionPrompt();
        description = scanner.nextLine().trim();
        view.namePrompt();
        name = scanner.nextLine().trim();
        view.tutorialPrompt();
        String s = scanner.nextLine().trim();
        tutorial = s.equals("yes");
        HashMap<String, Option> options = getOptions(courseCode, scanner);
        getBundle().getCourseManager().createCourse(courseCode, tutorial, description, name, options);
    }


    private HashMap<String, Option> getOptions(String code, Scanner scanner) throws Exception {
        HashMap<String, Option> options = new HashMap<>();
        boolean answer = true;
        String resp;
        try {
            do {
                Option o = createOption(code, scanner);
                options.put(o.getSectionCode(), o);
                view.addOption();
                resp = scanner.nextLine();
                if (!resp.equals("Yes")) {
                    answer = false;
                }
            } while (answer);
            return options;
        } catch (Exception e) {
            throw new Exception("gp");
        }
    }


    private Option createOption(String code, Scanner scanner) throws Exception {
        try {
            ArrayList<TimeSlot> timeslots = new ArrayList<>();
            String prof;
            String section;
            view.ProfPrompt();
            prof = scanner.nextLine().trim();
            view.sectionPrompt();
            section = scanner.nextLine().trim();
            boolean resp;
            do {
                String ans;
                view.timeSlot1();
                timeslots.add(createTimeSlot(scanner));
                scanner.nextLine();
                view.addTimeSlot();
                ans = scanner.nextLine();
                resp = ans.equals("Yes");
            } while (resp);
            return getBundle().getOptionManager().createOption(code, section, prof, timeslots);
        } catch (Exception e) {
            throw new Exception("co");
        }
    }

    private TimeSlot createTimeSlot(Scanner scanner) throws Exception {
        try {
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
            return getBundle().getOptionManager().createTimeSlot(start, end, day, location, duration);
        } catch (Exception e) {
            throw new Exception("cts");
        }
    }
}

