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
        //TODO: throw exception if course not in, and put try catch everywhere you use
        for (Course c : courses){
            if (c.getCourseCode() == courseCode){
                return c;
            }
            }
        return null;

    }

    public void removeCourse(Course c){
        courses.remove(c);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void createCourse(String courseCode, boolean tutorial, String description, String name, ArrayList<Option> options) {
        courses.add(new Course(courseCode, tutorial, description, name, options));
    }

    public void removeOption(String courseCode, String optionCode){
        for(Option o: getCourseByCode(courseCode).getOptions()){
            if(o.getSectionCode().equals(optionCode)){
                getCourseByCode(courseCode).removeOption(o);
            }
        }

    }

    public void addOption(Option option, String courseCode) {
        getCourseByCode(courseCode).addOption(option);
    }
}
