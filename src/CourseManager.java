import java.util.ArrayList;

public class CourseManager {
    //courses with no set day or time
    private ArrayList<Course> courses;

    public CourseManager(){}

    //Removes times at a certain time
    public void breakPreference(Integer time){
        for (Course c : courses){
            for (Option option : c.getOptions()){
                for (TimeSlot timeSlot : option.getTimes()){
                    if (timeSlot.getStart() == time){
                   c.removeOption(option);
                    }
                }
            }
        }
    }

    //Removes times that start before a certain time
    public void startPreference(Integer time){
        for (Course c : courses){
            for (Option option : c.getOptions()){
                for (TimeSlot timeSlot : option.getTimes()){
                    if (timeSlot.getStart() < time){
                        c.removeOption(option);
                    }
                }
            }
        }
    }

    //Removes times that start after a certain time
    public void endPreference(Integer time) {
        for (Course c : courses) {
            for (Option option : c.getOptions()) {
                for (TimeSlot timeSlot : option.getTimes()) {
                    if (timeSlot.getStart() > time) {
                        c.removeOption(option);
                    }
                }
            }
        }
    }

    //Removes times on a specific day
    public void dayPreference(String day) {
        for (Course c : courses) {
            for (Option option : c.getOptions()) {
                for (TimeSlot timeSlot : option.getTimes()) {
                    if (timeSlot.getDay() == day) {
                        c.removeOption(option);
                    }
                }
            }
        }
    }

    public Course getCourseByCode(String courseCode){
        for (Course c : courses){
            if (c.getCourseCode() == courseCode){
                return c;
            }
            }
        return null;
        //raise an exception?
    }

    public void removeCourse(Course c){
        courses.remove(c);
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
