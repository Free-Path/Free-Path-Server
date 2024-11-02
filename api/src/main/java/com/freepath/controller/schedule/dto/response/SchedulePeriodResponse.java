package com.freepath.controller.schedule.dto.response;

import com.freepath.schedule.domain.Schedule;

import java.time.LocalDate;

public record SchedulePeriodResponse(LocalDate startAt, LocalDate endAt) {
    public static SchedulePeriodResponse of(Schedule schedule) {
        return new SchedulePeriodResponse(schedule.startAt().toLocalDate(), schedule.endAt().toLocalDate());
    }
}
