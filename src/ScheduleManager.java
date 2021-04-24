import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScheduleManager {
    ArrayList<Schedule> scheduleArrayList;

    public ScheduleManager(){
        scheduleArrayList = new ArrayList<>();
    }

    //NOT DONE
    public void printToHTML(Schedule s){}

    //NOT DONE
    public int compactnessScore(Schedule s){
        int score = 0;
        HashMap<Course, ArrayList<Integer>> schedule = s.getCourses();


        return score;
    }

    //checks if there is a conflict
    //NOT DONE
    private boolean courseConflict(Schedule s, Course c){return false;}

    private void setScheduleArrayList(ArrayList<Course> courses){
        this.scheduleArrayList = this.createSchedules(courses);
    }

    //These courses are the ones with preferences applied already
    //We should probably use recursion here... sbatessss
    //NOT DONE
    private ArrayList<Schedule> createSchedules(ArrayList<Course> courses){

        ArrayList<Schedule> schedules = new ArrayList<>();


        if (courses.size() == 0) {
            return schedules;
        }else {
            Course c = courses.get(0);
            for (String day : c.getTimes().keySet()){
                for (TimeSlot t : c.getTimes().get(day)) {

                    }
            }
            courses.remove(c);
            schedules.addAll(createSchedules(courses));
        }


        return schedules;
    }





}
