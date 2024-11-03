package com.freepath.schedule.domain;

public record ScheduledPlace(Long id, Long placeId, Long scheduleId, int scheduledAt, int sequencePlace) {
}
