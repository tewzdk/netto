package netto.demo.service;

import netto.demo.model.Cashier;

import java.util.List;

public interface ICashierService {
    List<Cashier> fetchAll();

    Cashier fetchOne(int id);

    void save(Cashier cashier);

    void delete(int id);

    }
