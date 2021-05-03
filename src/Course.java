import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String description;
    private String name;
    private Option chosenOption;
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

    public void setChosenOption(Option option){
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

    public Option getChosenOption(){return chosenOption;}

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

    public void addOption(Option o){
        options.add(o);
    }

    public void removeOption(Option option){
        options.remove(option);
    }
}
