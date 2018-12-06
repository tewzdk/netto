package netto.demo.controller;

import netto.demo.model.Schedule;
import netto.demo.service.ICashierService;
import netto.demo.service.IExtraTaskService;
import netto.demo.service.IScheduleService;
import netto.demo.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        scheduleService.save(schedule); //regn ud hvordan vi skal gemme tasks for det specifikke schedule.
        int id = schedule.getId();
        return "redirect:schedule/" + id;
    }

    @GetMapping("/schedule/{id}")
    public String schedule(@PathVariable("id") int id, Model model){
        model.addAttribute("schedule", scheduleService.fetchOne(id));
        model.addAttribute("tasks", taskService.fetchAll());

        return "schedule";
    }

}
