import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ScheduleManager {
    ArrayList<Schedule> scheduleArrayList;
    private ScheduleManager manager;

    public ScheduleManager(){
        scheduleArrayList = new ArrayList<>();
    }

    //TODO
    public void printToHTML(Schedule s){}


    //These courses are the ones with preferences applied already
    //We should probably use recursion here... sbatessss
    //TODO
    private ArrayList<Schedule> createSchedules(ArrayList<Course> courses){
        return null;
    }

    public Schedule bestSchedule(ArrayList<Course> courses) {
        ArrayList<Schedule> schedules = createSchedules(courses);
        schedules.sort(Comparator.comparing(Schedule::getCompactnessScore));
        return schedules.get(0);
    }

}
