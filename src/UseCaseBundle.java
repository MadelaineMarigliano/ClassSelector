import javafx.stage.Stage;
public class UseCaseBundle {
    private ScheduleManager scheduleManager;
    private CourseManager courseManager;
    private OptionManager optionManager;
    private TimeSlotManager timeSlotManager;
    private Stage window;

    public UseCaseBundle() {
        scheduleManager = new ScheduleManager();
        courseManager = new CourseManager();
        optionManager = new OptionManager();
        timeSlotManager = new TimeSlotManager();
    }

    public CourseManager getCourseManager() {
        return courseManager;
    }

    public OptionManager getOptionManager() {
        return optionManager;
    }

    public ScheduleManager getScheduleManager() {
        return scheduleManager;
    }

    public TimeSlotManager getTimeSlotManager() {
        return timeSlotManager;
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }
}
