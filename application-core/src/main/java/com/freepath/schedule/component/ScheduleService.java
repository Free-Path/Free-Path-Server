package com.freepath.schedule.component;

import com.freepath.disability.Disability;
import com.freepath.schedule.domain.NewSchedule;
import com.freepath.schedule.domain.NewScheduledDisability;
import com.freepath.schedule.domain.NewScheduledPlace;
import com.freepath.schedule.domain.Schedule;
import com.freepath.schedule.dto.reqeust.DailyScheduleCoreRequest;
import com.freepath.schedule.dto.reqeust.SaveScheduleCoreRequest;
import com.freepath.schedule.repository.ScheduleRepository;
import java.util.ArrayList;
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

    public Long saveSchedule(SaveScheduleCoreRequest saveScheduleCoreRequest) {
        // 여행 일정 저장 로직
        Long scheduleId = scheduleRepository.saveSchedule(
                new NewSchedule(1L, saveScheduleCoreRequest.schedules().getFirst().scheduleAt().atStartOfDay(),
                        saveScheduleCoreRequest.schedules().getLast().scheduleAt().atStartOfDay(),
                        saveScheduleCoreRequest.totalPeople()));

        // 여행 일정에 포함된 여행지 저장 로직
        List<NewScheduledPlace> scheduledPlaces = new ArrayList<>();
        for (DailyScheduleCoreRequest dailyScheduleCoreRequest : saveScheduleCoreRequest.schedules()) {
            int sequenceIdx = 0;
            for (Long placeId : dailyScheduleCoreRequest.destinationIds()) {
                scheduledPlaces.add(new NewScheduledPlace(placeId, scheduleId,
                        dailyScheduleCoreRequest.scheduleAt().atStartOfDay(), sequenceIdx++));
            }
        }
        scheduleRepository.saveAllScheduledPlace(scheduledPlaces);

        // 여행 일정 시 장애 종류 로직
        List<NewScheduledDisability> scheduledDisabilities = new ArrayList<>();
        for (String disability : saveScheduleCoreRequest.disabilities()) {
            if (!Disability.existType(disability)) {
                throw new RuntimeException("일치하는 타입이 없습니다.");
            }
            scheduledDisabilities.add(new NewScheduledDisability(scheduleId, disability));
        }
        scheduleRepository.saveAllScheduledDisability(scheduledDisabilities);

        return scheduleId;
    }

}
