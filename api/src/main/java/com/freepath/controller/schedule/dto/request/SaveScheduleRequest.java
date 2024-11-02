package com.freepath.controller.schedule.dto.request;

import com.freepath.schedule.dto.reqeust.SaveScheduleCoreRequest;
import java.util.List;

public record SaveScheduleRequest(List<Integer> age, List<String> disabilities, Integer totalPeople,
        List<DailyScheduleRequest> schedules) {
    // SaveScheduleRequest를 SaveScheduleCoreRequest로 변환하는 메서드
    public SaveScheduleCoreRequest toCoreRequest() {
        return new SaveScheduleCoreRequest(this.age, this.disabilities, this.totalPeople,
                this.schedules.stream().map(DailyScheduleRequest::toCoreRequest).toList());
    }
}
