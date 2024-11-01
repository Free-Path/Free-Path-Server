package com.freepath.schedule.domain;

import java.time.LocalDateTime;

public record NewScheduledPlace(
        Long placeId,
        Long scheduleId,
        LocalDateTime scheduledAt,
        int sequencePlace
) {
}
