package com.freepath.schedule;

import com.freepath.BaseEntity;
import com.freepath.schedule.domain.NewScheduledDisability;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "scheduled_disability")
public class ScheduledDisabilityEntity extends BaseEntity {
    private Long scheduleId;
    private String disability;

    protected ScheduledDisabilityEntity() { }

    public ScheduledDisabilityEntity(NewScheduledDisability scheduledDisability) {
        this.scheduleId = scheduledDisability.scheduleId();
        this.disability = scheduledDisability.disability();
    }
}
