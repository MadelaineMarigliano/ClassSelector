import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import static javafx.scene.input.KeyCode.Y;

public class ScheduleManager {
    ArrayList<Schedule> scheduleArrayList;
    Schedule chosenSchedule;

    public ScheduleManager(){
        scheduleArrayList = new ArrayList<>();
    }

    /*
    public File printToHTML(){
        File file = new File("Schedule.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter ScheduleHTML = new BufferedWriter(fileWriter);
            ScheduleHTML.write("<html><h1><strong><span style=\"font-family:Arial, Helvetica, sans-serif;" +
                    "text-align:center;color: #28324e;\">Event Schedule</span></strong></h1>" +
                    "<table style=\"font-family:Arial, Helvetica, sans-serif;height: 74px; width: 100%; " +
                    "border-collapse: collapse; border-style: solid;\" border=\"1\"> <tbody>");

            ScheduleHTML.write("<tr><td><b>Monday</b></td><td><b>Tuesday</b></td><td><b>Wednesday</b></td><td><b>" +
                    "Thursday</b></td><td><b>Friday</b></td>");

            for (String day : chosenSchedule.getSchedule().keySet()) {
                ScheduleHTML.write("<tr><td style=\"background-color:#475577;color:white;\"><b>" + day +
                        "</b></td>");

            ScheduleHTML.write("</tbody></table></html>");
            ScheduleHTML.close();

        } catch (Exception e) {//ignore}
        }
        return file;
    }
*/

    //These courses are the ones with preferences applied already
    private void createSchedules(HashMap<Course, ArrayList<Option>> map, HashMap<Course, Option>
            schedule, ArrayList<HashMap<Course, Option>> schedules){
        if (!map.isEmpty()){
             Map.Entry<Course, ArrayList<Option>> e = map.entrySet().iterator().next();
             Course c = e.getKey();
             ArrayList<Option> a = e.getValue();
             map.remove(c, a);
            for (Option o : a){
                schedule.put(c,o);
                createSchedules(map, schedule, schedules);
                schedule.remove(c, o);
            }
        } else {schedules.add(schedule);}
    }

    public Schedule bestSchedule(ArrayList<Course> courses) {
        HashMap<Course, ArrayList<Option>> map = new HashMap<>();
        for (Course course : courses) {
            map.put(course, course.getOptions());
        }
        ArrayList<HashMap<Course, Option>> schedulesValues = new ArrayList<>();
        createSchedules(map, new HashMap<>(), schedulesValues);
        ArrayList<Schedule> schedules = new ArrayList<>();

        for (HashMap<Course, Option> chosenOptions : schedulesValues) {schedules.add(new Schedule(chosenOptions));}

        schedules.sort(Comparator.comparing(Schedule::getCompactnessScore));
        this.chosenSchedule = schedules.get(0);
        return schedules.get(0);
    }

    private boolean scheduleOverlap(Schedule schedule){
        ArrayList<TimeSlot> times = new ArrayList<>();
        for (ArrayList arr : schedule.getSchedule().values()){
            times.addAll(arr);
        }

        for (int i = 0; i < times.size(); i++) {
            for (int k = i + 1; k < times.size(); k++) {
                if (times.get(i).timeOverlap(times.get(i+1))) {
                    return true;
                }
            }
        }
        return false;
    }


}
