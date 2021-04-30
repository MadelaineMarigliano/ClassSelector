import java.util.ArrayList;

public class OptionManager {

    public OptionManager() {}

    public Option createOption(String courseCode, String sectionCode, String professor, ArrayList<TimeSlot> times){
        return new Option(courseCode, sectionCode, professor, times);
    }

    public TimeSlot createTimeSlot(Integer start, Integer end, String day, String location, Integer duration){
        return new TimeSlot(start, end, day, location, duration);
    }
}
