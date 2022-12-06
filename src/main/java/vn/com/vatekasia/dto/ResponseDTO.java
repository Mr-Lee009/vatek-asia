package vn.com.vatekasia.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO<T> {
    private String errorCode;
    private String message;
    private T data;

}

