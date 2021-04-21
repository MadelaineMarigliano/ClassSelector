public class TimeSlot {

    private Course course;
    private Integer start;
    private Integer end;
    private String day;
    private String professor;
    private String location;
    private Integer duration;

    public TimeSlot(Course course,Integer start, Integer end, String day, String professor, String location, Integer duration){
        this.course = course;
        this.start = start;
        this.end = end;
        this.day = day;
        this.professor = professor;
        this.location = location;
        this.duration = duration;

    }

}
