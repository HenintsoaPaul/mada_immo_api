package mada_immo.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ApiError {
    private int code;
    private String message;
    private Map<String, String> details;
}
