package com.freepath.schedule.domain;

import com.freepath.disability.Disability;

public record ScheduledDisability(
        Long id,
        Long scheduleId,
        Disability disability
) {
}
