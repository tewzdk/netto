package netto.demo.repository;

import netto.demo.model.ExtraTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExtraTaskRepo extends JpaRepository<ExtraTask, Integer> {
}
