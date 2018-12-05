package netto.demo.service;

import netto.demo.model.Cashier;
import netto.demo.repository.ICashierRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CashierService implements ICashierService {
    @Autowired
    ICashierRepo cashierRepo;
    @Override
    public List<Cashier> fetchAll() {
        return cashierRepo.findAll();
    }

    @Override
    public Cashier fetchOne(int id) {
        return cashierRepo.getOne(id);
    }

    @Override
    public void save(Cashier cashier) {
        cashierRepo.save(cashier);

    }

    @Override
    public void delete(int id) {
        cashierRepo.deleteById(id);
    }
}
