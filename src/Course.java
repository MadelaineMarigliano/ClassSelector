import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String courseCode;
    private String description;
    private String name;
    private String day;
    private Integer start;
    private Integer end;
    private HashMap<String, ArrayList<TimeSlot>> times;

    public Course(String courseCode, boolean tutorial, String description, String name, HashMap<String, ArrayList<TimeSlot>> times) {
        if (tutorial) {
            this.courseCode = courseCode + "TUT";
        } else {
            this.courseCode = courseCode + "LEC";
        }
        this.description = description;
        this.name = name;
        this.times = times;

    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public String getDay() {
        return day;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, ArrayList<TimeSlot>> getTimes() {
        return times;
    }

    public void removeTime(String day, TimeSlot time){
        times.get(day).remove(time);
    }

    public void removeDay(String day){
        times.get(day).clear();
    }
}
