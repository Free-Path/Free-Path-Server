package com.freepath.schedule.domain;

import java.time.LocalDateTime;

public record NewSchedule(Long userId, LocalDateTime startAt, LocalDateTime endAt, int totalPeople) {
}
