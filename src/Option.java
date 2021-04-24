
import java.util.ArrayList;

public class Option {
    private String courseCode;
    private String professor;
    private ArrayList<TimeSlot> times;

    public Option(String courseCode, String professor, ArrayList<TimeSlot> times) {
        this.courseCode = courseCode;
        this.professor = professor;
        this.times = times;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getProfessor() {
        return professor;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public ArrayList<TimeSlot> getTimes() {
        return times;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setTimes(ArrayList<TimeSlot> times) {
        this.times = times;
    }
}
