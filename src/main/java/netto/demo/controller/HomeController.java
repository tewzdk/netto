package netto.demo.controller;

import netto.demo.model.Schedule;
import netto.demo.model.ScheduleTask;
import netto.demo.model.Task;
import netto.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    //Autowire

    @Autowired
    IScheduleService scheduleService;

    @Autowired
    ITaskService taskService;

    @Autowired
    IExtraTaskService extraTaskService;

    @Autowired
    ICashierService cashierService;

    @Autowired
    IScheduleTaskService scheduleTaskService;

    @GetMapping("/")
    public String home(Model model){
        List<Schedule> schedules = scheduleService.fetchAll();
        model.addAttribute("schedules", schedules);

        //current date
        LocalDate ld = LocalDate.now();
        String date = ld.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        model.addAttribute("date", date);
        return "index";
    }

    @PostMapping("/create-schedule")
    public String createSchedule(@ModelAttribute Schedule schedule, Model model){
        schedule.setFeedbackMorning(" ");
        schedule.setFeedbackEvening(" ");
        schedule.setDate(LocalDate.now());
        model.addAttribute("schedule", schedule);
        scheduleService.save(schedule);

        List<Task> tasks = taskService.fetchAll();
        model.addAttribute("tasks", tasks);

        boolean done = false;
        String responsible = "";

        for (int i = 0; i < tasks.size(); i++) {
            ScheduleTask scheduleTask = new ScheduleTask(responsible, done, tasks.get(i), schedule);
            scheduleTaskService.save(scheduleTask);
            List<ScheduleTask> tempList = tasks.get(i).getScheduleTasks();
            tempList.add(scheduleTask);
            tasks.get(i).setScheduleTasks(tempList);
        }

        int id = schedule.getId();
        return "redirect:schedule/" + id;
    }

    @GetMapping("/schedule/{id}")
    public String schedule(@PathVariable("id") int id, Model model, @ModelAttribute Schedule schedule){
        model.addAttribute("schedule", scheduleService.fetchOne(id));

        List<Task> tasks = taskService.fetchAll();
        model.addAttribute("tasks", tasks);

        //clean list of all needed scheduleTasks
        List<ScheduleTask> scheduleTasks = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            for (int j = 0; j < tasks.get(i).getScheduleTasks().size(); j++) {
                if(tasks.get(i).getScheduleTasks().get(j).getSchedule() == schedule){
                    scheduleTasks.add(tasks.get(i).getScheduleTasks().get(j));
                }
            }
        }

        model.addAttribute("scheduleTasks", scheduleTasks);
        return "schedule";
    }

    @PostMapping("/update-task")
    public String updateTask(@ModelAttribute Schedule schedule){
        int scheduleid = schedule.getId();
        //scheduleTaskService.save();
        return "redirect:schedule/" + scheduleid;
    }

}
