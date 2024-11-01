package com.freepath.schedule;

import com.freepath.schedule.domain.NewSchedule;
import com.freepath.schedule.domain.NewScheduledDisability;
import com.freepath.schedule.domain.NewScheduledPlace;
import com.freepath.schedule.domain.Schedule;
import com.freepath.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ScheduleCoreRepository implements ScheduleRepository {
    private final ScheduleJpaRepository scheduleJpaRepository;
    private final ScheduledPlaceJpaRepository placeJpaRepository;

    private final ScheduledDisabilityJpaRepository disabilityJpaRepository;

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

    @Override
    public Long saveSchedule(NewSchedule newSchedule) {
        return scheduleJpaRepository.save(new ScheduleEntity(newSchedule)).getId();
    }

    @Override
    public void saveAllScheduledPlace(List<NewScheduledPlace> newScheduledPlaces) {
        return;
    }

    @Override
    public void saveAllScheduledDisability(List<NewScheduledDisability> newScheduledDisability) {
        return;
    }
}
