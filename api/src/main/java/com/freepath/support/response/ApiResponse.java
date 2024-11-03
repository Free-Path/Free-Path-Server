package com.freepath.support.response;

import com.freepath.error.ErrorMessage;
import com.freepath.error.ErrorType;

public record ApiResponse<Data>(ResultType result, Data data, ErrorMessage error) {

    public static <Data> ApiResponse<Data> success(Data data) {
        return new ApiResponse<>(ResultType.SUCCESS, data, null);
    }

    public static <Data> ApiResponse<Data> error(ErrorType errorType, Object errorData) {
        return new ApiResponse<>(ResultType.ERROR, null, new ErrorMessage(errorType, errorData));
    }
}
