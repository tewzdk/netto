package netto.demo.service;

import netto.demo.model.Task;

import java.util.List;

public interface ITaskService {
    List<Task> fetchAll();

    Task fetchOne(int id);

    void save(Task task);

    void delete(int id);
}
