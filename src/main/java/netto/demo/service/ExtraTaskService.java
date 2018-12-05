package netto.demo.service;

import netto.demo.model.ExtraTask;
import netto.demo.repository.IExtraTaskRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExtraTaskService implements IExtraTaskService {
    @Autowired
    IExtraTaskRepo extraTaskRepo;
    @Override
    public List<ExtraTask> fetchAll() {
        return extraTaskRepo.findAll();
    }

    @Override
    public ExtraTask fetchOne(int id) {
        return extraTaskRepo.getOne(id);
    }

    @Override
    public void save(ExtraTask extraTask) {
        extraTaskRepo.save(extraTask);
    }

    @Override
    public void delete(int id) {
        extraTaskRepo.deleteById(id);
    }
}
