package com.freepath.controller.schedule;

import com.freepath.controller.schedule.response.SchedulePeriodResponse;
import com.freepath.schedule.component.ScheduleService;
import com.freepath.schedule.domain.Schedule;
import com.freepath.support.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "여행 일정")
@RequiredArgsConstructor
@RequestMapping("/v1/schedules")
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Operation(summary = "여행 불가능한 날짜 조회")
    @GetMapping("/booked-dates/{month}")
    public ApiResponse<List<SchedulePeriodResponse>> getBookedDates(@PathVariable("month") Integer month) {
        List<Schedule> schedules = scheduleService.getBookedDates(month);
        List<SchedulePeriodResponse> schedulePeriodResponses = schedules.stream()
                .map(SchedulePeriodResponse::of)
                .collect(Collectors.toList());

        return ApiResponse.success(schedulePeriodResponses);
    }
}
