package com.freepath.schedule.dto.reqeust;

import java.time.LocalDate;
import java.util.List;

public record DailyScheduleCoreRequest(LocalDate scheduleAt, List<Long> destinationIds) {
}
