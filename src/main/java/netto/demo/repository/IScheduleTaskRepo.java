package netto.demo.repository;

import netto.demo.model.ScheduleTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleTaskRepo extends JpaRepository<ScheduleTask, Integer> {
}
