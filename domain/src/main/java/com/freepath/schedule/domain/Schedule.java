package com.freepath.schedule.domain;

import java.time.LocalDateTime;

public record Schedule(
        Long id,
        Long userId,
        LocalDateTime startAt,
        LocalDateTime endAt,
        int totalPeople
        ) {
}
