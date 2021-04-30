import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

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
    //We should probably use recursion here... sbatessss
    //TODO
    private ArrayList<Schedule> createSchedules(ArrayList<Course> courses){
        return null;
    }

    public Schedule bestSchedule(ArrayList<Course> courses) {
        ArrayList<Schedule> schedules = createSchedules(courses);
        schedules.sort(Comparator.comparing(Schedule::getCompactnessScore));
        this.chosenSchedule = schedules.get(0);
        return schedules.get(0);
    }

}
