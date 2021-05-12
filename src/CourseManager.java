import java.util.ArrayList;

public class CourseManager {
    //courses with no set day or time
    private ArrayList<Course> courses;

    public CourseManager(){courses = new ArrayList<>();}

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
                    if (timeSlot.getDay().equals(day)) {
                        c.removeOption(option);
                    }
                }
            }
        }
    }

    public Course getCourseByCode(String courseCode) throws Exception{
        //TODO: throw exception if course not in, and put try catch everywhere you use
        for (Course c : courses) {
            if (c.getCourseCode().equals(courseCode)) {
                return c;
            }
        }
        throw new Exception("This course does not exist");
    }

    public void removeCourse(Course c){
        courses.remove(c);
    }

    public void addCourse(Course c) {courses.add(c);}

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void createCourse(String courseCode, boolean tutorial, String description, String name, ArrayList<Option> options) {
        courses.add(new Course(courseCode, tutorial, description, name, options));
    }

    public void removeOption(String courseCode, String optionCode) throws Exception {
        try {
            for (Option o : getCourseByCode(courseCode).getOptions()) {
                if (o.getSectionCode().equals(optionCode)) {
                    getCourseByCode(courseCode).removeOption(o);
                }
            }
        } catch (Exception e){
            throw new Exception("This course does not exist");
        }

    }

    public void addOption(Option option, String courseCode) throws Exception {
        try {
            getCourseByCode(courseCode).addOption(option);
        } catch (Exception e){
            throw new Exception("This course does not exist");
        }
    }
}
