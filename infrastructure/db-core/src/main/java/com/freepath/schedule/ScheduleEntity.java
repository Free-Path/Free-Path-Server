package com.freepath.schedule;

import com.freepath.BaseEntity;
import com.freepath.schedule.domain.Schedule;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "schedule")
public class ScheduleEntity extends BaseEntity {
    private Long userId;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private int totalPeople;

    protected ScheduleEntity() {
    }

    public ScheduleEntity(Long userId, LocalDateTime startAt, LocalDateTime endAt, int totalPeople) {
        this.userId = userId;
        this.startAt = startAt;
        this.endAt = endAt;
        this.totalPeople = totalPeople;
    }

    public Schedule toSchedule() {
        return new Schedule(
                this.getId(),
                this.userId,
                this.startAt,
                this.endAt,
                this.totalPeople
        );
    }
}
