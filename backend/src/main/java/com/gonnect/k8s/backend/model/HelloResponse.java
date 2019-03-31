package com.gonnect.k8s.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HelloResponse {
    private String message;
    private String source;
}
