package netto.demo.repository;

import netto.demo.model.ExtraTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExtraTaskRepo extends JpaRepository<ExtraTask, Integer> {
}
