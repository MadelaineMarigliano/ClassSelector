import java.util.ArrayList;

public class CourseManager {
    //courses with no set day or time
    private ArrayList<Course> courses;

    public CourseManager(){}

    //Removes times at a certain time
    public void breakPreference(Course c, Integer time){
       for (Option option : c.getOptions()){
           for (TimeSlot timeSlot : option.getTimes()){
               if (timeSlot.getStart() == time){
                   c.removeOption(option);
               }
           }
       }
    }

    //Removes times that start before a certain time
    public void startPreference(Course c, Integer time){
        for (Option option : c.getOptions()){
            for (TimeSlot timeSlot : option.getTimes()){
                if (timeSlot.getStart() < time){
                    c.removeOption(option);
                }
            }
        }
    }

    //Removes times that start after a certain time
    public void endPreference(Course c, Integer time){
        for (Option option : c.getOptions()){
            for (TimeSlot timeSlot : option.getTimes()){
                if (timeSlot.getStart() > time){
                    c.removeOption(option);
                }
            }
        }
    }

    //Removes times on a specific day
    public void dayPreference(Course c, String day){
        for (Option option : c.getOptions()){
            for (TimeSlot timeSlot : option.getTimes()){
                if (timeSlot.getDay() == day){
                    c.removeOption(option);
                }
            }
        }
    }




}
