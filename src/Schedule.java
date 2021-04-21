import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
    //course with a set day and time
    private HashMap<Course, ArrayList<Integer>> courses;

    //Controller needs to check for conflicts
    public Schedule(ArrayList<Course> courses){
        this.courses = new HashMap<>();
        for (Course course : courses){
            this.courses.put(course, new ArrayList<>());
        }
    }

    public HashMap<Course, ArrayList<Integer>> getCourses() {
        return courses;
    }
}
