package com.freepath.error;

public enum ErrorType {

    DEFAULT(ErrorKind.SERVER_ERROR, ErrorCode.F500, "예측하지 못한 문제가 발생했습니다.", ErrorLevel.ERROR),
    INVALID_REQUEST(ErrorKind.CLIENT_ERROR, ErrorCode.F400, "잘못된 요청입니다.", ErrorLevel.WARN),
    NOT_FOUND_DATA(ErrorKind.SERVER_ERROR, ErrorCode.F1000, "데이터를 찾을 수 없습니다.", ErrorLevel.INFO),

    NO_AUTHORIZATION(ErrorKind.CLIENT_ERROR, ErrorCode.F401, "인증정보가 필요한 요청입니다.", ErrorLevel.ERROR),
    INVALID_TOKEN(ErrorKind.CLIENT_ERROR, ErrorCode.F401, "유효하지 않은 토큰입니다.", ErrorLevel.ERROR),
    INVALID_ACCESS_TOKEN(ErrorKind.CLIENT_ERROR, ErrorCode.F401, "잘못된 액세스 토큰입니다.", ErrorLevel.ERROR),

    DUPLICATED_USER(ErrorKind.CLIENT_ERROR, ErrorCode.FA00, "이미 존재하는 유저입니다.", ErrorLevel.WARN),
    INVALID_KAKAO_TOKEN(ErrorKind.CLIENT_ERROR, ErrorCode.FA01, "유효하지 않은 카카오 토큰입니다.", ErrorLevel.ERROR);

    private final ErrorKind kind;

    private final ErrorCode code;

    private final String message;

    private final ErrorLevel level;

    ErrorType(ErrorKind kind, ErrorCode code, String message, ErrorLevel level) {
        this.kind = kind;
        this.code = code;
        this.message = message;
        this.level = level;
    }

    public ErrorKind getKind() {
        return kind;
    }

    public ErrorCode getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ErrorLevel getLevel() {
        return level;
    }

}
