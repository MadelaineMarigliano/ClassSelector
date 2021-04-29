public abstract class AbstractController {
    public CourseManager courseManager;
    public ScheduleManager scheduleManager;

    public AbstractController () {courseManager = new CourseManager(); scheduleManager = new ScheduleManager();
    }

    public abstract  AbstractController run();
}
