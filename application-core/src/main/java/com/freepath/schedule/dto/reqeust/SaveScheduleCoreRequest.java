package com.freepath.schedule.dto.reqeust;

import java.util.List;

public record SaveScheduleCoreRequest(
        List<Integer> age,
        List<String> disabilities,
        Integer totalPeople,
        List<DailyScheduleCoreRequest> schedules
) {
}
