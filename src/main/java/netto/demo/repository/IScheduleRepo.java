package netto.demo.repository;

import netto.demo.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IScheduleRepo  extends JpaRepository<Schedule, Integer> {
}
