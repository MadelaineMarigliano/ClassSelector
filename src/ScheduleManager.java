import java.util.ArrayList;
import java.util.HashMap;

public class ScheduleManager {
    ArrayList<Schedule> scheduleArrayList;
    private ScheduleManager manager;

    public ScheduleManager(){
        scheduleArrayList = new ArrayList<>();
    }

    //NOT DONE
    public void printToHTML(Schedule s){}


    public int compactnessScore(Schedule s){
        int score = 0;
        for (String day : s.getSchedule().keySet()){
            ArrayList<TimeSlot> times = s.getSchedule().get(day);
            for (int i = 0; i < times.size() - 1; i++){
                score = score + (times.get(i+1).getStart() - times.get(i).getEnd());
            }
        }
        return score;
    }

    //These courses are the ones with preferences applied already
    //We should probably use recursion here... sbatessss
    //NOT DONE
    private ArrayList<Schedule> createSchedules(ArrayList<Course> courses){
        return null;
    }

}
