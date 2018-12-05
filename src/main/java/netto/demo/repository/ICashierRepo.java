package netto.demo.repository;

import netto.demo.model.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICashierRepo extends JpaRepository<Cashier, Integer> {

}
