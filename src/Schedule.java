import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
    //course with a set day and time
    //I don't know if we need this class... we won't up saving the schedule but rather updating the class objects
    // to hold the chosen time at the end of finding the best schedule
    //So we probably will get rid of this class but lets just wait
    private HashMap<Course, Option> chosenOptions;

    public HashMap<Course, Option> getChosenOptions() {return chosenOptions;
    }

    //Controller needs to check for conflicts
}
