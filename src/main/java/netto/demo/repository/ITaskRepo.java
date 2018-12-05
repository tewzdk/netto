package netto.demo.repository;

import netto.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepo extends JpaRepository<Task, Integer> {

}
