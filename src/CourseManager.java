import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CourseManager {
    //courses with no set day or time
    private HashMap<String, Course> courses;

    public CourseManager() {
        courses = new HashMap<>();
    }

    //Removes times at a certain time
    public void breakPreference(Integer time) {
        for (Course c : courses.values()) {
            for (Option option : c.getOptions()) {
                for (TimeSlot timeSlot : option.getTimes()) {
                    if (timeSlot.getStart() == time) {
                        c.removeOption(option);
                    }
                }
            }
        }
    }

    //Removes times that start before a certain time
    public void startPreference(Integer time) {
        for (Course c : courses.values()) {
            for (Option option : c.getOptions()) {
                for (TimeSlot timeSlot : option.getTimes()) {
                    if (timeSlot.getStart() < time) {
                        c.removeOption(option);
                    }
                }
            }
        }
    }

    //Removes times that start after a certain time
    public void endPreference(Integer time) {
        for (Course c : courses.values()) {
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
        for (Course c : courses.values()) {
            for (Option option : c.getOptions()) {
                for (TimeSlot timeSlot : option.getTimes()) {
                    if (timeSlot.getDay().equals(day)) {
                        c.removeOption(option);
                    }
                }
            }
        }
    }

    public Course getCourseByCode(String courseCode) throws Exception {
        //TODO: throw exception if course not in, and put try catch everywhere you use
        if (courses.containsKey(courseCode)) {
            return courses.get(courseCode);
        } else {
            throw new Exception("This course does not exist");
        }


    }

    public boolean courseExists(String code) {
        return courses.containsKey(code);
    }


    public void removeCourse(String c) {
        courses.remove(c);
    }


    public Collection<Course> getCourses() {
        return courses.values();
    }

    public void createCourse(String courseCode, boolean tutorial, String description, String
            name, HashMap<String, Option> options) {
        courses.put(courseCode, new Course(courseCode, tutorial, description, name, options));
    }

    public void removeOption(String courseCode, String optionCode) throws Exception {
        try {
            if (getCourseByCode(courseCode).getOptionsHashMap().containsKey(optionCode)) {
                getCourseByCode(courseCode).getOptionsHashMap().remove(optionCode);
            } else {
                throw new Exception("This option does not exist");
            }


        } catch (Exception e) {
            throw new Exception(e.toString());
        }

    }

    public void addOption(Option option, String courseCode) throws Exception {
        try {
            getCourseByCode(courseCode).addOption(option);
        } catch (Exception e) {
            throw new Exception("This course does not exist");
        }
    }

    public boolean onlyOption(String courseCode) throws Exception {
        try{
            Integer i = 1;
            return i.equals(getCourseByCode(courseCode).getOptionsHashMap().size());
        } catch (Exception e){
            throw new Exception(e.toString());
        }
    }
}
