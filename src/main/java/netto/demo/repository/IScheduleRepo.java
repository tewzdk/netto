package netto.demo.repository;

import netto.demo.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleRepo  extends JpaRepository<Schedule, Integer> {
}
