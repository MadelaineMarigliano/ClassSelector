import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String courseCode;
    private String description;
    private String name;
    private TimeSlot chosenTime;
    private ArrayList<Option> options;

    public Course(String courseCode, boolean tutorial, String description, String name, ArrayList<Option> options) {
        if (tutorial) {
            this.courseCode = courseCode + "TUT";
        } else {
            this.courseCode = courseCode + "LEC";
        }
        this.description = description;
        this.name = name;
        this.options = options;

    }

    public void setChosenTime(TimeSlot time){
        this.chosenTime = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public TimeSlot getChosenTime(){return chosenTime;}

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public void removeOption(Option option){
        options.remove(option);
    }
}
