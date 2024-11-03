package com.freepath.schedule;

import com.freepath.BaseEntity;
import com.freepath.schedule.domain.NewSchedule;
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

    public ScheduleEntity(NewSchedule schedule) {
        this.userId = schedule.userId();
        this.startAt = schedule.startAt();
        this.endAt = schedule.endAt();
        this.totalPeople = schedule.totalPeople();
    }

    public Schedule toSchedule() {
        return new Schedule(this.getId(), this.userId, this.startAt, this.endAt, this.totalPeople);
    }

}
