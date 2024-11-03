package com.freepath.controller.schedule.dto.request;

import com.freepath.schedule.dto.reqeust.DailyScheduleCoreRequest;
import java.time.LocalDate;
import java.util.List;

public record DailyScheduleRequest(LocalDate scheduleAt, List<Long> destinationIds) {
    public DailyScheduleCoreRequest toCoreRequest() {
        return new DailyScheduleCoreRequest(this.scheduleAt, this.destinationIds);
    }
}
