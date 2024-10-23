package com.freepath.schedule.component;

import com.freepath.schedule.domain.Schedule;
import com.freepath.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    public List<Schedule> getBookedDates(int month) {
        return scheduleRepository.getSchedulePeriodOnMonth(month);
    }
}
