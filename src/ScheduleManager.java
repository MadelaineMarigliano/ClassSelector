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

    //TODO
    public File printToHTML(){
        File file = new File("Schedule.html");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter ScheduleHTML = new BufferedWriter(fileWriter);
            ScheduleHTML.write("<html><h1><strong><span style=\"font-family:Arial, Helvetica, sans-serif;" +
                    "text-align:center;color: #28324e;\">Event Schedule</span></strong></h1>" +
                    "<table style=\"font-family:Arial, Helvetica, sans-serif;height: 74px; width: 100%; " +
                    "border-collapse: collapse; border-style: solid;\" border=\"1\"> <tbody>");
            for (String day : chosenSchedule.getSchedule().keySet()) {
                ScheduleHTML.write("<tr><td style=\"background-color:#475577;color:white;\"><b>" + day +
                        "</b></td>");
                /*
                ArrayList<Event> eventList = schedule.get(t);
                eventList.sort(new Comparator<Event>() {
                    @Override
                    public int compare(Event o1, Event o2) {
                        return o1.getStartTime().getMinute() - o2.getStartTime().getMinute();
                    }
                });
                for (Event event : eventList) {
                    ScheduleHTML.write("<td>" + event.toString() + "</td>");
                }
                if (eventList.size() < l) {
                    for (int i = eventList.size() ; i < l ; i++) {
                        ScheduleHTML.write("<td> </td>");
                    }
                }
                ScheduleHTML.write("</tr>");
            */
            }


            ScheduleHTML.write("</tbody></table></html>");
            ScheduleHTML.close();

        } catch (Exception e) {//ignore}
        }
        return file;
    }


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
