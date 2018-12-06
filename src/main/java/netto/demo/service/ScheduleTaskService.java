package netto.demo.service;

import netto.demo.model.Schedule;
import netto.demo.model.ScheduleTask;
import netto.demo.repository.IScheduleTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ScheduleTaskService implements IScheduleTaskService {
    @Autowired
    IScheduleTaskRepo scheduleTaskRepo;

    @Override
    public List<ScheduleTask> fetchAll() {
        return scheduleTaskRepo.findAll();
    }

    @Override
    public ScheduleTask fetchOne(int id) {
        return scheduleTaskRepo.getOne(id);
    }

    @Override
    public void save(ScheduleTask schedule) {
        scheduleTaskRepo.save(schedule);
    }

    @Override
    public void delete(int id) {
        scheduleTaskRepo.deleteById(id);
    }
}
