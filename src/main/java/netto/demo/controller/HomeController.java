package netto.demo.controller;

import netto.demo.model.Cashier;
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
        schedule.setDate(LocalDate.now());
        model.addAttribute("schedule", schedule);

        scheduleService.save(schedule);

        List<Task> tasks = taskService.fetchAll();
        model.addAttribute("tasks", tasks);



        boolean done = false;
        String responsible = "";

        //adding empty list of scheduleTasks
        for (int i = 0; i < tasks.size(); i++) {
            ScheduleTask scheduleTask = new ScheduleTask(responsible, done, tasks.get(i), schedule);
            scheduleTaskService.save(scheduleTask);
            List<ScheduleTask> tempList = tasks.get(i).getScheduleTasks();
            tempList.add(scheduleTask);
            tasks.get(i).setScheduleTasks(tempList);
        }

        // TODO: 07-12-2018 make another proper scheduletask populator.

        //adding empty list of cashiers
        List<Cashier> cashiers = new ArrayList<>();
        for (int i = 0; i < 4; i++) { //4 can be changed to a dynamic size
            Cashier cashier = new Cashier();
            cashier.setSchedule(schedule);
            cashier.setName("Kasse: " + (i+1));
            cashierService.save(cashier);
            cashiers.add(new Cashier());
        }
        schedule.setCashiers(cashiers);

        int id = schedule.getId();

        return "redirect:schedule/" + id;
    }

    @GetMapping("/schedule/{id}")
    public String schedule(@PathVariable("id") int id, Model model, @ModelAttribute Schedule schedule){
        model.addAttribute("schedule", scheduleService.fetchOne(id));

        return "schedule";
    }

    @PostMapping("/update-schedule")
    public String updateSchedule(@ModelAttribute Schedule schedule){
        scheduleService.save(schedule);
        return "redirect:/schedule/" + schedule.getId();
    }

    @PostMapping("/update-cashier")
    public String updateCashier(@ModelAttribute Cashier cashier){
        return "";
    }

    @PostMapping("/update-task")
    public String updateTask(@RequestParam("taskId") int taskId, @RequestParam("scheduleId") int scheduleId, @ModelAttribute ScheduleTask scheduleTask){
        scheduleTask.setTask(taskService.fetchOne(taskId));
        scheduleTask.setSchedule(scheduleService.fetchOne(scheduleId));
        scheduleTaskService.save(scheduleTask);
        return "redirect:/schedule/" + scheduleId;
    }

}
