package com.freepath.schedule;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScheduleJpaRepository extends JpaRepository<ScheduleEntity, Long> {

    @Query("SELECT s FROM ScheduleEntity s WHERE (YEAR(s.startAt) < :year OR (YEAR(s.startAt) = :year AND MONTH(s.startAt) <= :month)) "
            + "AND (YEAR(s.endAt) > :year OR (YEAR(s.endAt) = :year AND MONTH(s.endAt) >= :month))")
    List<ScheduleEntity> getScheduleInMonth(@Param("year") int year, @Param("month") int month);

}