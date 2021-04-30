public abstract class AbstractController {
    public CourseManager courseManager;
    public ScheduleManager scheduleManager;
    public OptionManager optionManager;

    public AbstractController () {courseManager = new CourseManager(); scheduleManager = new ScheduleManager(); optionManager = new OptionManager();
    }

    public abstract  AbstractController run();
}
