package com.freepath.schedule;

import com.freepath.schedule.domain.Schedule;
import com.freepath.schedule.repository.ScheduleRepository;
import java.sql.Timestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ScheduleCoreRepository implements ScheduleRepository {
    private final ScheduleJpaRepository scheduleJpaRepository;

    @Override
    public List<Schedule> getSchedulePeriodOnMonth(int month) {
        List<ScheduleEntity> scheduleEntities = scheduleJpaRepository.getScheduleInMonth(2024, month);
        for (ScheduleEntity s : scheduleEntities) {
            System.out.println(s.getStartAt());
        }
        
        return scheduleJpaRepository.getScheduleInMonth(2024, month)
                .stream()
                .map(ScheduleEntity::toSchedule)
                .collect(Collectors.toList());
    }
}
