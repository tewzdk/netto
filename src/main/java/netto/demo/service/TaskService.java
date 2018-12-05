package netto.demo.service;

import netto.demo.model.Task;
import netto.demo.repository.ITaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    ITaskRepo taskRepo;
    @Override
    public List<Task> fetchAll() {
        return taskRepo.findAll();
    }

    @Override
    public Task fetchOne(int id) {
        return taskRepo.getOne(id);
    }

    @Override
    public void save(Task task) {
        taskRepo.save(task);

    }

    @Override
    public void delete(int id) {
        taskRepo.deleteById(id);

    }
}
