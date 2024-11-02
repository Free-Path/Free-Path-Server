package com.freepath.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freepath.support.response.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "헬스 체크")
@RestController
public class HealthController {

    @Operation(summary = "서버 상태 확인 API", description = "서버 상태를 확인합니다.")
    @GetMapping("/ping")
    public ApiResponse<String> check() {
        return ApiResponse.success("pong");
    }

}
