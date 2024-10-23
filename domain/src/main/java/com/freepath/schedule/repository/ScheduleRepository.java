package com.freepath.schedule.repository;

import com.freepath.schedule.domain.Schedule;

import java.util.List;

public interface ScheduleRepository {

    // 해당 월에 계획된 여행 일정 조회
    List<Schedule> getSchedulePeriodOnMonth(int month);
}
