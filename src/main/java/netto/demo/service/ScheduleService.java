package netto.demo.service;

import netto.demo.model.Schedule;
import netto.demo.repository.IScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService implements IScheduleService{
    @Autowired
    IScheduleRepo scheduleRepo;
    @Override
    public List<Schedule> fetchAll() {
        return scheduleRepo.findAll();
    }

    @Override
    public Schedule fetchOne(int id) {
        return scheduleRepo.getOne(id);
    }

    @Override
    public void save(Schedule schedule) {
        scheduleRepo.save(schedule);
    }

    @Override
    public void delete(int id) {
        scheduleRepo.deleteById(id);
    }
}
