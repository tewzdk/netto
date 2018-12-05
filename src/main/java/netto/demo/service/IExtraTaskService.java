package netto.demo.service;

import netto.demo.model.ExtraTask;

import java.util.List;

public interface IExtraTaskService {
    List<ExtraTask> fetchAll();

    ExtraTask fetchOne(int id);

    void save(ExtraTask extraTask);

    void delete(int id);
}
