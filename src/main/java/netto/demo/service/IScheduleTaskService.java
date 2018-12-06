package netto.demo.service;

import netto.demo.model.ScheduleTask;

import java.util.List;

public interface IScheduleTaskService {

    List<ScheduleTask> fetchAll();

    ScheduleTask fetchOne(int id);

    void save(ScheduleTask schedule);

    void delete(int id);
}
