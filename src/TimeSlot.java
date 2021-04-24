public class TimeSlot {

    private Integer start;
    private Integer end;
    private String day;
    private String location;
    private Integer duration;

    public TimeSlot(Integer start, Integer end, String day, String location, Integer duration){
        this.start = start;
        this.end = end;
        this.day = day;
        this.location = location;
        this.duration = duration;

    }

    public String getDay() {
        return day;
    }

    public String getLocation() {
        return location;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getEnd() {
        return end;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
