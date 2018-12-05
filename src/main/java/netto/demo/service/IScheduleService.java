package netto.demo.service;

import netto.demo.model.Schedule;

import java.util.List;

public interface IScheduleService {
    List<Schedule> fetchAll();

    Schedule fetchOne(int id);

    void save(Schedule schedule);

    void delete(int id);

}
