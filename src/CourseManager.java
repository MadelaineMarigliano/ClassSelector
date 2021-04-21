import java.util.ArrayList;

public class CourseManager {
    //courses with no set day or time
    private ArrayList<Course> courses;

    public CourseManager(){}

    // Gets the number of different time options there are for course c
    public int numberOfTimes(Course c){
        int n = 0;
        for (String day : c.getTimes().keySet()){
            n = n + c.getTimes().get(day).size();
        }
        return n;
    }

    //Removes times at a certain time
    public void breakPreference(Course c, Integer time){
        for (String day : c.getTimes().keySet()){
            for (TimeSlot t : c.getTimes().get(day)) {
                if (t.getStart() == time){
                    c.removeTime(day, t);
                }
            }
        }
    }

    //Removes times that start before a certain time
    public void startPreference(Course c, Integer time){
        for (String day : c.getTimes().keySet()){
            for (TimeSlot t : c.getTimes().get(day)) {
                if (t.getStart() < time){
                    c.removeTime(day, t);
                }
            }
        }
    }

    //Removes times that start after a certain time
    public void endPreference(Course c, Integer time){
        for (String day : c.getTimes().keySet()){
            for (TimeSlot t : c.getTimes().get(day)) {
                if (t.getStart() > time){
                    c.removeTime(day, t);
                }
            }
        }
    }

    //Removes times on a specific day
    public void dayPreference(Course c, String day){
        c.removeDay(day);
    }




}
