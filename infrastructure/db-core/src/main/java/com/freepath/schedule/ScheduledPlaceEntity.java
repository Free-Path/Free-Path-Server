package com.freepath.schedule;

import com.freepath.BaseEntity;
import com.freepath.schedule.domain.NewScheduledPlace;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
@Table(name = "scheduled_place")
public class ScheduledPlaceEntity extends BaseEntity {
    private Long placeId;
    private Long scheduleId;
    private LocalDateTime scheduledAt;
    private int sequencePlace;

    protected ScheduledPlaceEntity() { }

    public ScheduledPlaceEntity(NewScheduledPlace scheduledPlace) {
        this.placeId = scheduledPlace.placeId();
        this.scheduleId = scheduledPlace.scheduleId();
        this.scheduledAt = scheduledPlace.scheduledAt();
        this.sequencePlace = scheduledPlace.sequencePlace();
    }
}
