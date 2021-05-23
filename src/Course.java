import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private String courseCode;
    private String description;
    private String name;
    private Option chosenOption;
    private HashMap<String, Option> options;

    public Course(String courseCode, boolean tutorial, String description, String name, HashMap<String, Option> options) {
        // TODO: problem occurs here
        if (tutorial) {
            this.courseCode = courseCode + "TUT";
        } else {
            this.courseCode = courseCode + "LEC";
        }
        this.description = description;
        this.name = name;
        this.options = options;

    }

    public void setChosenOption(Option option) {
        this.chosenOption = option;
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

    public Option getChosenOption() {
        return chosenOption;
    }

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
        return (ArrayList<Option>) options.values();
    }

    public void setOptions(HashMap<String, Option> options) {
        this.options = options;
    }

    public void addOption(Option o) {
        options.put(o.getSectionCode(), o);
    }

    public void removeOption(Option option) {
        options.remove(option.getSectionCode());
    }

    public HashMap<String, Option> getOptionsHashMap() {
        return options;
    }
}
