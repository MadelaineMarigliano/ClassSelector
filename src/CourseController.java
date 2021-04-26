import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseController {
    private CourseView view;
    private CourseManager manager;

    private AbstractController run() {
        Scanner scanner = new Scanner(System.in);
        view.displayMenu();
        int option;
        option = selectOption(scanner);
        switch(option) {
            case 1: //add course
                add(scanner);
            case 2: //delete course
                delete(scanner);
            case 3: // modify course:
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

    //NOT DONE
    private void modify(Scanner scanner) {
    }

    private void delete(Scanner scanner) {
        String courseCode;
        view.courseCodePrompt();
        courseCode = scanner.nextLine().trim();
        Course c = manager.getCourseByCode(courseCode);
        manager.removeCourse(c);
    }

    private void add(Scanner scanner) {
        //TODO: finish by jasmeen
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
        if (s == "yes") {
            tutorial = true;
        } else {tutorial = false;}
        ArrayList<Option> options = getOptions(courseCode, scanner);
        Course c = new Course(courseCode, tutorial, description, name, options);
        manager.addCourse(c);
    }

    //NOT DONE
    private ArrayList<Option> getOptions(String code, Scanner scanner){
        ArrayList options = new ArrayList<Option>();
        String answer = new String("Yes");
        String answer2 = new String("Yes");
        String prof;
        do {
            view.ProfPrompt();
            prof = scanner.nextLine().trim();
            ArrayList timeslots = new ArrayList<TimeSlot>();
            do {
                Integer start;
                Integer end;
                Integer duration;
                String day;
                String location;
                view.dayPrompt();
                day = scanner.nextLine().trim();
                view.locationPrompt();
                location = scanner.nextLine().trim();
                start = getTime("start", scanner);
                end = getTime("end", scanner);
                duration = getTime("duration", scanner);
                view.addTimeSlot();
                answer2 = scanner.nextLine();
                timeslots.add(new TimeSlot(start, end, day, location, duration));
            } while (answer2.equals("Yes"));
            options.add( new Option(code, prof, timeslots));
            view.addOption();
            answer = scanner.nextLine();
        } while (answer.equals("Yes"));
        return options;
    }

    private Integer getTime(String name, Scanner scanner) {
        if(name.equals("start")){

        }
        if (name.equals("end")){

        }
        if (name.equals("duration")){

        }

    }
}

