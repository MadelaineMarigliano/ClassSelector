import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap<Course, Option> schedule = s.getChosenOptions();


        return score;
    }

    //checks if there is a conflict
    //NOT DONE
    private boolean courseConflict(Schedule s, Course c){return false;}


    //These courses are the ones with preferences applied already
    //We should probably use recursion here... sbatessss
    //NOT DONE
    private ArrayList<Schedule> createSchedules(ArrayList<Course> courses){
        return null;
    }

}
