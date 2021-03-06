import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
    //Controller needs to check for conflicts
    private HashMap<Course, Option> chosenOptions;
    private HashMap<String, ArrayList<TimeSlot>> schedule;
    private int compactnessScore;

    public Schedule(HashMap<Course, Option> chosenOptions){
        this.chosenOptions = chosenOptions;

        schedule = new HashMap<>();
        schedule.put("Monday", new ArrayList<>());
        schedule.put("Tuesday", new ArrayList<>());
        schedule.put("Wednesday", new ArrayList<>());
        schedule.put("Thursday", new ArrayList<>());
        schedule.put("Friday", new ArrayList<>());

        for (Option option : chosenOptions.values()){
            for (TimeSlot time : option.getTimes()){
                schedule.get(time.getDay()).add(time);
            }
        }

        compactnessScore = 0;
        for (String day : schedule.keySet()){
            ArrayList<TimeSlot> times = schedule.get(day);
            for (int i = 0; i < times.size() - 1; i++){
                compactnessScore = compactnessScore + (times.get(i+1).getStart() - times.get(i).getEnd());
            }
        }
    }

    public HashMap<Course, Option> getChosenOptions() {return chosenOptions;}

    public HashMap<String, ArrayList<TimeSlot>> getSchedule() {
        return schedule;
    }

    public void setChosenOptions(HashMap<Course, Option> chosenOptions) {
        this.chosenOptions = chosenOptions;
    }

    public void setSchedule(HashMap<String, ArrayList<TimeSlot>> schedule) {
        this.schedule = schedule;
    }

    public int getCompactnessScore() {return compactnessScore;}



}
